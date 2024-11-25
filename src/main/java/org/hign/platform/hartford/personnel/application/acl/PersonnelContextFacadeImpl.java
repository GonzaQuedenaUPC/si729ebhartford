package org.hign.platform.hartford.personnel.application.acl;

import org.hign.platform.hartford.personnel.domain.model.valueobjects.NationalProviderIdentifier;
import org.hign.platform.hartford.personnel.infrastructure.persistence.jpa.repositories.ExaminerRepository;
import org.hign.platform.hartford.personnel.interfaces.acl.PersonnelContextFacade;
import org.springframework.stereotype.Service;


/**
 * PersonnelContextFacadeImpl
 * @summary
 * This class is responsible for handling the personnel context facade implementation.
 */
@Service
public class PersonnelContextFacadeImpl implements PersonnelContextFacade {
    /**
     * ExaminerRepository the examiner repository
     */
    private final ExaminerRepository examinerRepository;

    /**
     * @summary
     * This constructor is responsible for initializing the personnel context facade implementation.
     * @param examinerRepository the examiner repository
     */
    public PersonnelContextFacadeImpl(ExaminerRepository examinerRepository) {
        this.examinerRepository = examinerRepository;
    }

    /**
     * @summary
     * This method is responsible for checking if the examiner exists.
     * @param examinerNationalProviderIdentifier The examiner national provider identifier.
     */
    @Override
    public void existsExaminer(String examinerNationalProviderIdentifier) {
        if (!examinerRepository.existsByNationalProviderIdentifier(new NationalProviderIdentifier(examinerNationalProviderIdentifier))) {
            throw new IllegalArgumentException("Examiner with NPI " + examinerNationalProviderIdentifier + " does not exist");
        }
    }
}