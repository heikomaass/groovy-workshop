package workshop

/**
 * Created by hmaass on 26.06.14.
 * heavily inspired from http://groovykoans.org/
 */
class StringTest extends GroovyTestCase {

    void test_01_GString_vs_String() {
        def conference = "Namics Conference"

        // Groovy supports string literals using '' and ""
        def welcomeString = ''
        def welcomeGString = ""

        // Set both string, so that the assert statement will succeed.
        // Use the ${expression} syntax when appropriate.

        // ------------ START EDITING HERE ----------------------
        welcomeString = 'Welcome to ${name}'
        welcomeGString = "Welcome to ${conference}"

        // ------------ STOP EDITING HERE -----------------------

        assert welcomeString == 'Welcome to ${name}'
        assert welcomeGString == "Welcome to Namics Conference"
    }

    void test_02_GString_vs_String() {
        def conference = "Namics Conference"

        def s1 = "Welcome to ${conference}"
        def s2 = "Welcome to Namics Conference"

        def equal1 = s1 == s2
        def equal2 = s1.equals(s2)

        // Which of both expressions will result to true ?
        def expectedEqual1
        def expectedEqual2

        // ------------ START EDITING HERE ----------------------
        expectedEqual1 = true
        expectedEqual2 = false
        // ------------ STOP EDITING HERE -----------------------

        assert equal1 == expectedEqual1
        assert equal2 == expectedEqual2
    }

    void test_03_StringMinus() {
        def welcome = "Welcome to Namics Conference Hotel"

        // The GString class overloads the minus operator.
        def corrected = welcome - "Hotel"

        // ------------ START EDITING HERE ----------------------
        corrected -= " Conference "
        // ------------ STOP EDITING HERE -----------------------
        assert corrected == "Welcome to Namics"
    }

    void test_04_StringRange() {
        def output = ""

        // We can use the Range operator (..) on Strings
        def range = "ab".."ad"
        for (s in range) {
            output += s
        }
        // So... what's the output ? Set this variable to true or false
        def iThinkOutputWillBe

        // ------------ START EDITING HERE ----------------------
        iThinkOutputWillBe = "abacad"
        // ------------ STOP EDITING HERE -----------------------

        assert output == iThinkOutputWillBe
    }
}
