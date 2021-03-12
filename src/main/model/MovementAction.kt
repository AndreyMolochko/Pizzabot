package main.model

interface MovementAction {
    fun moveNorth(): String
    fun moveSouth(): String
    fun moveEast(): String
    fun moveWest(): String
}