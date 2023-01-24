package ru.samitin.cleantest.postexample.interface_adapters.presenters

import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import ru.samitin.cleantest.postexample.entities.User
import ru.samitin.cleantest.postexample.use_cases.interactors.UserInteractor

class UserPresenterImpl(
    private val view: UserPresenter.View,
    private val interactor: UserInteractor,
    private val subscribeOn: Scheduler,
    private val observeOn: Scheduler
) : UserPresenter {
    private var disposable: Disposable? = null
    override fun onStart() {
        view.showProgress()
        interactor.user
            ?.subscribeOn(subscribeOn)
            ?.observeOn(observeOn)
            ?.subscribe(UserObserver())
    }

    override fun onStop() {
        if (disposable != null) {
            disposable!!.dispose()
        }
    }

    override fun onUserAction() {
        // some logic
        view.showResult()
    }

    private inner class UserObserver : Observer<User?> {
        override fun onSubscribe(d: Disposable) {
            disposable = d
        }

        override fun onNext(user: User) {
            view.hideProgress()
            view.showUser(user)
        }

        override fun onError(e: Throwable) {
            view.hideProgress()
            view.showError()
        }

        override fun onComplete() {
            // empty
        }
    }
}