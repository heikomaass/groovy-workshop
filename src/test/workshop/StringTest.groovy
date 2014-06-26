package test.workshop

/**
 * Created by hmaass on 26.06.14.
 * heavily inspired from http://groovykoans.org/
 */
class StringTest extends GroovyTestCase {

    void test_01_GString_vs_String() {
        def conference = "Namics Conference"

        def welcomeString = ''
        def welcomeGString = ""

        // ------------ START EDITING HERE ----------------------
        welcomeString = 'Welcome to ${name}'
        welcomeGString = "Welcome to ${conference}"

        // ------------ STOP EDITING HERE  ----------------------
        assert welcomeString == 'Welcome to ${name}'
        assert welcomeGString == "Welcome to Namics Conference"
    }

    void test_02_GString_vs_String() {
        def conference = "Namics Conference"

        def s1 = "Welcome to ${conference}"
        def s2 = "Welcome to Namics Conference"

        def equal1 = s1 == s2
        def equal2 = s1.equals(s2)

        def expectedEqual1
        def expectedEqual2

        // ------------ START EDITING HERE ----------------------
        expectedEqual1 = true
        expectedEqual2 = false

        // ------------ STOP EDITING HERE  ----------------------

        assert equal1 == expectedEqual1
        assert equal2 == expectedEqual2
    }

    void test_03_StringMinus() {
        def welcome = "Welcome to Namics Conference Hotel"
        def corrected = welcome - "Hotel"

        // ------------ START EDITING HERE ----------------------
        corrected -= "Conference"
        corrected = corrected.trim()
        // ------------ STOP EDITING HERE  ----------------------
        assert corrected == "Welcome to Namics"
    }

    void test_04_StringRange() {
        def output = ""
        def range = "ab".."ad"
        for (s in range) {
            output += s
        }
        def expected
        // ------------ START EDITING HERE ----------------------
        expected = "abacad"
        // ------------ STOP EDITING HERE  ----------------------
        assert output == expected
    }
}
