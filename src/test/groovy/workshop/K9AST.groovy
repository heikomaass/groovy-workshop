package workshop

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
	
}
