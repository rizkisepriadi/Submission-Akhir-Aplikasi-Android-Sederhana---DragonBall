package com.example.dragonball

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DragonBall(
    var name : String ?= "",
    var thumbnail : Int ?= 0,
    var photo : Int ?= 0,
    var race : String ?= "",
    var height : Int ?= 0,
    var weight : Int ?= 0,
    var technique : String ?= "",
    var transfromation : String ?= "",
    var description : String ?= "",
    var references : String ?= ""
) : Parcelable
