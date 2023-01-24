package ru.samitin.cleantest.postexample.interface_adapters.data

import io.reactivex.Observable
import ru.samitin.cleantest.postexample.entities.User

interface UserDadaSource {
    val users: Observable<List<User?>?>?
}