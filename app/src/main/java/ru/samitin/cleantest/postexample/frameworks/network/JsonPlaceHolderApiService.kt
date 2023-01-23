package ru.samitin.cleantest.postexample.frameworks.network

import io.reactivex.Observable
import retrofit2.http.GET
import ru.samitin.cleantest.postexample.frameworks.network.models.ApiUser

interface JsonPlaceHolderApiService {

    @GET("users")
    fun getUsers() : Observable<List<ApiUser>>
}