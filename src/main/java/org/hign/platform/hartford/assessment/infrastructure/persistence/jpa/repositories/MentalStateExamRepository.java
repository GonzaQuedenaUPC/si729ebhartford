package org.hign.platform.hartford.assessment.infrastructure.persistence.jpa.repositories;

import org.hign.platform.hartford.assessment.domain.model.aggregates.MentalStateExam;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * MentalStateExamRepository
 * @summary
 * This interface is a repository for MentalStateExam entity.
 */
public interface MentalStateExamRepository extends JpaRepository<MentalStateExam, Long> {
}
