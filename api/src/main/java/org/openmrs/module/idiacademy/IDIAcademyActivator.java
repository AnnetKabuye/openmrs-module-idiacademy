/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 * <p>
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.idiacademy;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openmrs.api.context.Context;
import org.openmrs.module.BaseModuleActivator;
import org.openmrs.module.idiacademy.activator.HtmlFormsInitializer;
import org.openmrs.module.idiacademy.activator.Initializer;
import org.openmrs.module.idiacademy.api.IdiAcademyMetaDataBundle;
import org.openmrs.module.metadatadeploy.api.MetadataDeployService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class contains the logic that is run every time this module is either started or shutdown
 */
public class IDIAcademyActivator extends BaseModuleActivator {
	
	private Log log = LogFactory.getLog(this.getClass());
	
	/**
	 * @see #started()
	 */
	public void started() {
		
		log.info("Deploying Metadata");
		MetadataDeployService metadataDeployService = Context.getService(MetadataDeployService.class);
		metadataDeployService.installBundle(Context.getRegisteredComponents(IdiAcademyMetaDataBundle.class).get(0));
		log.info("Started IDI Academy");
		
		for (org.openmrs.module.idiacademy.activator.Initializer initializer : getInitializers()) {
			try {
				initializer.started();
			}
			catch (IOException e) {
				log.error(e);
			}
		}
	}
	
	/**
	 * @see #shutdown()
	 */
	public void shutdown() {
		log.info("Shutdown IDI Academy");
	}
	
	private List<Initializer> getInitializers() {
		List<Initializer> initializers = new ArrayList<Initializer>();
		
		initializers.add(new HtmlFormsInitializer(IDIAcademyConfig.MODULE_ID));
		return null;
	}
	
}
