package test

import main.exceptions.Error
import main.model.Point
import main.validator.DataValidatorImpl
import org.junit.Test
import kotlin.test.assertEquals

internal class DataValidatorTest {

    val pizzabotDataValidator = DataValidatorImpl()

    @Test
    fun `after passing an empty array return empty data error`() {
        try {
            pizzabotDataValidator.isNotEmptyInputData(arrayOf())
        } catch (e: Exception) {
            assertEquals(e.message, Error.EMPTY_DATA.message)
        }
    }

    @Test
    fun `after passing a not empty array return true`() {
        val result = pizzabotDataValidator.isNotEmptyInputData(arrayOf("5x5 (1, 4) (2, 3)"))
        assertEquals(result, true)
    }

    @Test
    fun `after passing an empty field size return wrong format error`() {
        try {
            pizzabotDataValidator.isValidFieldSize(null)
        } catch (e: Exception) {
            assertEquals(e.message, Error.WRONG_FORMAT.message)
        }
    }

    @Test
    fun `after passing a negative field size return negative field sizes error`() {
        try {
            pizzabotDataValidator.isValidFieldSize(-2)
        } catch (e: Exception) {
            assertEquals(e.message, Error.NEGATIVE_FIELD_SIZES.message)
        }
    }

    @Test
    fun `after passing a correct field size return true`() {
        val result = pizzabotDataValidator.isValidFieldSize(2)
        assertEquals(result, true)
    }

    @Test
    fun `after passing an empty point return wrong format error`() {
        try {
            pizzabotDataValidator.isValidPoint(null)
        } catch (e: Exception) {
            assertEquals(e.message, Error.WRONG_FORMAT.message)
        }
    }

    @Test
    fun `after passing a negative point return negative points error`() {
        try {
            pizzabotDataValidator.isValidPoint(-2)
        } catch (e: Exception) {
            assertEquals(e.message, Error.NEGATIVE_POINTS.message)
        }
    }

    @Test
    fun `after passing a correct point return true`() {
        val result = pizzabotDataValidator.isValidPoint(2)
        assertEquals(result, true)
    }

    @Test
    fun `after passing a point, that has x more than x field size return wrong format point error`() {
        val pointsList = listOf(Point(5, 3), Point(1, 4))
        try {
            pizzabotDataValidator.isValidPointsFormat(pointsList, 4, 4)
        } catch (e: Exception) {
            assertEquals(e.message, Error.WRONG_FORMAT_POINT.message)
        }
    }

    @Test
    fun `after passing a point, that has y more than y field size return wrong format point error`() {
        val pointsList = listOf(Point(5, 3), Point(1, 4))
        try {
            pizzabotDataValidator.isValidPointsFormat(pointsList, 5, 3)
        } catch (e: Exception) {
            assertEquals(e.message, Error.WRONG_FORMAT_POINT.message)
        }
    }

    @Test
    fun `after passing a point, that has x and y less than x and y field size return true`() {
        val pointsList = listOf(Point(3, 3), Point(1, 4))
        val result = pizzabotDataValidator.isValidPointsFormat(pointsList, 5, 5)
        assertEquals(result, true)
    }

}