package com.tutorials.kodecampgoals.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Goal(
    val id:Int,
    val title:String,
    val desc:String,
    val priority:Int,
    val dateCreated:String,
    val dateDue:String,
    val category: String
): Parcelable
