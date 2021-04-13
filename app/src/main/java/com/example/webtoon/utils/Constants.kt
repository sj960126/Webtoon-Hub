package com.example.webtoon.utils

object Constants {
    const val  TAG: String = "로그"
}

enum class WEEBTOON_TYPE{
    NAVER,
    DAUM,
}
enum class DAY {
    SUN,
    MON,
    TUE,
    WED,
    THU,
    FRI,
    SAT,
    END,
}
enum class RESPONSE_STATE {
    OKAY,
    FAIL
}
object API {
    const val BASE_URL : String = "https://toy-projects-api.herokuapp.com"
    const val WebToon_URL : String = "/webtoon/info"
    const val WebToon_naver : String = "naver"
}