package workshop

/**
 * Created by hmaass on 13.07.14.
 */
class UseMethodMissing {
    // ------------ START EDITING HERE ----------------------
    def methodMissing(String name, args) {
        def impl = { Object[] vargs ->
            return name;
        }
        impl(args)
    }
    // ------------ STOP EDITING HERE -----------------------
}

class MetaprogrammingTest extends GroovyTestCase {

    public void test_01_methodMissing() {
        UseMethodMissing a = new UseMethodMissing();
        def hello = a.hello()
        assert hello == "hello"
    }



}
