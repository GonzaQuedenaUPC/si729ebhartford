package org.hign.platform.hartford.personnel.interfaces.rest.resources;

/**
 * Resource to represent an examiner
 * @param id the id of the examiner
 * @param firstName the first name of the examiner
 * @param lastName the last name of the examiner
 * @param nationalProviderIdentifier the national provider identifier of the examiner
 */
public record ExaminerResource(Long id, String firstName, String lastName, String nationalProviderIdentifier) {
}
