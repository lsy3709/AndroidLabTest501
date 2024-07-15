package com.busanit501.androidlabtest501.ch18_3_pytorch_rest_test

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.busanit501.androidlabtest501.R
import com.busanit501.androidlabtest501.databinding.ActivityCh18PytorchDrfTestMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class Ch18PytorchDrfTestMainActivity : AppCompatActivity() {
    lateinit var binding: ActivityCh18PytorchDrfTestMainBinding
    companion object {
        private const val PICK_IMAGE_REQUEST = 1
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityCh18PytorchDrfTestMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    } //onCreate

    fun pickImage(view: View) {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val imageUri: Uri = data.data!!
            processImage(imageUri)
        }
    }

    private fun processImage(imageUri: Uri) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val bitmap = withContext(Dispatchers.IO) {
                    MediaStore.Images.Media.getBitmap(contentResolver, imageUri)
                }
                uploadImage(bitmap)
            } catch (e: IOException) {
                e.printStackTrace()
                Toast.makeText(this@Ch18PytorchDrfTestMainActivity, "Failed to load image", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun uploadImage(bitmap: Bitmap) {
        CoroutineScope(Dispatchers.Main).launch {
            val file = withContext(Dispatchers.IO) {
                convertBitmapToFile(bitmap)
            }

            val requestFile = RequestBody.create("image/*".toMediaTypeOrNull(), file)
            val body = MultipartBody.Part.createFormData("image", file.name, requestFile)

            val response = withContext(Dispatchers.IO) {
                try {
                    RetrofitClient.apiService.uploadImage(body).execute()
                } catch (e: Exception) {
                    null
                }
            }
            handleResponse(response)
        }
    }

    private fun handleResponse(response: Response<ResponseBody>?) {
        if (response != null && response.isSuccessful) {
            Log.d("lsy", "전달 성공")
            Toast.makeText(this, "Image uploaded successfully", Toast.LENGTH_SHORT).show()
            val responseBody = response.body()?.string()
            Log.d("lsy", responseBody ?: "No response body")

            // Assuming the response is in JSON format, parse it
            try {
                val jsonObject = JSONObject(responseBody)
                val predictedClassIndex = jsonObject.getInt("predicted_class_index")
                val predictedClassLabel = jsonObject.getString("predicted_class_label")
                val confidence = jsonObject.getDouble("confidence")

                // Set the result to the TextView
                val resultText = "Predicted Class Index: $predictedClassIndex\n" +
                        "Predicted Class Label: $predictedClassLabel\n" +
                        "Confidence: $confidence"
                binding.ch18PredictedResult.text = resultText
            } catch (e: JSONException) {
                e.printStackTrace()
                binding.ch18PredictedResult.text = "Failed to parse response"
            }
        } else {
            Log.d("lsy", "전달 실패")
            Toast.makeText(this, "Image upload failed", Toast.LENGTH_SHORT).show()
        }
    }

    private fun convertBitmapToFile(bitmap: Bitmap): File {
        val file = File(cacheDir, "image.jpg")
        try {
            val bos = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 50, bos)
            val bitmapData = bos.toByteArray()

            val fos = FileOutputStream(file)
            fos.write(bitmapData)
            fos.flush()
            fos.close()
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return file
    }
}