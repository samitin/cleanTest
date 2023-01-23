package ru.samitin.cleantest.postexample.interface_adapters

import ru.samitin.cleantest.postexample.use_cases.UseCaseInputPort

class Controller(private val useCaseInputPort: UseCaseInputPort) {

    fun processInput(inputData:String){useCaseInputPort.processInput(inputData)}
}