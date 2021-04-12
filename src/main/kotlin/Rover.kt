data class Rover(var x: Int, var y: Int, var facing: FACING) {

    fun move(input: String): Rover {
         input.forEach { receiveInput(it) }
        // this.facing = FACING.WEST
        // receiveInput('f')
        //moveForward()
        return this
    }

    fun receiveInput(input: Char) {
        // change this rover
        return when {
            input == 'f' -> moveForward()
            input == 'b' -> moveBackward()
            input == 'l' -> turnLeft()
            input == 'r' -> turnRight()
            else -> return
        }
    }

    fun moveForward() {
        when (this.facing) {
            FACING.NORTH -> y += 1
            FACING.EAST -> this.x + 1
            FACING.SOUTH -> this.y - 1
            FACING.WEST -> this.x - 1
        }
    }

    private fun moveBackward() {
        TODO("Not yet implemented")
    }

    private fun turnLeft() {
        TODO("Not yet implemented")
    }

    private fun turnRight() {
        TODO("Not yet implemented")
    }
}
