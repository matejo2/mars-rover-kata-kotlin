import spock.lang.Specification
import spock.lang.Unroll

class RoverTest extends Specification {

    def "new rover can be initialized" () {
        expect:
        new Rover(1,1, FACING.NORTH)
    }

    def "rover(2,2,n) receives input 'f' and moves to (2,3,n)"() {
        given:
        def rover = new Rover(2, 2, FACING.NORTH)

        when:
        rover.moveForward()

        then:
        rover == new Rover(2,3,FACING.NORTH)
    }

    def "rover(2,2,n) receives input 'ff' and moves to (2,4,n)"() {
        given:
        def rover = new Rover(2, 2, FACING.NORTH)

        when:
        rover.move("f")

        then:
        rover == new Rover(2,3,FACING.NORTH)
    }

    @Unroll
    def "rover(1,1,#oldFacing) receives input 'r' and moves to (1,1,#newFacing)"() {
        given:
        def rover = new Rover(1, 1, oldFacing)

        when:
        rover.move("r")

        then:
        rover == new Rover(1,1,newFacing)

        where:
        oldFacing    | newFacing
        FACING.NORTH | FACING.EAST
        FACING.EAST  | FACING.SOUTH
        FACING.SOUTH | FACING.WEST
        FACING.WEST  | FACING.NORTH
    }

    @Unroll
    def "rover(1,1,#oldFacing) receives input 'l' and moves to (1,1,#newFacing)"() {
        given:
        def rover = new Rover(1, 1, oldFacing)

        when:
        rover.move("l")

        then:
        rover == new Rover(1,1, newFacing)

        where:
        oldFacing    | newFacing
        FACING.NORTH | FACING.WEST
        FACING.EAST  | FACING.NORTH
        FACING.SOUTH | FACING.EAST
        FACING.WEST  | FACING.SOUTH
    }

}
