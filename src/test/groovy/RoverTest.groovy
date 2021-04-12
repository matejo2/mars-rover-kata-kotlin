import spock.lang.Specification
import spock.lang.Unroll

class RoverTest extends Specification {

    def "new rover can be initialized"() {
        expect:
        new Rover(new Coordinates(1, 1), FACING.NORTH)
    }

    def "rover(2,2,n) receives input 'f' and moves to (2,3,n)"() {
        given:
        def rover = new Rover(new Coordinates(2, 2), FACING.NORTH)

        when:
        rover.move("f")

        then:
        rover.coordinates == new Coordinates(2, 3)
    }

    def "rover(2,2,n) invalid input 'u' and returns rover(2,2,n) "() {
        given:
        def rover = new Rover(new Coordinates(2, 2), FACING.NORTH)

        when:
        rover.move("u")

        then:
        rover.coordinates == new Coordinates(2, 2)
        rover.facing == FACING.NORTH
    }

    @Unroll
    def "try input #input for 0,0,North and get #expectedCor and #expectedFacing"() {
        given:
        def rover = new Rover(new Coordinates(0, 0), FACING.NORTH)

        when:
        rover.move(input)

        then:
        rover.coordinates == expectedCor
        rover.facing == expectedFacing

        where:
        input   | expectedCor            | expectedFacing
        "ff"    | new Coordinates(0, 2)  | FACING.NORTH
        "bbb"   | new Coordinates(0, -3) | FACING.NORTH
        "ffbb"  | new Coordinates(0, 0)  | FACING.NORTH
        "rfbr"  | new Coordinates(0, 0)  | FACING.SOUTH
        "fbfrb" | new Coordinates(-1, 1) | FACING.EAST
    }

    @Unroll
    def "go forward facing #facing"() {
        given:
        def rover = new Rover(new Coordinates(1, 1), facing)

        when:
        rover.move("f")

        then:
        rover.coordinates == coordinates
        rover.facing == facing

        where:
        coordinates           | facing
        new Coordinates(1, 2) | FACING.NORTH
        new Coordinates(2, 1) | FACING.EAST
        new Coordinates(1, 0) | FACING.SOUTH
        new Coordinates(0, 1) | FACING.WEST
    }

    @Unroll
    def "go backwards facing #facing"() {
        given:
        def rover = new Rover(new Coordinates(1, 1), facing)

        when:
        rover.move("b")

        then:
        rover.coordinates == coordinates
        rover.facing == facing

        where:
        coordinates           | facing
        new Coordinates(1, 0) | FACING.NORTH
        new Coordinates(0, 1) | FACING.EAST
        new Coordinates(1, 2) | FACING.SOUTH
        new Coordinates(2, 1) | FACING.WEST
    }

    @Unroll
    def "rover(1,1,#oldFacing) receives input 'r' and moves to (1,1,#newFacing)"() {
        given:
        def rover = new Rover(new Coordinates(1,1), oldFacing)

        when:
        rover.move("r")

        then:
        rover.facing == newFacing

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
        def rover = new Rover(new Coordinates(1,1), oldFacing)

        when:
        rover.move("l")

        then:
        rover.facing == newFacing

        where:
        oldFacing    | newFacing
        FACING.NORTH | FACING.WEST
        FACING.EAST  | FACING.NORTH
        FACING.SOUTH | FACING.EAST
        FACING.WEST  | FACING.SOUTH
    }

}
