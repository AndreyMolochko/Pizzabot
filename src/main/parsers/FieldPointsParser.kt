package main.parsers

import main.model.Field

interface FieldPointsParser {
    fun parseInputData(inputData: Array<String>): Field
}