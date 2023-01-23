package ru.samitin.cleantest.postexample.interface_adapters

import ru.samitin.cleantest.postexample.use_cases.UseCaseOutputPort

class Presenter: UseCaseOutputPort {

    override fun showOutput(outputData: String) {
        showData(outputData)
    }
    fun showData(outputData: String){

    }
}