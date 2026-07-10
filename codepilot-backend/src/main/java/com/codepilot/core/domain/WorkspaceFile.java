package com.codepilot.core.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "workspace_files")
public record WorkspaceFile(
        @Id
        String id,
        String workspaceId,
        String filePath,
        String sha256,
        long fileSize,
        String language,
        Instant lastIndexedAt
) {

}
