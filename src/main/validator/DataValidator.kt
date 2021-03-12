package main.validator

import main.model.Point

interface DataValidator {
    fun isNotEmptyInputData(data: Array<String>): Boolean
    fun isValidPoint(number: Int?): Boolean
    fun isValidFieldSize(number: Int?): Boolean
    fun isValidPointsFormat(pointsList: List<Point>, fieldX: Int, fieldY: Int): Boolean
}