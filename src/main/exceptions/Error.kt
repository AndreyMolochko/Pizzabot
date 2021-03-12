package main.exceptions

enum class Error(val message: String) {
    WRONG_FORMAT("You have to enter data in correct format."),
    NEGATIVE_FIELD_SIZES("You have to enter positive field sizes."),
    EMPTY_DATA("You have to enter a data."),
    NEGATIVE_POINTS("You have to enter a point with positive coordinates."),
    WRONG_FORMAT_POINT("You have to enter a point with coordinates which less than field sizes.")
}