package test.workshop

/**
 * Created by hmaass on 28.06.14.
 * heavily inspired from http://groovykoans.org/
 */

class GroovyBeansTest extends GroovyTestCase {
    static class Customer {
        String email
        String name
        Cart cart
    }

    static class Cart {
        Date created_at
    }

    void test_01_customerHasGeneratedSetter() {
        // We can set properties directly in the constructor
        Customer customer = new Customer(name: "John", email: "JohnDoe@namics.com")

        // Let's test if setters are automatically created
        def setEmail = customer.metaClass.getMetaMethod("setEmail")
        def setUid = customer.metaClass.getMetaMethod("setUid")

        def hasEmailSetter = setEmail != null
        def hasUidSetter = setUid != null

        def iThinkThatEmailSetterExists
        def iThinkThatUidSetterExists
        // ------------ START EDITING HERE ----------------------
        iThinkThatEmailSetterExists = true
        iThinkThatUidSetterExists = false
        customer.email = "John_Doe@namics.com"
        // ------------ STOP EDITING HERE  ----------------------

        assert customer.email == "John_Doe@namics.com"
        assert hasEmailSetter == iThinkThatEmailSetterExists
        assert hasUidSetter == iThinkThatUidSetterExists
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

            // Hints:
            // The customer can be referenced by `delegate`.
            // Reuse the `sameDay` method.
            // ------------ START EDITING HERE ----------------------
            Date now = new Date()

            if (delegate?.cart?.created_at) {
                return sameDay(now, delegate.cart.created_at)
            }
            false
            // ------------ STOP EDITING HERE  ----------------------

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
