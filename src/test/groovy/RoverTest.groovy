import spock.lang.Specification

class RoverTest extends Specification{

    def "initial test" () {
        expect:
        true
    }

    def "can initialize rover with x=1 y = 1 and facing north" () {
        def rover = new Rover(1,1, "north")
        expect:
        rover.getX() == 1
        rover.getY() == 1
        rover.getFacing() == "north"
    }

}
