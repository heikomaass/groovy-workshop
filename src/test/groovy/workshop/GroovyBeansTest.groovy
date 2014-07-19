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


}
