package com.example.pukaaradmin.Response

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ConnectUserResponse (var user : User) : Parcelable
@Parcelize
data class User(var therapist_profile: TherapistProfiles): Parcelable
@Parcelize
data class TherapistProfiles(var id: Int, var about: String, var city: String, var service_therapist_provider: String, var therapist_focus: String, var type_of_doctor: String,var client:ArrayList<Client>) : Parcelable
@Parcelize
data class Client(var user: UserList) : Parcelable
@Parcelize
data class UserList(var id: Int,var first_name: String,var last_name: String,var mobile_number: String,var email: String,var created_at: String,var updated_at: String) : Parcelable

