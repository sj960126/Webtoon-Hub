package com.example.webtoon.utils

//문자열 json 형태인지
fun String?.isJsonObJect():Boolean =  this?.startsWith("{") == true && this?.endsWith("}")
//json 배열 형태인지
fun String?.isJsonArray():Boolean =  this?.startsWith("[") == true && this?.endsWith("]")
