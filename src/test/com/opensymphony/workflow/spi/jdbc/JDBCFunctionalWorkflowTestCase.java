/*
 * Copyright (c) 2002-2003 by OpenSymphony
 * All rights reserved.
 */
package com.opensymphony.workflow.spi.jdbc;

import com.opensymphony.workflow.TestWorkflow;
import com.opensymphony.workflow.spi.BaseFunctionalWorkflowTest;
import com.opensymphony.workflow.spi.DatabaseHelper;

import java.util.HashMap;


/**
 * This test case is functional in that it attempts to validate the entire
 * lifecycle of a workflow.  This is also a good resource for beginners
 * to OSWorkflow.  This leverages Hibernate as teh
 *
 * @author Eric Pugh (epugh@upstate.com)
 */
public class JDBCFunctionalWorkflowTestCase extends BaseFunctionalWorkflowTest {
    //~ Constructors ///////////////////////////////////////////////////////////

    public JDBCFunctionalWorkflowTestCase(String s) {
        super(s);
    }

    //~ Methods ////////////////////////////////////////////////////////////////

    public void testTrigger() throws Exception {
        String workflowName = getClass().getResource("/samples/scheduler.xml").toString();
        assertTrue("canInitialize for workflow " + workflowName + " is false", workflow.canInitialize(workflowName, 1));

        long id = workflow.initialize(workflowName, 1, new HashMap());
        Thread.sleep(500);
        assertEquals("trigger was not fired", workflow.getPropertySet(id).getString("testTrigger"), "blahblah");
    }

    protected void setUp() throws Exception {
        DatabaseHelper.createDatabase("src/etc/deployment/jdbc/mckoi.sql");
        TestWorkflow.configFile = "/osworkflow-jdbc.xml";
        super.setUp();
    }
}
