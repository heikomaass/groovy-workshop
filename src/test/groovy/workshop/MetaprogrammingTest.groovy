package workshop

/**
 * Created by hmaass on 13.07.14.
 */
class A {
    // Make sure that the A class will return "hello" on the hello method
    // by implementing the `methodMissing` method.
    def methodMissing(String name, args) {
        // ------------ START EDITING HERE ----------------------
        def impl = { Object[] vargs ->
            return name;
        }
        impl(args)
        // ------------ STOP EDITING HERE -----------------------
    }
}

class B {
    String customerId
    Integer loginCount;

}

class MetaprogrammingTest extends GroovyTestCase {

    public void test_01_methodMissing() {
        A a = new A();
        def hello = a.hello()
        assert hello == "hello"
    }

    public void test_02_accessingProperties() {
        def b = new B(customerId: "A123", loginCount: 3);

        // Groovy allows to access properties statically as seen below.
        def accessDirectly = b.customerId;

        // In addition you can access the properties also dynamically using the index [] and the dot . operator.
        def accessViaIndexOperatorAndString;
        def accessViaDotOperatorWithString

        // ------------ START EDITING HERE ----------------------
        accessViaIndexOperatorAndString = b['customerId']
        accessViaDotOperatorWithString = b.'customerId'
        // ------------ STOP EDITING HERE -----------------------

        assert accessDirectly == "A123"
        assert accessViaIndexOperatorAndString == accessDirectly
        assert accessViaDotOperatorWithString == accessDirectly
    }

}
