package org.hign.platform.hartford.personnel.domain.model.commands;

public record CreateExaminerCommand(String firstName, String lastName, String nationalProviderIdentifier) {
}
