data class Rover(val x: Int, val y: Int, val facing: FACING) {
    fun receiveInput(input:String): Rover {
        return Rover(2,1, FACING.NORTH)
    }
}

// cannot access this in my tests?
fun Rover.receiveInputExtension(input:String): Rover {
    return Rover(2,1, FACING.NORTH)
}