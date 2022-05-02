package org.openmrs.module.idiacademy.activator;

import java.io.IOException;

public interface Initializer {
	
	void started() throws IOException;
	
	void stopped();
}
