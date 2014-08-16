package workshop

import org.codehaus.groovy.runtime.GStringImpl

/**
 * Created by hmaass on 26.06.14.
 * heavily inspired from http://groovykoans.org/
 */
class K2StringHandling extends GroovyTestCase {

    void test_01_GString_vs_String() {
        def conference = "Namics Conference"

        // Groovy supports string literals using '' and ""
        def welcomeString = ''
        def welcomeGString = ""

        // Set both strings, so that the assert statement will pass.
        // Use the ${expression} syntax when appropriate.

        // ------------ START EDITING HERE ----------------------
        welcomeString = 'Welcome to ${conference}'
        welcomeGString = "Welcome to ${conference}"

        // ------------ STOP EDITING HERE -----------------------

        assert welcomeString == 'Welcome to ${conference}'
        assert welcomeGString == "Welcome to Namics Conference"
    }

    void test_02_GString_vs_String() {
        def conference = "Namics Conference"

        def s1 = "Welcome to ${conference}"
        def s2 = "Welcome to Namics Conference"

        assert s1.class == GStringImpl
        assert s2.class == String

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

    void test_04_regexp() {
        // You can use slashes as string delimiters:
        def example = /I am a string/

        // This is great for regular expressions, because you don't need to escape anything except '/'
        // Now, make the following asserts pass.

        def pattern
        // ------------ START EDITING HERE ----------------------
        pattern = /\d{4}/
        // ------------ STOP EDITING HERE -----------------------
        // ==~ will create a matcher automatically and checks if the left hand string matches.
        assert "2008" ==~ pattern
        assert "2014" ==~ pattern
    }
}
