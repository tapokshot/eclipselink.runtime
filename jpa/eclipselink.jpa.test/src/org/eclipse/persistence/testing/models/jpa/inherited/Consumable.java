/*******************************************************************************
 * Copyright (c) 2013, 2015  Oracle and/or its affiliates. All rights reserved.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 and Eclipse Distribution License v. 1.0
 * which accompanies this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *     tware - initial implementation
 ******************************************************************************/
package org.eclipse.persistence.testing.models.jpa.inherited;

import javax.persistence.MappedSuperclass;

import org.eclipse.persistence.testing.models.jpa.inheritance.GenericTestInterface1;

/**
 * This class was added as a test for bug 411560
 * @author tware
 *
 * @param <PK>
 */

@MappedSuperclass
public class Consumable<PK> implements GenericTestInterface1<PK>{


}
