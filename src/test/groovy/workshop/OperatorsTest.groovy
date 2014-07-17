package workshop

/**
 * User: hmaass
 * Date: 17.07.14
 * Time: 16:47
 */
class OperatorsTest extends GroovyTestCase {

    class Spice {
        def scoville = 0

        // Add a `plus` implementation
        // ------------ START EDITING HERE ----------------------
        def plus(Spice s1) {
            return new Spice(scoville: s1.scoville + this.scoville)
        }
        // ------------ STOP EDITING HERE -----------------------
    }


    void test_01_operatorOverloading() {
        // Operators can be overloaded. See http://groovy.codehaus.org/Operator+Overloading
        def i = 2.plus(3);
        assert i == 5

        Spice peperoni = new Spice(scoville: 500)
        Spice tabasco = new Spice(scoville: 5000)
        Spice habaneros = new Spice(scoville: 100000)

        // Now add an own `plus` method in the `Spice` class
        Spice combined = peperoni + tabasco + habaneros
        assert combined.scoville == 105500


    }
}
