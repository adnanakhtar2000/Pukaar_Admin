package com.example.pukaaradmin.Fragments


data class DailyDiary_Responses(val data : DailyDiaryData,
                                val start_date : String,
                                val end_date : String)
data class DailyDiaryData (

    val current_page : Int,
    val data : List<Mood_Data>,
    val first_page_url : String,
    val from : Int,
    val last_page : Int,
    val last_page_url : String,
    val next_page_url : String,
    val path : String,
    val per_page : Int,
    val prev_page_url : String,
    val to : Int,
    val total : Int
)

data class Mood_Data(
    val id : Int,
    val mood : String,
    val anxiety : String,
    val energy : String,
    val self_confidence : String,
    val feeling : String,
    val status : String,
    val created_at : String,
    val updated_at : String,
)