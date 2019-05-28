package com.gk.ecart.DAOTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
public class UserDAOTest {
	private static final Logger LOG = LogManager.getLogger(UserDAOTest.class);

	@Test
	public void testing() {
		LOG.info("This Will Be Printed On Info");
	}

}
