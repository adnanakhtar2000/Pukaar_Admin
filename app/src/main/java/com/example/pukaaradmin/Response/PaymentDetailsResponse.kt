package com.example.pukaaradmin.Response

data class PaymentDetailsResponse(val data : PaymentDetails)

data class PaymentDetails(
     val current_page : Int,
  val data : ArrayList<PaymentDetails_Data>,
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
data class PaymentDetails_Data (
    val id : Int,
    val cost : String,
    val picture : String,
    val  number_of_sessions : String,
    val session_status : String,
    val created_at : String,
    val paymentdetailsUser: PaymentDetails_User

)
data class PaymentDetails_User (

    val id : Int,
    val first_name : String,
    val last_name : String,
    val mobile_number : String,
    val email : String,
    val created_at : String,
    val updated_at : String
)