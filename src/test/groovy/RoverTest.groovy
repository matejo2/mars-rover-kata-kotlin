import spock.lang.Specification

class RoverTest extends Specification {

    def "new rover can be initialized" () {
        expect:
        new Rover(1,1, FACING.NORTH)
    }
}
