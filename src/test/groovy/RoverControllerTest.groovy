import spock.lang.Specification

class RoverControllerTest extends Specification {

    def controller = new RoverController()

    def "receive input" () {
        given:
        def initial = new Rover(1,1,FACING.NORTH)
        def input = "fff"
        def expectedRover = new Rover(1,4, FACING.NORTH)

        when:
        def foo = controller.move(input, initial)

        then:
        foo == expectedRover
    }

}
