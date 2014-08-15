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
	
}
