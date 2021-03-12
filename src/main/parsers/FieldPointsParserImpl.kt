package main.parsers

import main.model.Field
import main.model.Point
import main.validator.DataValidator
import java.util.regex.Pattern

class FieldPointsParserImpl(private val validator: DataValidator) : FieldPointsParser {
    override fun parseInputData(inputData: Array<String>): Field {
        validator.isNotEmptyInputData(inputData)
        val dataWithoutSpaces = inputData[0].replace("\"", "")
            .replace(" ", "") //remove extra symbols from input string
        val sizeX = getSizeXFieldFromString(dataWithoutSpaces)
        val sizeY = getSizeYFieldFromString(dataWithoutSpaces)
        val pointsList = getPointsListFromString(dataWithoutSpaces)
        validator.isValidPointsFormat(pointsList, sizeX, sizeY)
        return Field(sizeX, sizeY, pointsList)
    }

    private fun getSizeXFieldFromString(inputData: String): Int {
        val x = inputData.substringBefore("x").toIntOrNull()
        validator.isValidFieldSize(x)
        return x!!
    }

    private fun getSizeYFieldFromString(inputData: String): Int {
        val y = inputData.substringAfter("x").substringBefore('(').toIntOrNull()
        validator.isValidFieldSize(y)
        return y!!
    }

    private fun getPointsListFromString(inputData: String): List<Point> {
        val pointsList = mutableListOf<Point>()
        val regex = Pattern.compile("\\((.*?)\\)")
        val regexMatcher = regex.matcher(inputData)
        while (regexMatcher.find()) {
            val pointX = getPointXFromBrackets(regexMatcher.group())
            val pointY = getPointYFromBrackets(regexMatcher.group())
            pointsList.add(Point(pointX, pointY))
        }
        return pointsList
    }

    private fun getPointXFromBrackets(data: String): Int {
        val x = data.substringAfter('(').substringBefore(',').toIntOrNull()
        validator.isValidPoint(x)
        return x!!
    }

    private fun getPointYFromBrackets(data: String): Int {
        val y = data.substringAfter(',').substringBefore(')').toIntOrNull()
        validator.isValidPoint(y)
        return y!!
    }
}