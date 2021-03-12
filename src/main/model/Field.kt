package main.model

data class Field(
    val sizeX: Int,
    val sizeY: Int,
    val pointsList: List<Point>,
    val startPosition: Point = Point(0, 0)
)