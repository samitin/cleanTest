package ru.samitin.cleantest.postexample.use_cases

class UseCaseInteractor(private val useCaseOutputPort: UseCaseOutputPort) : UseCaseInputPort {

    override fun processInput(inputData: String) {
        val outputData = process(inputData)
        useCaseOutputPort.showOutput(outputData)
    }
    fun process(outputData: String):String{
        return outputData
    }
}