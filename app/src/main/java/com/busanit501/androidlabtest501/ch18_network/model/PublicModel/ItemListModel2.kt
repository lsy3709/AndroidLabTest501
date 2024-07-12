package com.busanit501.androidlabtest501.ch18_network.model.PublicModel

// 받아온 데이터 형식을 보고 정해야함.
// 중요함.

//{
//    "getFoodKr": {
//    "header": {
//    "code": "00",
//    "message": "NORMAL_CODE"
//},
//    "item": [
//    {
//        "UC_SEQ": 70,
//        "MAIN_TITLE": "만드리곤드레밥",
//        "GUGUN_NM": "강서구",
//        "LAT": 35.177387,
//        "LNG": 128.95245,
//        "PLACE": "만드리곤드레밥",
//        "TITLE": "만드리곤드레밥",
//        "SUBTITLE": "",
//        "ADDR1": "강서구 공항앞길 85번길 13",
//        "ADDR2": "",
//        "CNTCT_TEL": "051-941-3669",
//        "HOMEPAGE_URL": "",
//        "USAGE_DAY_WEEK_AND_TIME": "11:00-21:00",
//        "RPRSNTV_MENU": "돌솥곤드레정식, 단호박오리훈제",
//        "MAIN_IMG_NORMAL": "https://www.visitbusan.net/uploadImgs/files/cntnts/20191209162810545_ttiel",
//        "MAIN_IMG_THUMB": "https://www.visitbusan.net/uploadImgs/files/cntnts/20191209162810545_thumbL",
//        "ITEMCNTNTS": "곤드레밥에는 일반적으로 건조 곤드레나물이 사용되는데,\n이곳은 생 곤드레나물을 사용하여 돌솥밥을 만든다.\n된장찌개와 함께 열 가지가 넘는 반찬이 제공되는 돌솥곤드레정식이 인기있다\n"
//    },
//    {
//        "UC_SEQ": 72,
//        "MAIN_TITLE": "만호갈미샤브샤브",
class ItemListModel2 (
    // 변수명, 넘어온 데이터 변수명 일치하기.
    val getFoodKr : GetFoodKr
    )

class GetFoodKr (
    val item : List<ItemModel3>?
)

class ItemModel3 {
    var MAIN_TITLE : String? = null
    var TITLE : String? = null
    var MAIN_IMG_NORMAL : String? = null
}





