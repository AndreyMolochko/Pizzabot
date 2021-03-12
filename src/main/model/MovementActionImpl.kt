package main.model

class MovementActionImpl : MovementAction {
    override fun moveNorth() = "N"

    override fun moveSouth() = "S"

    override fun moveEast() = "E"

    override fun moveWest() = "W"
}