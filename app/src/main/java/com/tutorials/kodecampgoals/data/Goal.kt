package com.tutorials.kodecampgoals.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Goal(
    val id:String = UUID.randomUUID().toString(),
    val title:String ="Goal title",
    val desc:String= "No description",
    val priority:Int = 1,
    val dateCreated:String ="",
    val dateDue:String = "",
    val category: String =""
): Parcelable
