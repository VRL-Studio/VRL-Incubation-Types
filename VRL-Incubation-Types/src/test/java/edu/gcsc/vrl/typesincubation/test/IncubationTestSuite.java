/// package's name
package edu.gcsc.vrl.typesincubation.test;

/// imports
import junit.framework.TestSuite;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author stephan
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({DoubleSlidersTests.class, FloatSlidersTests.class})

public class IncubationTestSuite {

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
}
