package com.flow.workflow.request.dto;

import java.util.Map;

public record SaveTaskRequestDTO (String name, String type, Map<String, Object> parameters, Long timeoutSeconds) {
}
