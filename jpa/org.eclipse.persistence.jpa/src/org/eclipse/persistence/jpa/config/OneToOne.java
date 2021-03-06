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
 *     Guy Pelletier - initial API and implementation
 ******************************************************************************/
package org.eclipse.persistence.jpa.config;

/**
 * JPA scripting API implementation.
 *
 * @author Guy Pelletier
 * @since EclipseLink 2.5.1
 */
public interface OneToOne {

    public JoinColumn addJoinColumn();
    public JoinField addJoinField();
    public PrimaryKeyJoinColumn addPrimaryKeyJoinColumn();
    public Property addProperty();
    public OneToOne setAccess(String access);
    public AccessMethods setAccessMethods();
    public BatchFetch setBatchFetch();
    public Cascade setCascade();
    public OneToOne setCascadeOnDelete(Boolean cascadeOnDelete);
    public OneToOne setFetch(String fetch);
    public ForeignKey setForeignKey();
    public HashPartitioning setHashPartitioning();
    public OneToOne setId(Boolean id);
    public OneToOne setJoinFetch(String joinFetch);
    public JoinTable setJoinTable();
    public OneToOne setMappedBy(String mappedBy);
    public OneToOne setMapsId(String mapsId);
    public OneToOne setName(String name);
    public OneToOne setNonCacheable(Boolean nonCacheable);
    public OneToOne setOptional(Boolean optional);
    public OneToOne setOrphanRemoval(Boolean orphanRemoval);
    public OneToOne setPartitioned(String partitioned);
    public Partitioning setPartitioning();
    public PinnedPartitioning setPinnedPartitioning();
    public ForeignKey setPrimaryKeyForeignKey();
    public OneToOne setPrivateOwned(Boolean privateOwned);
    public RangePartitioning setRangePartitioning();
    public ReplicationPartitioning setReplicationPartitioning();
    public RoundRobinPartitioning setRoundRobinPartitioning();
    public OneToOne setTargetEntity(String targetEntity);
    public UnionPartitioning setUnionPartitioning();
    public ValuePartitioning setValuePartitioning();

}
