package main.pizzabot

import main.model.*
import main.parsers.FieldPointsParser
import main.parsers.FieldPointsParserImpl
import main.validator.DataValidatorImpl
import java.lang.Exception
import java.lang.StringBuilder
import kotlin.math.abs

class Pizzabot(
    var inputData: Array<String>,
    private val parser: FieldPointsParser = FieldPointsParserImpl(DataValidatorImpl()),
    private val result: StringBuilder = StringBuilder(),
    private val pizzaAction: PizzaAction = PizzaActionImpl(),
    private val movementAction: MovementAction = MovementActionImpl(),
) {
    private lateinit var field: Field

    init {
        try {
            field = parser.parseInputData(inputData)
        } catch (e: Exception) {
            println(e.message)
        }
    }

    fun run() {
        if (this::field.isInitialized) {
            startDelivery()
            showResult()
        }
    }

    fun getResult() = result.toString()

    private fun startDelivery() {
        var previousPoint = field.startPosition
        for (item in field.pointsList) {
            moveToPointX(previousPoint, item)
            moveToPointY(previousPoint, item)
            result.append(pizzaAction.drop())
            previousPoint = item
        }
    }

    private fun moveToPointX(previousPoint: Point, currentPoint: Point) {
        val wayX = previousPoint.x - currentPoint.x;
        if (wayX < 0) {
            repeat(abs(wayX)) {
                result.append(movementAction.moveEast())
            }
        } else if (wayX > 0) {
            repeat(wayX) {
                result.append(movementAction.moveWest())
            }
        }
    }

    private fun moveToPointY(previousPoint: Point, currentPoint: Point) {
        val wayY = previousPoint.y - currentPoint.y
        if (wayY < 0) {
            repeat(abs(wayY)) {
                result.append(movementAction.moveNorth())
            }
        } else if (wayY > 0) {
            repeat(wayY) {
                result.append(movementAction.moveSouth())
            }
        }
    }

    private fun showResult() {
        println("$result")
    }

}