package ru.samitin.cleantest.postexample.interface_adapters.data

import io.reactivex.Observable
import io.reactivex.functions.Function
import ru.samitin.cleantest.postexample.entities.User
import ru.samitin.cleantest.postexample.use_cases.repositories.UserRepository

class UserRepositoryImpl(private val userDadaSource: UserDadaSource) : UserRepository {


    override val user: Observable<User?>?
        get() =userDadaSource.users
            ?.map(Function { users -> users[0] })
}