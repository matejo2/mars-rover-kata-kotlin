data class Rover(val x: Int, val y: Int, val facing: FACING) {

    fun receiveInput(input: String, rover: Rover): Rover {
        if (input.contentEquals("r")) {
            return turnRight(rover)
        }
        if (input.contentEquals("b")) {
            return moveBackwards(rover)
        }
        if (input.contentEquals("f")) {
            return moveForward(rover);
            // return Rover(rover.x, (rover.y+1), rover.facing)
        }
        return rover
//        when (input) {
//            input.equals("r") -> {return turnRight(rover)}
//            else -> return rover;
//        }
    }

    private fun moveForward(rover: Rover): Rover {
        return when (rover.facing) {
            FACING.NORTH -> Rover(rover.x, (rover.y + 1), rover.facing)
            FACING.EAST -> Rover((rover.x + 1), rover.y, rover.facing)
            FACING.SOUTH -> Rover(rover.x, (rover.y - 1), rover.facing)
            FACING.WEST -> Rover((rover.x - 1), rover.y, rover.facing)
        }
    }

    private fun moveBackwards(rover: Rover):Rover {
        return when (rover.facing) {
            FACING.NORTH -> Rover(rover.x, (rover.y - 1), rover.facing)
            FACING.EAST -> Rover((rover.x - 1), rover.y, rover.facing)
            FACING.SOUTH -> Rover(rover.x, (rover.y + 1), rover.facing)
            FACING.WEST -> Rover((rover.x + 1), rover.y, rover.facing)
        }
    }

    private fun turnRight(rover: Rover): Rover {
        if (rover.facing == FACING.WEST) {
            return Rover(rover.x, rover.y, FACING.values()[0])
        }
        return Rover(rover.x, rover.y, FACING.values()[rover.facing.ordinal + 1])
    }
}

// cannot access this in my tests?
fun Rover.receiveInputExtension(input: String): Rover {
    return Rover(2, 1, FACING.NORTH)
}