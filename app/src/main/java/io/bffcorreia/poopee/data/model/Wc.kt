package io.bffcorreia.poopee.data.model

import java.io.Serializable
import java.util.*

data class Wc(var createdAt: Date, var updatedAt: Date, var code: String?,
    var location: String, var price: Float, var photoUrl: String?, var avgRate: Float,
    var avgClean: Float, var avgPrivacy: Float, var avgStyle: Float,
    var reviews: ArrayList<Review>) : Serializable
