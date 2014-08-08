package workshop

import groovy.json.JsonBuilder
import groovy.xml.MarkupBuilder
import groovyx.net.http.ContentEncoding
import groovyx.net.http.GZIPEncoding
import groovyx.net.http.HTTPBuilder

import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.TEXT
import static groovyx.net.http.Method.GET
import static groovyx.net.http.Method.GET

/**
 * Created by Max Trense on 03.07.1014
 */

class K8Builders extends GroovyTestCase {

    def conferenceData = [
            conference: [
                    place: 'Pforzheim',
                    start: '21.08.2014',
                    end  : '23.08.2014',
                    talks: ["Groovy Workshop", "Java 8"]
            ]
    ]

    void test_01_generateJsonFromMap() {
        // Use the JsonBuilder to create a Json object of the `conferenceData` map.
        def builder
        // ------------ START EDITING HERE ----------------------
        builder = new JsonBuilder(conferenceData)
        // ------------ STOP EDITING HERE -----------------------
        def json = builder.toString()
        assert json == /{"conference":{"place":"Pforzheim","start":"21.08.2014","end":"23.08.2014","talks":["Groovy Workshop","Java 8"]}}/
    }

    void test_02_generateJsonWithClosures() {
        // Now create a json using the closure technique.
        // For example consider http://beta.groovy-lang.org/docs/latest/html/gapi/groovy/json/JsonBuilder.html
        def builder = new JsonBuilder()
        // ------------ START EDITING HERE ----------------------
        builder.conference {
            place "Pforzheim"
            start "21.08.2014"
            end "23.08.2014"
            talks "Groovy Workshop", "Java 8"
        }
        // ------------ STOP EDITING HERE -----------------------

        def json = builder.toString()

        assert json == /{"conference":{"place":"Pforzheim","start":"21.08.2014","end":"23.08.2014","talks":["Groovy Workshop","Java 8"]}}/
        // The Groovy Builder is great but has one issue: Creation of lists with subobjects
        // isn't very intuitive see: http://evgeny-goldin.com/blog/groovy-jsonbuilder/
    }

    void test_03_generateXmlWithClosures() {
        // The MarkupBuilder allows easy XML creation
        // For example consider http://beta.groovy-lang.org/docs/latest/html/gapi/groovy/xml/MarkupBuilder.html
        def writer = new StringWriter()
        def builder = new MarkupBuilder(writer)
        // ------------ START EDITING HERE ----------------------
        builder.conference {
            place "Pforzheim"
            start "21.08.2014"
            end "23.08.2014"
            talks {
                ["Groovy Workshop", "Java 8"].each {
                    talk it
                }
            }
        }
        // ------------ STOP EDITING HERE -----------------------
        println writer
        assert writer.toString() ==
                '''<conference>
  <place>Pforzheim</place>
  <start>21.08.2014</start>
  <end>23.08.2014</end>
  <talks>
    <talk>Groovy Workshop</talk>
    <talk>Java 8</talk>
  </talks>
</conference>'''
    }

    void test_04_gettingJSONWithHTTPBuilder() {
        // HTTPBuilder allows to create HTTP requests easily.
        // The next example shows
        def googleSearch = new HTTPBuilder('http://ajax.googleapis.com')
        googleSearch.request(GET, JSON) {
            uri.path = '/ajax/services/search/web'
            uri.query = [v: '1.0', q: 'Calvin and Hobbes']
            headers.'User-Agent' = 'Mozilla/5.0 Ubuntu/8.10 Firefox/3.0.4'

            // response handler for a success response code
            response.success = { resp, json ->
                println resp.statusLine
                // parse the JSON response object:
                json.responseData.results.each {
                    println "  ${it.titleNoFormatting} : ${it.visibleUrl}"
                }
            }
            response.failure = { resp ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
            }
        }

        // Now create your
        def stackoverflowSearch = new HTTPBuilder("http://api.stackexchange.com/2.2")
        stackoverflowSearch.setContentEncoding(ContentEncoding.Type.GZIP)
        stackoverflowSearch.request(GET, JSON) {
            // Set the path to "/answers" and
            // Add the url query parameters:
            // "pagesize" to 10
            // "site" to "stackoverflow"
            // "sort" to "activity"
            // ------------ START EDITING HERE ----------------------
            uri.path = '/answers'
            uri.query = [site : "stackoverflow", pagesize: 10, sort:"activity"]
            // ------------ STOP EDITING HERE -----------------------
            response.success = { resp, json ->
                println resp.statusLine
                println json
                // fetch the "has_more" property from the json
                def has_more = false
                // ------------ START EDITING HERE ----------------------

                // ------------ STOP EDITING HERE -----------------------
                assert has_more == true
                assert json.items.size == 10
            }

            response.failure = { resp ->
                println "Unexpected error: ${resp.statusLine.statusCode} : ${resp.statusLine.reasonPhrase}"
            }
        }
    }
}
