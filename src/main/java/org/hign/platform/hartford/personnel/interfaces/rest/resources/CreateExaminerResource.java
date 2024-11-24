package org.hign.platform.hartford.personnel.interfaces.rest.resources;

/**
 * Resource to create an examiner
 * @param firstName the first name of the examiner
 * @param lastName the last name of the examiner
 * @param nationalProviderIdentifier the national provider identifier of the examiner
 */
public record CreateExaminerResource(String firstName, String lastName, String nationalProviderIdentifier) {
}
