import spock.lang.Specification

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

    def "fgh rover(2,2,n) receives input 'f' and moves to (2,3,n)"() {
        given:
        def rover = new Rover(2, 2, FACING.NORTH)

        when:
        rover.move("f")

        then:
        rover == new Rover(2,3,FACING.NORTH)
    }

}
