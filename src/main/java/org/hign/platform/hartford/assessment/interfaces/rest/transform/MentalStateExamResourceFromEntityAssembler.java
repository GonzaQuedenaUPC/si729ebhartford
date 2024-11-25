package org.hign.platform.hartford.assessment.interfaces.rest.transform;

import org.hign.platform.hartford.assessment.domain.model.aggregates.MentalStateExam;
import org.hign.platform.hartford.assessment.interfaces.rest.resources.MentalStateExamResource;


public class MentalStateExamResourceFromEntityAssembler {
    /**
     * @summary
     * Converts a MentalStateExam entity to a MentalStateExamResource.
     * @param entity the MentalStateExam entity to convert
     * @return the converted MentalStateExamResource
     */
    public static MentalStateExamResource toResourceFromEntity(MentalStateExam entity) {
        return new MentalStateExamResource(
                entity.getId(),
                entity.getPatientId(),
                entity.getExaminerNationalProviderIdentifier(),
                entity.getExamDate(),
                entity.getOrientationScore(),
                entity.getRegistrationScore(),
                entity.getAttentionAndCalculationScore(),
                entity.getRecallScore(),
                entity.getLanguageScore()
        );
    }
}
