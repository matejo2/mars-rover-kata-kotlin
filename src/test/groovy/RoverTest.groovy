import spock.lang.Ignore
import spock.lang.Specification
import spock.lang.Unroll

class RoverTest extends Specification {

    @Unroll
    def "can initialize rover with x=1 y = 1 and facing #foo"() {
        def rover = new Rover(1, 1, facing)
        expect:
        rover.getX() == 1
        rover.getY() == 1
        rover.getFacing() == facing

        where:
        facing       | foo
        FACING.NORTH | "north"
        FACING.EAST  | "east"
        FACING.SOUTH | "south"
        FACING.WEST  | "west"
    }

    def "can initialize rover with x=3 y = 4 and facing SOUTH"() {
        def rover = new Rover(3, 4, FACING.SOUTH)
        expect:
        rover.getX() == 3
        rover.getY() == 4
        rover.getFacing() == FACING.SOUTH
    }

    def "rover(2,2,n) receives input 'f' and moves to (2,3,n)"() {
        given:
        def rover = new Rover(2, 2, FACING.NORTH)

        when:
        def newRover = rover.receiveInput("f", rover)

        then:
        newRover.getX() == 2
        newRover.getY() == 3
        newRover.getFacing() == FACING.NORTH
    }

    def "rover(1,1,n) receives input 'b' and moves to (1,0,n)"() {
        given:
        def rover = new Rover(1, 1, FACING.NORTH)

        when:
        def newRover = rover.receiveInput("b", rover)

        then:
        newRover.getX() == 1
        newRover.getY() == 0
        newRover.getFacing() == FACING.NORTH
    }

    @Unroll
    def "rover(1,1,#oldFacing) receives input 'r' and moves to (1,1,#newFacing)"() {
        given:
        def rover = new Rover(1, 1, oldFacing)

        when:
        def newRover = rover.receiveInput("r", rover)

        then:
        newRover.getX() == 1
        newRover.getY() == 1
        newRover.getFacing() == newFacing

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
        def newRover = rover.receiveInput("l", rover)

        then:
        newRover.getX() == 1
        newRover.getY() == 1
        newRover.getFacing() == newFacing

        where:
        oldFacing    | newFacing
        FACING.NORTH | FACING.WEST
        FACING.EAST  | FACING.NORTH
        FACING.SOUTH | FACING.EAST
        FACING.WEST  | FACING.SOUTH
    }

    @Unroll
    def "go forward facing #given"() {
        given:
        def subjectForTest = given

        when:
        def newRover = subjectForTest.receiveInput("f", subjectForTest)

        then:
        newRover == expected

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
        def subjectForTest = given

        when:
        def newRover = subjectForTest.receiveInput("b", subjectForTest)

        then:
        newRover == expected

        where:
        given                         | expected
        new Rover(1, 1, FACING.NORTH) | new Rover(1, 0, FACING.NORTH)
        new Rover(1, 1, FACING.EAST)  | new Rover(0, 1, FACING.EAST)
        new Rover(1, 1, FACING.SOUTH) | new Rover(1, 2, FACING.SOUTH)
        new Rover(1, 1, FACING.WEST)  | new Rover(2, 1, FACING.WEST)
    }

}
