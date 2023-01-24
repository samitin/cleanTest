package ru.samitin.cleantest.postexample.frameworks.view

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.samitin.cleantest.R
import ru.samitin.cleantest.postexample.entities.User
import ru.samitin.cleantest.postexample.frameworks.network.UserRemoteDataSource
import ru.samitin.cleantest.postexample.interface_adapters.data.UserDadaSource
import ru.samitin.cleantest.postexample.interface_adapters.data.UserRepositoryImpl
import ru.samitin.cleantest.postexample.interface_adapters.presenters.UserPresenter
import ru.samitin.cleantest.postexample.interface_adapters.presenters.UserPresenterImpl
import ru.samitin.cleantest.postexample.use_cases.interactors.UserInteractor
import ru.samitin.cleantest.postexample.use_cases.interactors.UserInteractorImpl
import ru.samitin.cleantest.postexample.use_cases.repositories.UserRepository
import ru.samitin.cleantest.postexample.frameworks.network.JsonPlaceHolderApi as JsonPlaceHolderApi

class UserActivity : AppCompatActivity(), UserPresenter.View {
    var presenter: UserPresenter? = null
    private var progressBar: ProgressBar? = null
    private var textView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        progressBar = findViewById(R.id.progressBar)
        textView = findViewById(R.id.text)
        button.setOnClickListener { presenter?.onUserAction() }
        createPresenter()

    }

    private fun createPresenter() {
        val jsonPlaceHolderApi = JsonPlaceHolderApi()
        val dataSource: UserDadaSource = UserRemoteDataSource(jsonPlaceHolderApi)
        val userRepository: UserRepository = UserRepositoryImpl(dataSource)
        val userInteractor: UserInteractor = UserInteractorImpl(userRepository)
        presenter = UserPresenterImpl(this, userInteractor, Schedulers.io(), AndroidSchedulers.mainThread())
    }

    override fun onStart() {
        super.onStart()
        presenter?.onStart()
    }

    override fun showProgress() {
        progressBar!!.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progressBar!!.visibility = View.GONE
    }

    override fun showUser(user: User?) {
        Log.i(TAG, "showUser $user")
        textView?.setText(user?.name)
    }

    override fun showError() {
        textView!!.text = "Error!"
    }

    override fun showResult() {
        textView!!.text = "Result"
    }

    companion object {
        private const val TAG = "UserActivity"
    }
}
