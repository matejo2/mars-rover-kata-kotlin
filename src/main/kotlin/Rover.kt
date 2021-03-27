data class Rover(val x: Int, val y: Int, val facing: FACING) {

    fun receiveInput(input: String, rover: Rover): Rover {
        if (input.contentEquals("r")) {
            if (rover.facing == FACING.WEST) {
                return Rover(rover.x, rover.y, FACING.NORTH)
            }
            var newFacing = FACING.values()[rover.facing.ordinal + 1]
            return Rover(rover.x, rover.y, newFacing)
        }

        if (input.contentEquals("b")) {
            return Rover((rover.x - 1), rover.y, rover.facing)
        }
        if (input.contentEquals("f")) {
            return Rover((rover.x + 1), rover.y, rover.facing)
        }
        return rover
    }
}

// cannot access this in my tests?
fun Rover.receiveInputExtension(input: String): Rover {
    return Rover(2, 1, FACING.NORTH)
}