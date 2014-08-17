package workshop

/**
 * Created by hmaass on 05.07.14.
 */
class K5Closures extends GroovyTestCase {

    void test_01_usingWith() {
        // The `with` method allows you to do a bunch of things with the same object
        StringBuffer stringBuffer = new StringBuffer("Hello World")

        stringBuffer.with {
            append("!")
        }
        assert stringBuffer.toString() == "Hello World!"

        // Now it's your turn, modify the StringBuffer, so that the next assert will pass.
        stringBuffer.with {
            // ------------ START EDITING HERE ----------------------
            reverse()
            append("?")
            // ------------ STOP EDITING HERE -----------------------
        }

        assert stringBuffer.toString() == "!dlroW olleH?";
    }

    void test_02_writeOwnMethodThatAcceptsClosure() {
        // In Groovy (and Ruby) there is a method on Integer called `times`
        // which executes the given closure n-times.
        // Example:
        def timesCalled = 0
        10.times { i ->
            println "times: ${i}"
            timesCalled++;
        }
        assert timesCalled == 10

        // Now we want to reimplement this functionality.
        // Hint: use `delegate` property to access the Integer instance.
        Integer.metaClass.timesIWant = { closure ->
            // ------------ START EDITING HERE ----------------------
            for (int i = 0; i < delegate; i++) {
                print "I want "
                closure(i)
            }
            // ------------ STOP EDITING HERE -----------------------
        }
        timesCalled = 0;
        10.timesIWant { i ->
            println "cookies: ${i}"
            timesCalled++;
        }
        assert timesCalled == 10
    }

    void test_03_understandingIt() {
        // Closures with a single argument provide the argument as the implicit `it` reference.
        // The next closure doesn't use this feature. It explicitly declares the `i` reference in the closure signature.
        def result = 0
        10.times { i ->
            result += i * 10
        }

        // So rewrite the closure above using the implicit `it` reference
        def resultFromRewrittenClosure = 0
        // ------------ START EDITING HERE ----------------------
        10.times {
            resultFromRewrittenClosure += it * 10
        }
        // ------------ STOP EDITING HERE -----------------------
        assert result == resultFromRewrittenClosure
    }

    class A {
        def message() {
            return "A"
        }
    }

    class B {
        def message() {
            return "B"
        }
    }
    void test_04_switchingDelegate_1() {
        // Closures come with three properties:
        // this:        instance of enclosing class, where the Closure is defined
        // owner:       enclosing object (`this` or surrounding Closure)
        // delegate:    defaults to `owner` but is changeable
        def result = "";

        def closure = {
            result = message()
        }

        // Set the delegate, so that the message() call will reach an instance of the B class.
        // ------------ START EDITING HERE ----------------------
        closure.delegate = new B()
        // ------------ STOP EDITING HERE -----------------------
        closure()
        assert result == "B"

        // Now change the delegate, so that the message() call will reach an instance of the A class.
        // ------------ START EDITING HERE ----------------------
        closure.delegate = new A()
        // ------------ STOP EDITING HERE -----------------------
        closure()
        assert result == "A"
    }


    void test_05_switchingDelegate_2() {
        def data = [x: 10, y: 20]

        // This closure refers to non-existing variables.
        def closure = {
            y = x + y
        }
        // You can fix this, when you set the delegate to an object which provide these variables.
        // ------------ START EDITING HERE ----------------------
        closure.delegate = data
        // ------------ STOP EDITING HERE -----------------------
        closure()
        assert data.y == 30
    }


    void test_06_nestingClosure() {
        def outerClosure = {
            // `this` refers to the `ClosureTest` instance.
            // and it is the owner of the outerClosure.
            assert owner == this

            // when nothing is changed, the `owner` is the delegate.
            // properties and methods will be dispatched to the delegate,
            // if they are not provided in the closure itself.
            assert owner == delegate


            def innerClosure = {
                // Now it's your turn. Find out what `owner`, `delegate` and `this` refer to.
                //
                // ------------ START EDITING HERE ----------------------
                assert this instanceof K5Closures
                assert owner instanceof Closure
                assert owner != this
                assert owner == delegate
                // ------------ STOP EDITING HERE -----------------------
            }
            innerClosure()
        }
        outerClosure();
    }
}
