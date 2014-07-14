package test.workshop

import groovyx.net.http.*
import static groovyx.net.http.ContentType.*
import static groovyx.net.http.Method.*

/**
 * Created by Max Trense on 01.07.2014
 * heavily inspired from http://groovykoans.org/
 */

class RestApiTest extends GroovyTestCase {
	
	void test_01_GettingData() {
		def http = new HTTPBuilder('http://httpbin.org')
		def responseBody = http.request(GET, TEXT) {
	        // ------------ START EDITING HERE ----------------------
			uri.path = '/user-agent'
			headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
	        // ------------ STOP EDITING HERE  ----------------------
		}
		assert responseBody.readLines().join('\n') == '{\n  "user-agent": "Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4"\n}'
	}
	
	void test_01_GettingJson() {
		def http = new HTTPBuilder('http://httpbin.org')
		def json = http.request(GET, JSON) {
	        // ------------ START EDITING HERE ----------------------
			uri.path = '/user-agent'
			headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
	        // ------------ STOP EDITING HERE  ----------------------
		}
		assert json."user-agent" == 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'
	}
	
}
