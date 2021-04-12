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
            FACING.EAST -> x += 1
            FACING.SOUTH -> y -= 1
            FACING.WEST -> x -= 1
        }
    }

    private fun moveBackward() {
        when (this.facing) {
            FACING.NORTH -> y -= 1
            FACING.EAST -> x -= 1
            FACING.SOUTH -> y += 1
            FACING.WEST -> x += 1
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
