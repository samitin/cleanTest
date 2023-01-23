package ru.samitin.cleantest.postexample.frameworks.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ApiGeo (
    @SerializedName("lat" )
    @Expose
    var lat : String? = null,

    @SerializedName("lng" )
    @Expose
    var lng : String? = null
        )