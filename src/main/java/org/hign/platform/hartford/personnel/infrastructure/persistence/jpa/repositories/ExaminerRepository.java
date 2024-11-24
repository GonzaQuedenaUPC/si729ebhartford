package org.hign.platform.hartford.personnel.infrastructure.persistence.jpa.repositories;

import org.hign.platform.hartford.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.hartford.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Examiner entity
 * @summary
 * This repository is used to interact with the database and perform operations on the Examiner entity
 */
@Repository
public interface ExaminerRepository extends JpaRepository<Examiner, Long> {
    /**
     * Check if an Examiner with the given National Provider Identifier exists
     * @param nationalProviderIdentifier the National Provider Identifier to check
     * @return true if an Examiner with the given National Provider Identifier exists, false otherwise
     */
    boolean existsByNationalProviderIdentifier(NationalProviderIdentifier nationalProviderIdentifier);
}
