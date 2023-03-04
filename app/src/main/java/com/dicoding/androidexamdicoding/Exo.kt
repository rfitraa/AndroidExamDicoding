package com.dicoding.androidexamdicoding

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exo(
    var name: String? = null,
    var desc: String? = null,
    var photo: String? = null,
    var stageName: String? = null,
    var birthName: String? = null,
    var position: String? = null,
    var birthday: String? = null,
    var bloodType: String? = null,
    var mbti: String? = null,
    var insta: String? = null,
    var facts: String? = null,
):Parcelable
