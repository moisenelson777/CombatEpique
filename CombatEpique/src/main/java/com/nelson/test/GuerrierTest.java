package com.nelson.test;

import static org.junit.Assert.fail;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class GuerrierTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("Démarrage");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("Fermeture");
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
