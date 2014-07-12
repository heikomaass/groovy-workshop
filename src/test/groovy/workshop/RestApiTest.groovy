package workshop

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.Method.GET
import static groovyx.net.http.ContentType.TEXT
import static groovyx.net.http.ContentType.JSON

/**
 * Created by Max Trense on 01.07.2014
 * heavily inspired from http://groovykoans.org/
 */

class RestApiTest extends GroovyTestCase {

    void test_01_gettingData() {
        def http = new HTTPBuilder('http://httpbin.org')
        def responseBody = http.request(GET, TEXT) {
            // ------------ START EDITING HERE ----------------------
            uri.path = '/user-agent'
            headers.'User-Agent' = 'Fancy Useragent'
            // ------------ STOP EDITING HERE -----------------------
        }
        assert responseBody.readLines().join('\n') == '{\n  "user-agent": "Fancy Useragent"\n}'
    }

    void test_02_gettingJson() {
        def http = new HTTPBuilder('http://httpbin.org')
        def json = http.request(GET, JSON) {
            // ------------ START EDITING HERE ----------------------
            uri.path = '/user-agent'
            headers.'User-Agent' = 'Fancy Useragent'
            // ------------ STOP EDITING HERE -----------------------
        }
        assert json."user-agent" == 'Fancy Useragent'
    }

}
