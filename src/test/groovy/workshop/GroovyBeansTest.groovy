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

        // If a class declares a member variable with no access modifier
        // the compiler generates a private field with public getter and setter (i.e. a property).

        // Now try to use the generated setter to make the assert pass.
        // ------------ START EDITING HERE ----------------------
        customer.setEmail("SusanDoe@namics.com")
        customer.setName("Susan")
        // ------------ STOP EDITING HERE -----------------------
        assert customer.email == "SusanDoe@namics.com"
        assert customer.name == "Susan"
    }

    void test_02_customerAccessModifierDoesntCreateMethods() {
        Customer customer = new Customer(name: "Jane", email: "JaneDoe@namics.com")

        // If the name is declared with an access modifier (public, private or protected) then a field is generated.
        // and not getter // setter

        // In order make the code below pass, go to the `Customer` class and add a setter and getter
        def now = new Date()
        customer.setBirthDate(now)

        assert customer.birthDate == now
    }

    void test_03_defaultPropertiesInConstructor() {
        // Groovy allows named parameters in the constructor
        Customer customer = new Customer(name: "John", email: "JohnDoe@namics.com")

        def customer2
        // Create a customer using named parameters.
        // ------------ START EDITING HERE ----------------------
        customer2 = new Customer(uid: 123, name: 'Jane')
        // ------------ STOP EDITING HERE -----------------------
        assert customer2.name == 'Jane'
        assert customer2.uid == 123

    }

}
