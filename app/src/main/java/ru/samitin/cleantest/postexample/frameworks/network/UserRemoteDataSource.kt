package ru.samitin.cleantest.postexample.frameworks.network

import io.reactivex.Observable
import io.reactivex.functions.Function
import ru.samitin.cleantest.postexample.entities.User
import ru.samitin.cleantest.postexample.frameworks.network.models.ApiUser
import ru.samitin.cleantest.postexample.interface_adapters.data.UserDadaSource

class UserRemoteDataSource(private val jsonPlaceHolderApi: JsonPlaceHolderApi) :
    UserDadaSource {
    override val users: Observable<List<User?>?>?
        get() = jsonPlaceHolderApi.getJsonPlaceHolderApiSerrvice().getUsers()
            .map(Function<List<ApiUser?>, List<User>?> { apiUsers ->
                val users: MutableList<User> = ArrayList(apiUsers.size)
                for (apiUser in apiUsers) {
                    users.add(
                        User(
                            apiUser?.name!!,
                            apiUser?.username!!,
                            apiUser?.email!!,
                            apiUser?.phone!!,
                            apiUser?.address?.city!!
                        )
                    )
                }
                users
            })


}
