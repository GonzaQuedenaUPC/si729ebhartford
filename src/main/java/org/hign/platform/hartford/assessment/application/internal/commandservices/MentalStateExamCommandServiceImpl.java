package org.hign.platform.hartford.assessment.application.internal.commandservices;

import org.hign.platform.hartford.assessment.application.internal.outboundservices.acl.ExternalPersonalService;
import org.hign.platform.hartford.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.hartford.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.hartford.assessment.domain.services.MentalStateExamCommandService;
import org.hign.platform.hartford.assessment.infrastructure.persistence.jpa.repositories.MentalStateExamRepository;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

/**
 * MentalStateExamCommandServiceImpl
 * @summary
 * This class is responsible for handling the command services for the Mental State Exam.
 */
@Service
public class MentalStateExamCommandServiceImpl implements MentalStateExamCommandService {

    /**
     * @summary
     * This class is responsible for handling the command services for the Mental State Exam.
     */
    private final MentalStateExamRepository mentalStateExamRepository;
    private final ExternalPersonalService externalPersonalService;

    /**
     * @summary
     * This constructor is responsible for initializing the MentalStateExamCommandServiceImpl.
     * @param mentalStateExamRepository the mental state exam repository
     * @param externalPersonalService the external personal service
     */
    public MentalStateExamCommandServiceImpl(
            MentalStateExamRepository mentalStateExamRepository,
                                             ExternalPersonalService externalPersonalService) {
        this.mentalStateExamRepository = mentalStateExamRepository;
        this.externalPersonalService = externalPersonalService;
    }

    /**
     * @summary
     * This method is responsible for creating the mental state exam.
     * @param command the command to create the mental state exam
     * @return the created mental state exam
     */
    @Override
    public Optional<MentalStateExam> handle(CreateMentalStateExamCommand command) {
        externalPersonalService.existsExaminer(command.examinerNationalProviderIdentifier());

        var examDate = parseExamDate(command.examDate());

        if (examDate.before(new Date())) {
            throw new IllegalArgumentException("The exam date cannot be in the past.");
        }

        var mentalStateExam = new MentalStateExam(command, examDate);
        mentalStateExamRepository.save(mentalStateExam);
        return Optional.of(mentalStateExam);
    }

    /**
     * @summary
     * This method is responsible for parsing the exam date.
     * @param examDateString the exam date string
     * @return the exam date
     */
    private Date parseExamDate(String examDateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            return dateFormat.parse(examDateString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("The format " +
                    "of the exam date is invalid. It should be in the format yyyy-MM-dd.");
        }
    }
}
