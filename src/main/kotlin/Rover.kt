class Rover(var coordinates: Coordinates, var facing: FACING) {

    fun move(input: String): Rover {
         input.forEach { receiveInput(it) }
        return this
    }

    private fun receiveInput(input: Char) {
        return when (input) {
            'f' -> moveForward()
            'b' -> moveBackward()
            'l' -> turnLeft()
            'r' -> turnRight()
            else -> return
        }
    }

    private fun moveForward() {
        when (this.facing) {
            FACING.NORTH -> coordinates.y += 1
            FACING.EAST -> coordinates.x += 1
            FACING.SOUTH -> coordinates.y -= 1
            FACING.WEST -> coordinates.x -= 1
        }
    }

    private fun moveBackward() {
        when (this.facing) {
            FACING.NORTH -> coordinates.y -= 1
            FACING.EAST -> coordinates.x -= 1
            FACING.SOUTH -> coordinates.y += 1
            FACING.WEST -> coordinates.x += 1
        }
    }

    private fun turnLeft() {
        facing = when(this.facing){
            FACING.NORTH -> FACING.WEST
            FACING.WEST -> FACING.SOUTH
            FACING.SOUTH -> FACING.EAST
            else -> FACING.NORTH
        }
    }

    private fun turnRight() {
        facing = when(this.facing) {
            FACING.NORTH -> FACING.EAST
            FACING.EAST -> FACING.SOUTH
            FACING.SOUTH -> FACING.WEST
            else -> FACING.NORTH
        }
    }
}
