package workshop

import groovy.json.JsonBuilder

/**
 * Created by Max Trense on 03.07.1014
 */

class UsingJsonTest extends GroovyTestCase {

	def conferenceData = [
		conference: [
			place: 'Pforzheim',
			start: '21.08.2014',
			end: '23.08.2014',
			talks: [
				[
					name: 'Groovy Workshop',
                    duration: 90
				],
                [
                    name: "Java 8",
                    duration: 45
                ]
			]
		]
	]

	void test_01_generateJsonFromMap() {
        def builder

        // Use the JsonBuilder to create a Json object of the `conferenceData` map.
        // ------------ START EDITING HERE ----------------------
		builder = new JsonBuilder(conferenceData)
        // ------------ STOP EDITING HERE -----------------------

        def json = builder.toString()
        assert json == /{"conference":{"place":"Pforzheim","start":"21.08.2014","end":"23.08.2014","talks":[{"name":"Groovy Workshop","duration":90},{"name":"Java 8","duration":45}]}}/
	}

    void test_02_generateJsonWithClosures() {
        def builder = new JsonBuilder()

        def groovyTalk = new JsonBuilder()
        groovyTalk {
            name "Groovy Workshop"
            duration 90
        }
        assert groovyTalk.toString() == /{"name":"Groovy Workshop","duration":90}/

        def javaTalk = new JsonBuilder()
        javaTalk {
            name "Java 8"
            duration 45
        }
        assert javaTalk.toString() == /{"name":"Java 8","duration":45}/

        // ------------ START EDITING HERE ----------------------
        builder.conference {
            place "Pforzheim"
            start "21.08.2014"
            end "23.08.2014"
            talks groovyTalk.content, javaTalk.content
        }
        // ------------ STOP EDITING HERE -----------------------

        def json = builder.toString()

        assert json == /{"conference":{"place":"Pforzheim","start":"21.08.2014","end":"23.08.2014","talks":[{"name":"Groovy Workshop","duration":90},{"name":"Java 8","duration":45}]}}/

    }
}