package workshop

import groovy.json.JsonBuilder
import groovy.xml.MarkupBuilder

/**
 * Created by Max Trense on 03.07.1014
 */

class BuilderTest extends GroovyTestCase {

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
}