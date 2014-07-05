package workshop

/**
 * Created by hmaass on 05.07.14.
 */
class ClosureTest extends GroovyTestCase{

    void test_01_settingDelegateUsingWith() {
        StringBuffer stringBuffer = new StringBuffer("Hello World")
        stringBuffer.with {
            append("!")
            reverse()
            append("?")
        }
        def expected = "!dlroW olleH?"

        // ------------ START EDITING HERE ----------------------
        assert stringBuffer.toString() == expected;
        // ------------ STOP EDITING HERE  ----------------------
    }

}
