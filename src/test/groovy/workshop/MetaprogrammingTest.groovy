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
    Integer customerId
    Integer loginCount;

}

class MetaprogrammingTest extends GroovyTestCase {

    public void test_01_methodMissing() {
        A a = new A();
        def hello = a.hello()
        assert hello == "hello"
    }

    public void test_02_accessingProperties() {
        def b = new B(customerId: 123, loginCount: 3);

        // Groovy allows to access properties statically as seen below.
        def accessDirectly = b.customerId;

        // In addition you can access the properties also dynamically using the index [] and the dot . operator.
        def accessViaIndexOperatorAndString;
        def accessViaDotOperatorWithString

        // ------------ START EDITING HERE ----------------------
        accessViaIndexOperatorAndString = b['customerId']
        accessViaDotOperatorWithString = b.'customerId'
        // ------------ STOP EDITING HERE -----------------------

        assert accessDirectly == 123
        assert accessViaIndexOperatorAndString == accessDirectly
        assert accessViaDotOperatorWithString == accessDirectly
    }

   public void test_03_addMethodToClassAtRuntime() {
       // Methods can be added at runtime using the MetaClass interface of a Java or Groovy class.
       B b = new B(customerId: 14, loginCount: 1)
       b.metaClass.fancyNewMethod = { ->
           println 'Wow, I was added at runtime'
       }

       b.fancyNewMethod()

       // Now it's your turn. Add the `increaseLoginCountBy` method, which increases the loginCount
       // property by the given integer value.
       // Hint: remeber the `delegate` variable in the closure ? You might need it.

       // ------------ START EDITING HERE ----------------------
       b.metaClass.increaseLoginCountBy = { Integer i ->
           delegate.loginCount += i
       }
       // ------------ STOP EDITING HERE -----------------------
       b.increaseLoginCountBy(5)
       assert b.loginCount == 6

   }

}
