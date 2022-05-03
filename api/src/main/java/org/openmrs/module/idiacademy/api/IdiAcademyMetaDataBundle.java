package org.openmrs.module.idiacademy.api;

import org.openmrs.module.metadatadeploy.bundle.AbstractMetadataBundle;
import org.openmrs.module.metadatadeploy.descriptor.EncounterTypeDescriptor;

public class IdiAcademyMetaDataBundle extends AbstractMetadataBundle {
	
	@Override
	public void install() throws Exception {
		install(SYPHILIS_APN_ENCOUNTER_TYPE);
	}
	
	public static EncounterTypeDescriptor SYPHILIS_APN_ENCOUNTER_TYPE = new EncounterTypeDescriptor() {
		
		@Override
		public String name() {
			return "Syphilis APN Encounter";
		}
		
		@Override
		public String description() {
			return "An encounter when a patient is positive for syphilis to track partners";
		}
		
		public String uuid() {
			return "249b4285-0b01-4a04-8a7b-4df3fdca587a";
		}
	};
}
