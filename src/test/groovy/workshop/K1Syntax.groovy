package workshop

import workshop.model.Car
import workshop.model.Customer

/**
 * User: hmaass
 * Date: 17.07.14
 * Time: 14:32
 */
class K1Syntax extends GroovyTestCase {

    void test_01_noSemicolonsNeeded() {

        def x = 4;
        def y = x * 4;
        def z1 = x * y; def z2 = x / y;

        assert z1 == 64
        assert z2 == 0.25

        z1 = 0; z2 = 0;

        // Now try to rewrite the code without semicolons. (You have to omit the `def` keyword, because the vars are already declared)
        // ------------ START EDITING HERE ----------------------
        x = 4
        y = x * 4
        z1 = x * y; z2 = x / y
        // ------------ STOP EDITING HERE -----------------------
        assert z1 == 64
        assert z2 == 0.25
    }

    void test_02_noParenthesisNeeded() {
        // Java Code
        Car car1 = new Car();
        car1.start();
        car1.move(2, 3);
        car1.move(5, 6);
        car1.stop();

        assert car1.position[0] == 7
        assert car1.position[1] == 9

        // Groovy allows to omit the parenthesis if there is at least one parameter and no ambiguity
        // Now start, and move the `car2` and prevent to use parenthesis where possible.
        def car2 = new Car()
        // ------------ START EDITING HERE ----------------------
        car2.start()
        car2.move 2,3
        car2.move 5,6
        car2.stop()
        // ------------ STOP EDITING HERE -----------------------

        assert car2.position[0] == 7
        assert car2.position[1] == 9
    }

    void test_03_noReturnIsNeeded() {
        def car = new Car()
        car.move(4,3)

        // Navigate to the `Car` class in the `model` package and
        // implement the `positionAsString` method on the `Car` class.
        // Prevent to use a `return` statement.
        assert car.positionAsString() == "4,3"
    }

    void test_04_arrayLiterals() {
        def list
        // create a list using the [] literal
        // ------------ START EDITING HERE ----------------------
        list = [3,2,2,4]
        // ------------ STOP EDITING HERE -----------------------
        assert list[0] == 3
        assert list[3] == 4
        assert list.size == 4

    }

    void test_05_truthy() {
        def list = []
        def string = ""
        def number = 0
        // ------------ START EDITING HERE ----------------------
        list = [3,2,2,4]
        string = "non empty"
        number = 1
        // ------------ STOP EDITING HERE -----------------------

        assert list
        assert string
        assert number
    }


    void test_06_accessingMaps() {
        def map = [
                cast: [
                        [name: 'Fred Flintstone', voice_actor: 'Alan Reed'],
                        [name: 'Barney Rubble', voice_actor: 'Mel Blanc']
                ]
        ]
        def first_actor = ''
        def second_actor = ''

        // ------------ START EDITING HERE ----------------------
        first_actor = map.cast[0].voice_actor
        second_actor = map.cast[1].voice_actor
        // ------------ STOP EDITING HERE -----------------------

        assert first_actor == 'Alan Reed'
        assert second_actor == 'Mel Blanc'
    }
    
    void test_07_switchStatements() {
        assert applySwitch("abc") == 1
        assert applySwitch("def") == 1
        
        assert applySwitch(4) == 3
        assert applySwitch(5) == 2
        assert applySwitch(10) == 2
        assert applySwitch(11) == 3
        
        assert applySwitch('123456') == 3
        assert applySwitch('467317') == 3
    }
    
    int applySwitch(arg) {
        switch (arg) {
            // ------------ START EDITING HERE ----------------------
            case 5..10:
                return 2
            case ~/^\d+$/:
                return 3
            case String:
                return 1
            // ------------ STOP EDITING HERE -----------------------
            default:
                return 0
        }
    }
    
}
