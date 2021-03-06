/*******************************************************************************
 * Copyright (c) 1998, 2015 Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     Oracle - initial API and implementation from Oracle TopLink
 ******************************************************************************/
package org.eclipse.persistence.testing.tests.security;

import org.eclipse.persistence.exceptions.DescriptorException;
import org.eclipse.persistence.exceptions.EclipseLinkException;
import org.eclipse.persistence.internal.sessions.AbstractSession;
import org.eclipse.persistence.mappings.TransformationMapping;
import org.eclipse.persistence.sessions.Session;
import org.eclipse.persistence.sessions.remote.DistributedSession;
import org.eclipse.persistence.sessions.remote.corba.sun.CORBAConnection;
import org.eclipse.persistence.sessions.remote.corba.sun.CORBARemoteSessionControllerDispatcher;

//Created by Ian Reid
//Date: April 25, 2k3
public class SecurityWhileConvertingToMethodTest extends ExceptionTestSaveSecurityManager {

    private TransformationMapping mapping;

    public SecurityWhileConvertingToMethodTest(Class c) {
        super("This tests security while converting to method (TL-ERROR 85)", c);
    }

    protected void setup() {
        super.setup();
        expectedException = DescriptorException.securityWhileConvertingToMethod("getStartTime", mapping, new Exception());

        mapping = new TransformationMapping();
        mapping.setAttributeName("normalHours");
        mapping.setAttributeTransformation("buildNormalHours");
        mapping.addFieldTransformation("EMPLOYEE.START_TIME", "getStartTime");
        mapping.addFieldTransformation("EMPLOYEE.END_TIME", "getEndTime");
        // the following three lines ensure that the mapping is not isWriteOnly();
        mapping.setAttributeName(null);
        mapping.getAttributeAccessor().setAttributeName(null);
        mapping.setAttributeTransformation(null);
        mapping.setDescriptor(getTestDescriptor());
    }

    public void test() {
        try {
            //need to use the remote Initialization as the normal one would product TL-084 before check this test
            mapping.remoteInitialization((DistributedSession)(new CORBAConnection(new CORBARemoteSessionControllerDispatcher(getSession()))).createRemoteSession());
        } catch (EclipseLinkException exception) {
            caughtException = exception;
        }
    }

    static class ConvertMethod {
        public void buildNormalHours() {
            //do nothing security manager will cause error to occur
        }

        public String getEndTime(Session s) {
            //do nothing security manager will cause error to occur
            return "";
        }
    }

    static class ConvertMethodNoArg extends ConvertMethod {
        public String getStartTime() {
            //do nothing security manager will cause error to occur
            return "";
        }
    }

    static class ConvertMethodSession extends ConvertMethod {
        public void getStartTime(Session session) {
            //do nothing security manager will cause error to occur
        }
    }

    static class ConvertMethodAbstractSession extends ConvertMethod {
        public void getStartTime(AbstractSession session) {
            //do nothing security manager will cause error to occur
        }
    }
}
