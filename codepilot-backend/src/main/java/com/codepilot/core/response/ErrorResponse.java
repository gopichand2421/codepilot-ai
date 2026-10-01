package com.codepilot.core.response;

import lombok.Builder;

import java.time.Instant;
import java.util.List;

@Builder
public record ErrorResponse(Instant timestamp, int status, String error, String message, String path, List<String> details) {
}
