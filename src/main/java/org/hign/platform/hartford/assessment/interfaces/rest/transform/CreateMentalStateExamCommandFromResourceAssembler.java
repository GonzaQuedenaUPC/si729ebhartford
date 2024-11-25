package org.hign.platform.hartford.assessment.interfaces.rest.transform;

import org.hign.platform.hartford.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.hartford.assessment.interfaces.rest.resources.CreateMentalStateExamResource;

/**
 * @summary
 * This class is responsible for transforming a CreateMentalStateExamResource
 * object into a CreateMentalStateExamCommand object.
 */
public class CreateMentalStateExamCommandFromResourceAssembler {
    /**
     * @summary
     * This method transforms a CreateMentalStateExamResource object into a
     * @param resource the CreateMentalStateExamResource object to transform
     * @return a CreateMentalStateExamCommand object
     */
    public static CreateMentalStateExamCommand toCommandFromResource(CreateMentalStateExamResource resource) {
        return new CreateMentalStateExamCommand(
                resource.patientId(),
                resource.examinerNationalProviderIdentifier(),
                resource.examDate(),
                resource.orientationScore(),
                resource.registrationScore(),
                resource.attentionAndCalculationScore(),
                resource.recallScore(),
                resource.languageScore()
        );
    }
}
