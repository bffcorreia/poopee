package io.bffcorreia.poopee.data.model

import java.io.Serializable

data class Review(var rate: Int, var clean: Int, var privacy: Int, var style: Int) : Serializable