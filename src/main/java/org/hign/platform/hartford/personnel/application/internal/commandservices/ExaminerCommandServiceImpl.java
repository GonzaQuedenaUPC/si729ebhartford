package org.hign.platform.hartford.personnel.application.internal.commandservices;

import org.hign.platform.hartford.personnel.domain.exceptions.DuplicateExaminerException;
import org.hign.platform.hartford.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.hartford.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.hartford.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.hartford.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.hartford.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Implementation of the ExaminerCommandService interface.
 * @summary
 * This class is responsible for handling the CreateExaminerCommand command.
 */
@Service
public class ExaminerCommandServiceImpl implements ExaminerCommandService {

    /**
     * Repository for Examiner entities.
     */
    private final ExaminerRepository examinerRepository;

    /**
     * Constructor for ExaminerCommandServiceImpl.
     * @param examinerRepository the repository for Examiner entities.
     */
    public ExaminerCommandServiceImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    /**
     * Handle the CreateExaminerCommand command.
     * @param command The command to create a new Examiner.
     * @return An optional Examiner entity.
     */
    @Override
    public Optional<Examiner> handle(CreateExaminerCommand command) {
        if (examinerRepository.existsByNationalProviderIdentifier(new NationalProviderIdentifier(command.nationalProviderIdentifier()))) {
            throw new DuplicateExaminerException(command.nationalProviderIdentifier());
        }

        var examiner = new Examiner(command);
        examinerRepository.save(examiner);
        return Optional.of(examiner);
    }
}
