package test.workshop

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
		def builder = new groovy.json.JsonBuilder(conferenceData)
		def json = builder.toString()
		assert json.contains('Pforzheim')
		assert json.contains('Heiko Maa\\u00df')
		assert json.contains('Max Trense')
	}


	
}