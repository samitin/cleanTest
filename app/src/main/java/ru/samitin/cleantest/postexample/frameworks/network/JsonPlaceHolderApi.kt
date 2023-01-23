package ru.samitin.cleantest.postexample.frameworks.network


import com.google.gson.Gson
import com.google.gson.GsonBuilder

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


class JsonPlaceHolderApi {

    fun getJsonPlaceHolderApiSerrvice():JsonPlaceHolderApiService{
        var gson :Gson = GsonBuilder().create()

        var retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(JsonPlaceHolderApiService::class.java)

    }
}