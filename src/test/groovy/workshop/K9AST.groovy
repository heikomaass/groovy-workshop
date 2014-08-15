package workshop

import java.text.SimpleDateFormat
import groovy.lang.Delegate
import groovy.transform.ToString

/**
 * Created by hmaass on 21.07.14.
 */
class K9AST extends GroovyTestCase {
	
	@ToString
	class Event {
		@Delegate Date when
		String title, url
	}
	
	def dateFormat = new SimpleDateFormat("dd.MM.yyyy")
	
	void test_01_synthesizeToString() {
		def nconf = new Event(title: 'Namics Conference', 
			                    url: 'http://www.namics.com/',
			                   when: dateFormat.parse('21.08.2014'))
		def nconfString = 'workshop.K9AST$Event(Thu Aug 21 00:00:00 CEST 2014, ...)'
		// ------------ START EDITING HERE ----------------------
		nconfString = 'workshop.K9AST$Event(Thu Aug 21 00:00:00 CEST 2014, Namics Conference, http://www.namics.com/)'
		// ------------ STOP EDITING HERE -----------------------
		assert nconf.toString() == nconfString
	}
	
	void test_02_delegationThroughTransformation() {
		def nconf = new Event(title: 'Namics Conference', 
			                    url: 'http://www.namics.com/',
			                   when: dateFormat.parse('21.08.2014'))
		def today = dateFormat.parse('23.08.2014')
		assert nconf.when.before(today)
		def obj
		// ------------ START EDITING HERE ----------------------
		obj = nconf
		// ------------ STOP EDITING HERE -----------------------
		assert obj?.before(today)
		assert obj?.title == 'Namics Conference'
	}
	
}
