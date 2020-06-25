package jp.co.kuromitsukinako.kawasakitakeoutinfomation.model

data class ShopData(
    var areaName: String,
    var shopname: String,
    var Genre: String,
    var isTakeOut:Boolean,
    var telephoneNo:String,
    var address:String,
    var lat :Double,
    var lon :Double,
    var site:String,
    var text:String
)
