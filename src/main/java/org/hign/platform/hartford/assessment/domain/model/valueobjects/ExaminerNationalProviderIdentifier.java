package org.hign.platform.hartford.assessment.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

/**
 * Represents the National Provider Identifier (NPI) for an examiner.
 *
 * @param examinerNationalProviderIdentifier the NPI of the examiner
 * @summary This record encapsulates the NPI for an examiner, ensuring it is stored as a valid UUID string.
 */

@Embeddable
public record ExaminerNationalProviderIdentifier(String examinerNationalProviderIdentifier) {

    public ExaminerNationalProviderIdentifier(String examinerNationalProviderIdentifier) {
        this.examinerNationalProviderIdentifier = UUID.fromString(examinerNationalProviderIdentifier).toString();
    }
}
