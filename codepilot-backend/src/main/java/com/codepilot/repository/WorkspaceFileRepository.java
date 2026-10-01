package com.codepilot.repository;

import com.codepilot.core.domain.WorkspaceFile;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface WorkspaceFileRepository extends MongoRepository<WorkspaceFile, String> {
    Optional<WorkspaceFile> findByWorkspaceIdAndFilePath(String workspaceId, String filePath);
    List<WorkspaceFile> findByWorkspaceId(String workspaceId);
    void deleteByWorkspaceIdAndFilePath(String workspaceId, String filePath);
}
