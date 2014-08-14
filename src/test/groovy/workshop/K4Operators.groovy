package workshop

import workshop.model.Cart
import workshop.model.Customer
import workshop.model.Spice

/**
 * User: hmaass
 * Date: 17.07.14
 * Time: 16:47
 */
class K4Operators extends GroovyTestCase {

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

    void test_02_safeNavigationOperator() {
        // Groovy introduced the `Safe Navigation` operator (?.)
        // which returns an property of an object,
        // after an automatic null check
        Customer customer = new Customer()
        Date created_at = customer?.cart?.created_at
        assert created_at == null

        // Now create a method on Customer class which uses the `Safe Navigation` feature.
        // The method should return `true` when the customer has created a cart today.

        Customer hans = new Customer(name: "Hans")
        hans.cart = new Cart(created_at: new Date())

        Customer peter = new Customer(name: "Peter")

        assertTrue hans.createdCartToday()
        assertFalse peter.createdCartToday()
    }

    void test_03_rangeOperator() {
        def range = 0..1
        def character_range = 'A'..'B'
        // ------------ START EDITING HERE ----------------------
        range = 2..6
        // ------------ STOP EDITING HERE ----------------------
        assert range.size() == 5
        assert range[2] == 4
        
        // ------------ START EDITING HERE ----------------------
        character_range = 'A'..<'z'
        // ------------ STOP EDITING HERE ----------------------
        assert character_range.contains('[')
        assert character_range.contains('A')
        assert ! character_range.contains('z')
    }
}
