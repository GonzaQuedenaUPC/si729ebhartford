package org.hign.platform.hartford.assessment.interfaces.rest.resources;

/**
 * CreateMentalStateExamResource
 * @param patientId the id of the patient
 * @param examinerNationalProviderIdentifier the national provider identifier of the examiner
 * @param examDate the date of the exam
 * @param orientationScore the orientation score
 * @param registrationScore the registration score
 * @param attentionAndCalculationScore the attention and calculation score
 * @param recallScore the recall score
 * @param languageScore the language score
 */
public record CreateMentalStateExamResource(
        Long patientId,
        String examinerNationalProviderIdentifier,
        String examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {
}
