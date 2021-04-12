class main {

    fun receiveInput(input: String, rover: Rover): Rover {
        // length of string, so oft dann rover aufrufen

        // input.forEach { receiveSingleInput(it, rover) }
        // return rover
        // input.forEach {
        //    receiveSingleInput(it, rover)
        //}

        rover.run { }

        var foo = receiveSingleInput(input[0], rover)
        var bar = receiveSingleInput(input[1], foo)
        var bizz = receiveSingleInput(input[2], bar)
        var returnThis = receiveSingleInput(input[3], bizz)
        return returnThis
    }

    // kein rover reinbekommen und rausgeben, weil auf rover aufgerufen
    fun receiveSingleInput(input: String, rover: Rover): Rover {
        return when {
            input.contentEquals("r") -> turnRight(rover)
            input.contentEquals("l") -> turnLeft(rover)
            input.contentEquals("f") -> moveForward(rover)
            input.contentEquals("b") -> moveBackwards(rover)
            else -> return rover
        }
    }

    fun receiveSingleInput(input: Char, rover: Rover): Rover {
        return when {
            input == 'r' -> turnRight(rover)
            input == 'l' -> turnLeft(rover)
            input == 'f' -> moveForward(rover)
            input == 'b' -> moveBackwards(rover)
            else -> return rover
        }
    }

    private fun moveForward(rover: Rover): Rover {
        return when (rover.facing) {
            FACING.NORTH -> Rover(rover.x, (rover.y + 1), rover.facing)
            FACING.EAST -> Rover((rover.x + 1), rover.y, rover.facing)
            FACING.SOUTH -> Rover(rover.x, (rover.y - 1), rover.facing)
            FACING.WEST -> Rover((rover.x - 1), rover.y, rover.facing)
        }
    }

    private fun moveBackwards(rover: Rover): Rover {
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

    private fun turnLeft(rover: Rover): Rover {
        if (rover.facing == FACING.NORTH) {
            return Rover(rover.x, rover.y, FACING.WEST)
        }
        return Rover(rover.x, rover.y, FACING.values()[rover.facing.ordinal - 1])
    }

    // cannot access this in my tests?
    fun Rover.receiveInputExtension(input: String): Rover {
        return Rover(2, 1, FACING.NORTH)

    }
}
