package ru.samitin.cleantest.postexample.use_cases.interactors

import io.reactivex.Observable
import ru.samitin.cleantest.postexample.entities.User
import ru.samitin.cleantest.postexample.use_cases.repositories.UserRepository

class UserInteractorImpl(private val userRepository: UserRepository) : UserInteractor {
    override val user: Observable<User?>
        get() = userRepository.user!!
}