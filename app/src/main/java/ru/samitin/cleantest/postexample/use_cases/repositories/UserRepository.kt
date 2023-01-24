package ru.samitin.cleantest.postexample.use_cases.repositories

import io.reactivex.Observable
import ru.samitin.cleantest.postexample.entities.User

interface UserRepository {
    val user: Observable<User?>?
}