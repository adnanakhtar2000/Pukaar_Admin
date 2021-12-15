package com.example.pukaaradmin.Response

import android.annotation.SuppressLint
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TherapistListResponse (var users : Users) : Parcelable
@Parcelize
data class Users(var current_page: String, var data: ArrayList<UsersData>, var to: Int, var total: Int): Parcelable
@Parcelize
data class UsersData(var id: Int, var first_name: String, var last_name: String, var mobile_number: String, var email : String,
var assigned_client: AssignedClient,var user_status: UserStatus,var therapist_profile: TherapistProfile ,var created_at: String,var updated_at: String): Parcelable
@Parcelize
data class AssignedClient(var id: Int, var first_name: String, var last_name: String, var mobile_number: String, var email : String,
var created_at: String,var updated_at: String,var user_status: UserStatus,var therapist_profile: TherapistProfile): Parcelable
@Parcelize
data class UserStatus(var id: Int, var name: String): Parcelable
@Parcelize
data class TherapistProfile(var id: Int, var about: String, var city: String, var service_therapist_provider: String, var therapist_focus: String, var type_of_doctor: String) : Parcelable



