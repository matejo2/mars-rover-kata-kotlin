import spock.lang.Specification
import spock.lang.Unroll

class RoverTest extends Specification {

    def "initial test"() {
        expect:
        true
    }

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

}
