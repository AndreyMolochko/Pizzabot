package main.validator

import main.exceptions.*
import main.model.Point

class DataValidatorImpl : DataValidator {
    override fun isNotEmptyInputData(data: Array<String>): Boolean {
        if (data.isNullOrEmpty()) {
            throw EmptyDataException(Error.EMPTY_DATA.message)
        } else {
            return true
        }
    }

    override fun isValidPoint(number: Int?): Boolean {
        if (number == null) {
            throw WrongFormatException(Error.WRONG_FORMAT.message)
        } else if (number < 0) {
            throw NegativePointException(Error.NEGATIVE_POINTS.message)
        }
        return true
    }

    override fun isValidFieldSize(number: Int?): Boolean {
        if (number == null) {
            throw WrongFormatException(Error.WRONG_FORMAT.message)
        } else if (number < 0) {
            throw NegativeSizeException(Error.NEGATIVE_FIELD_SIZES.message)
        }
        return true
    }

    override fun isValidPointsFormat(pointsList: List<Point>, fieldX: Int, fieldY: Int): Boolean {
        for (point in pointsList) {
            if (point.x > fieldX || point.y > fieldY) {
                throw WrongFormatPointException(Error.WRONG_FORMAT_POINT.message)
            }
        }
        return true
    }
}