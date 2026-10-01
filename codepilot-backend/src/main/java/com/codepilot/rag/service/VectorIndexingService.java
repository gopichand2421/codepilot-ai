package com.codepilot.rag.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class VectorIndexingService {

    // Simple code line-bound parser to demonstrate structured parsing
    public void indexFile(String workspaceId, String filePath, String rawCode, String language) {
        log.info("Generating semantic chunk boundaries for file: {}", filePath);

        List<CodeChunk> chunks = parseCodeChunks(filePath, rawCode);

        for (CodeChunk chunk : chunks) {
            // Placeholder simulation of actual Qdrant payload push
            // In a full setup, this converts chunks to Spring AI Document models
            // and saves them to the Qdrant VectorStore
            log.debug("Indexing Vector Code Chunk -> [{}]: lines {}-{}",
                    chunk.filePath(), chunk.startLine(), chunk.endLine());
        }
    }

    private List<CodeChunk> parseCodeChunks(String filePath, String rawCode) {
        List<CodeChunk> chunks = new ArrayList<>();
        String[] lines = rawCode.split("\r?\n");

        StringBuilder currentChunk = new StringBuilder();
        int startLine = 1;
        int maxLinesPerChunk = 25;

        for (int i = 0; i < lines.length; i++) {
            currentChunk.append(lines[i]).append("");
            if ((i + 1) % maxLinesPerChunk == 0 || i == lines.length - 1) {
                chunks.add(new CodeChunk(
                        UUID.randomUUID().toString(),
                        filePath,
                        currentChunk.toString(),
                        startLine,
                        i + 1
                ));
                currentChunk = new StringBuilder();
                startLine = i + 2;
            }
        }
        return chunks;
    }

    public record CodeChunk(
            String id,
            String filePath,
            String codeBlock,
            int startLine,
            int endLine
    ) {
    }
}