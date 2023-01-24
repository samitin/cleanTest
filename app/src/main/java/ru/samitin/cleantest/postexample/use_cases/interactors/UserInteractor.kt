package ru.samitin.cleantest.postexample.use_cases.interactors

import io.reactivex.Observable
import ru.samitin.cleantest.postexample.entities.User

interface UserInteractor {
    val user: Observable<User?>?
}