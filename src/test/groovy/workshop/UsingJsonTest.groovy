package workshop

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
					name: 'Groovy',
					speakers: [
						[
							name: 'Heiko Maaß',
							email: 'heiko.maass@namics.com'
						], [
							name: 'Max Trense',
							email: 'max.trense@namics.com'
						]
					]
				]
			]
		]
	]

	void test_01_generateJson() {
        def json

        // Use the JsonBuilder to create a Json object of the `conferenceData` map.
        // ------------ START EDITING HERE ----------------------
		def builder = new groovy.json.JsonBuilder(conferenceData)
		json = builder.toString()
        // ------------ STOP EDITING HERE -----------------------

		assert json.contains('Pforzheim')
		assert json.contains('Heiko Maa\\u00df')
		assert json.contains('Max Trense')
	}
}