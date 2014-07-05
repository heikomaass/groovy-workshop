package workshop

/**
 * Created by hmaass on 05.07.14.
 */
class ClosureTest extends GroovyTestCase{

    void test_01_usingWith() {
        StringBuffer stringBuffer = new StringBuffer("Hello World")
        stringBuffer.with {
            append("!")
            reverse()
            append("?")
        }

        def expected
        // ------------ START EDITING HERE ----------------------
        expected = "!dlroW olleH?"
        // ------------ STOP EDITING HERE  ----------------------

        assert stringBuffer.toString() == expected;
    }

    void test_02_writeOwnMethodThatAcceptsClosure() {

        // In Groovy (and Ruby) there is a method on Integer called `times`
        // which executes the given closure n-times.
        // Example:
        10.times { i ->
            println "times: ${i}"
        }


        // Now we want to reimplement this functionality.
        // Tip: use `delegate` to access the Integer value.
        Integer.metaClass.timesIWant = { closure ->
            // ------------ START EDITING HERE ----------------------
            for (int i = 0; i < delegate; i++) {
                print "I want "
                closure(i)
            }
            // ------------ STOP EDITING HERE  ----------------------
        }

        10.timesIWant { i ->
            println "cookies: ${i}"
        }
    }



}
