/**
 * Copyright 2013 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.nfsidecar.identity;

import java.util.Collection;
import java.util.List;

/**
 * Interface to manage membership meta information such as size of RAC, list of
 * nodes in RAC etc. Also perform ACL updates used in multi-regional clusters
 */
public interface IMembership
{
    /**
     * Get a list of Instances in the current RAC
     */
    public List<String> getRacMembership();
    
    /**
     * @return Get a list of Instances if there is a cross-account RAC
     */
    public List<String> getCrossAccountRacMembership();

    /**
     * @return Size of current RAC
     */
    public int getRacMembershipSize();
    
    /**
     * @return Size of the crossaccount RAC
     */
    public int getCrossAccountRacMembershipSize();

    /**
     * Add security group ACLs
     * 
     * @param listIPs
     * @param from
     * @param to
     */
    public void addACL(Collection<String> listIPs, int from, int to);

    /**
     * Remove security group ACLs
     * 
     * @param listIPs
     * @param from
     * @param to
     */
    public void removeACL(Collection<String> listIPs, int from, int to);

    /**
     * List all ACLs
     */
    public List<String> listACL(int from, int to);

    /**
     * Expand the membership size by 1.
     * 
     * @param count
     */
    public void expandRacMembership(int count);


}