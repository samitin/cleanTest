package ru.samitin.cleantest.postexample.frameworks.network.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ApiUser (
    @SerializedName("id"       )
    @Expose
    var id       : Int?     = null,

    @SerializedName("name"     )
    @Expose
    var name     : String?  = null,

    @SerializedName("username" )
    @Expose
    var username : String?  = null,

    @SerializedName("email"    )
    @Expose
    var email    : String?  = null,

    @SerializedName("address"  )
    @Expose
    var address  : ApiAddress? = ApiAddress(),

    @SerializedName("phone"    )
    @Expose
    var phone    : String?  = null,

    @SerializedName("website"  )
    @Expose
    var website  : String?  = null,

    @SerializedName("company"  )
    @Expose
    var company  : ApiCompany? = ApiCompany()
)