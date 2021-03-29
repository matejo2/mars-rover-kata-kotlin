data class Rover(val x: Int, val y: Int, val facing: FACING) {

    fun receiveInput(input: String, rover: Rover): Rover {
//        when (input) {
//            input.equals("r") -> {return turnRight(rover)}
//            else -> return rover;
//        }

        if (input.contentEquals("r")) {
            return turnRight(rover)
        }
        if (input.contentEquals("b")) {
            return Rover((rover.x - 1), rover.y, rover.facing)
        }
        if (input.contentEquals("f")) {
            return Rover((rover.x + 1), rover.y, rover.facing)
        }
        return rover
    }

    private fun turnRight(rover: Rover): Rover {
        if (rover.facing == FACING.WEST) {
            return Rover(rover.x, rover.y, FACING.values()[0])
        }
        return Rover(rover.x, rover.y, FACING.values()[rover.facing.ordinal+1])
    }
}

// cannot access this in my tests?
fun Rover.receiveInputExtension(input: String): Rover {
    return Rover(2, 1, FACING.NORTH)
}