package com.example.pukaaradmin.Response

data class Save_message(val id: Int , val reciever_id : String , val message :ArrayList<Message>  , val sender: ArrayList<Sender>  , val receiver: ArrayList<Receiver>  )
data class Message(val id: Int , val  parent_id : String , val message : String , val type : Int , val status : Int,
 val created_at: String , val updated_at: String)
data class Sender(val id: Int , val first_name : String , val last_name : String , val mobile_number : String ,
          val email : String , val created_at: String , val updated_at: String )
data class  Receiver(val id: Int , val first_name : String , val last_name : String , val mobile_number : String ,
                     val email : String , val created_at: String , val updated_at: String)
