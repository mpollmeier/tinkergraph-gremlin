/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.tinkerpop.gremlin.tinkergraph.structure.specialized.gratefuldead;

import org.apache.tinkerpop.gremlin.structure.Property;
import org.apache.tinkerpop.gremlin.structure.Vertex;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.SpecializedElementFactory;
import org.apache.tinkerpop.gremlin.tinkergraph.structure.SpecializedTinkerEdge;

import java.util.*;

public class SungBy extends SpecializedTinkerEdge {
    public static String label = "sungBy";

    public static Set<String> SPECIFIC_KEYS = new HashSet<>(Arrays.asList());

    public SungBy(Object id, Vertex outVertex, Vertex inVertex) {
        super(id, outVertex, label, inVertex, SPECIFIC_KEYS);
    }

    @Override
    protected <V> Property<V> specificProperty(String key) {
        return Property.empty();
    }

    @Override
    protected <V> Property<V> updateSpecificProperty(String key, V value) {
        throw new RuntimeException("property with key=" + key + " not (yet) supported by " + this.getClass().getName());
    }

    public static SpecializedElementFactory.ForEdge<SungBy> factory = new SpecializedElementFactory.ForEdge<SungBy>() {
        @Override
        public String forLabel() {
            return SungBy.label;
        }

        @Override
        public SungBy createEdge(Object id, Vertex outVertex, Vertex inVertex, Map<String, Object> keyValueMap) {
            return new SungBy(id, outVertex, inVertex);
        }
    };


}
