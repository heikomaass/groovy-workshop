package workshop

import workshop.model.Car
import workshop.model.Customer

/**
 * User: hmaass
 * Date: 17.07.14
 * Time: 14:32
 */
class SyntaxTest extends GroovyTestCase {

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
        car1.move(5, 6);
        car1.stop();

        assert car1.position[0] == 12
        assert car1.position[1] == 15

        // Groovy allows to omit the parenthesis if there is at least one parameter and no ambiguity
        // Now start, and move the `car2` and omit the parenthesis where possible.
        def car2 = new Car()
        // ------------ START EDITING HERE ----------------------
        car2.start()
        car2.move 2,3
        car2.move 5,6
        car2.move 5,6
        car2.stop()
        // ------------ STOP EDITING HERE -----------------------

        assert car2.position[0] == 12
        assert car2.position[1] == 15
    }

    void test_03_noReturnIsNeeded() {
        def car = new Car()
        car.move(4,3)

        // Implement the `positionAsString` method on the `Car` class and
        // don't use a `return` statement to make the following assert pass.
        assert car.positionAsString() == "4,3"
    }





}
