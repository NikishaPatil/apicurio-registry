/*
 * Copyright 2021 Red Hat
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.apicurio.registry.storage.impl.sql.mappers;

import io.apicurio.registry.storage.dto.ArtifactReferenceDto;
import io.apicurio.registry.storage.impl.sql.RegistryContentUtils;
import io.apicurio.registry.storage.impl.sql.jdb.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author eric.wittmann@gmail.com
 */
public class ArtifactReferenceDtoMapper implements RowMapper<ArtifactReferenceDto> {

    public static final ArtifactReferenceDtoMapper instance = new ArtifactReferenceDtoMapper();

    /**
     * Constructor.
     */
    private ArtifactReferenceDtoMapper() {
    }

    /**
     * @see io.apicurio.registry.storage.impl.sql.jdb.RowMapper#map(java.sql.ResultSet)
     */
    @Override
    public ArtifactReferenceDto map(ResultSet rs) throws SQLException {
        ArtifactReferenceDto dto = new ArtifactReferenceDto();
        dto.setGroupId(RegistryContentUtils.denormalizeGroupId(rs.getString("groupId")));
        dto.setArtifactId(rs.getString("artifactId"));
        dto.setVersion(rs.getString("version"));
        dto.setName(rs.getString("name"));
        return dto;
    }

}