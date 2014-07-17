package workshop

import workshop.model.Cart
import workshop.model.Customer

/**
 * Created by hmaass on 28.06.14.
 * heavily inspired from http://groovykoans.org/
 */

class GroovyBeansTest extends GroovyTestCase {

    void test_01_customerHasGeneratedSetter() {
        Customer customer = new Customer(name: "John", email: "JohnDoe@namics.com")
        assert customer.email == "JohnDoe@namics.com"
        assert customer.name == "John"

        // Use the generated setter methods to make the asserts pass.
        // ------------ START EDITING HERE ----------------------
        customer.setEmail("SusanDoe@namics.com")
        customer.setName("Susan")
        // ------------ STOP EDITING HERE -----------------------
        assert customer.email == "SusanDoe@namics.com"

    }

    void test_02_safeNavigationOperator() {
        Customer customer = new Customer()
        shouldFail(NullPointerException.class) {
            Date created_at = customer.cart.created_at
            // fails, because customer.cart is null
        }

        // Groovy introduced the `Safe Navigation` operator (?.)
        // which returns an property of an object,
        // after an automatic null check
        Date created_at = customer?.cart?.created_at
        assert created_at == null

        // Create a method on Customer which uses the `Safe Navigation` feature.
        // The method should return true when the customer has created a cart today.
        Customer.metaClass.createdCartToday = { ->

            // The customer can be referenced by `delegate`.
            // Reuse the `sameDay` method.
            // ------------ START EDITING HERE ----------------------
            Date now = new Date()

            if (delegate?.cart?.created_at) {
                return sameDay(now, delegate.cart.created_at)
            }
            false
            // ------------ STOP EDITING HERE -----------------------

        }
        Customer hans = new Customer(name: "Hans")
        hans.cart = new Cart(created_at: new Date())

        Customer peter = new Customer(name: "Peter")

        assertTrue hans.createdCartToday()
        assertFalse peter.createdCartToday()
    }

    def sameDay(Date date1, Date date2) {
        (date1..date2).size() == 1
    }

}
