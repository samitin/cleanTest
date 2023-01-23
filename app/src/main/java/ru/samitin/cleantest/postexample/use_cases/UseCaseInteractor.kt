package ru.samitin.cleantest.postexample.use_cases

class UseCaseInteractor(private val outputPort: UseCaseOutputPort) : UseCaseInputPort {

    override fun processInput(inputData: String) {
        val outputData = showOutput(inputData)
        outputPort.showOutput(outputData)
    }
    fun showOutput(outputData: String):String{
        return outputData
    }
}