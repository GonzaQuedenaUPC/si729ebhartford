package org.hign.platform.hartford.assessment.domain.services;

import org.hign.platform.hartford.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.hartford.assessment.domain.model.commands.CreateMentalStateExamCommand;

import java.util.Optional;

/**
 * Interface for the MentalStateExamCommandService
 * @summary
 * Command service for handling the creation of a mental state exam
 */
public interface MentalStateExamCommandService {
    /**
     * Handle the creation of a mental state exam
     * @param command the command to create the mental state exam
     * @return the created mental state exam
     */
    Optional<MentalStateExam> handle(CreateMentalStateExamCommand command);
}
