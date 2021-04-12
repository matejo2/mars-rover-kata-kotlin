import spock.lang.Specification
import spock.lang.Unroll

class RoverTest extends Specification {

    def "new rover can be initialized"() {
        expect:
        new Rover(1, 1, FACING.NORTH)
    }

    def "rover(2,2,n) receives input 'ff' and moves to (2,4,n)"() {
        given:
        def rover = new Rover(2, 2, FACING.NORTH)

        when:
        rover.move("f")

        then:
        rover == new Rover(2, 3, FACING.NORTH)
    }

    @Unroll
    def "try input #input for #given and expect #expected"() {
        given:
        def rover = given

        when:
        rover.move(input)

        then:
        rover == expected

        where:
        input   | given                         | expected
        "ff"    | new Rover(0, 0, FACING.NORTH) | new Rover(0, 2, FACING.NORTH)
        "bbb"   | new Rover(0, 0, FACING.NORTH) | new Rover(0, -3, FACING.NORTH)
        "ffbb"  | new Rover(0, 0, FACING.NORTH) | new Rover(0, 0, FACING.NORTH)
        "rfbr"  | new Rover(0, 0, FACING.NORTH) | new Rover(0, 0, FACING.SOUTH)
        "fbfrb" | new Rover(0, 0, FACING.NORTH) | new Rover(-1, 1, FACING.EAST)
    }

    @Unroll
    def "go forward facing #given"() {
        given:
        def rover = given

        when:
        rover.move("f")

        then:
        rover == expected

        where:
        given                         | expected
        new Rover(1, 1, FACING.NORTH) | new Rover(1, 2, FACING.NORTH)
        new Rover(1, 1, FACING.EAST)  | new Rover(2, 1, FACING.EAST)
        new Rover(1, 1, FACING.SOUTH) | new Rover(1, 0, FACING.SOUTH)
        new Rover(1, 1, FACING.WEST)  | new Rover(0, 1, FACING.WEST)
    }

    @Unroll
    def "go backwards facing #given"() {
        given:
        def rover = given

        when:
        rover.move("b")

        then:
        rover == expected

        where:
        given                         | expected
        new Rover(1, 1, FACING.NORTH) | new Rover(1, 0, FACING.NORTH)
        new Rover(1, 1, FACING.EAST)  | new Rover(0, 1, FACING.EAST)
        new Rover(1, 1, FACING.SOUTH) | new Rover(1, 2, FACING.SOUTH)
        new Rover(1, 1, FACING.WEST)  | new Rover(2, 1, FACING.WEST)
    }

    @Unroll
    def "rover(1,1,#oldFacing) receives input 'r' and moves to (1,1,#newFacing)"() {
        given:
        def rover = new Rover(1, 1, oldFacing)

        when:
        rover.move("r")

        then:
        rover == new Rover(1, 1, newFacing)

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
        rover == new Rover(1, 1, newFacing)

        where:
        oldFacing    | newFacing
        FACING.NORTH | FACING.WEST
        FACING.EAST  | FACING.NORTH
        FACING.SOUTH | FACING.EAST
        FACING.WEST  | FACING.SOUTH
    }

}
