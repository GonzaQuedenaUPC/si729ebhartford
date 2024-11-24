package org.hign.platform.hartford.personnel.domain.services;

import org.hign.platform.hartford.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.hartford.personnel.domain.model.commands.CreateExaminerCommand;

import java.util.Optional;

/***
 * ExaminerCommandService
 * @summary
 * This interface defines the contract for the ExaminerCommandService.
 */
public interface ExaminerCommandService {
    /***
     * @summary
     * This method handles the creation of a new Examiner.
     * @param command The command to create a new Examiner.
     * @return An optional Examiner object.
     */
    Optional<Examiner> handle(CreateExaminerCommand command);
}
