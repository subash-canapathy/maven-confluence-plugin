package org.bsc.maven.reporting.test;
import java.io.File;

import org.apache.maven.plugin.Mojo;
import org.apache.maven.plugin.testing.AbstractMojoTestCase;
import org.bsc.maven.reporting.ConfluenceReportMojo;
import org.junit.Ignore;


@Ignore
public class ReportingMojoTest extends AbstractMojoTestCase {

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testFileName() {
            
            final String fileName = "a.wiki";
            
            String result = fileName.substring(0, fileName.length()-5);
            
            assertEquals("a", result);
        }
        
	public void testLookup() throws Exception  {

            File testPom = new File(getBasedir(), "/src/test/resources/test-pom.xml");

            //PlexusContainer container = createContainerInstance();

            assertNotNull("plexus container is null", getContainer());

            Mojo mojo = (Mojo) lookupMojo("confluence-summary", testPom);

            assertNotNull("mojo is null", mojo);
            assertTrue(mojo instanceof ConfluenceReportMojo);

            ConfluenceReportMojo confluenceMojo = (ConfluenceReportMojo) mojo;


            System.out.printf("properties=[%s]\n", confluenceMojo.getProperties());

	}
	
}
