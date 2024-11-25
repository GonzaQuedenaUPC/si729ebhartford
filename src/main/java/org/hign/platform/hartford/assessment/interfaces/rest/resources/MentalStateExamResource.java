package org.hign.platform.hartford.assessment.interfaces.rest.resources;

import java.util.Date;

/**
 * MentalStateExamResource
 * @summary
 * This class represents the Mental State Exam Resource.
 * @param id the id of the mental state exam
 * @param patientId the id of the patient
 * @param examinerNationalProviderIdentifier the national provider identifier of the examiner
 * @param examDate the date of the exam
 * @param orientationScore the orientation score
 * @param registrationScore the registration score
 * @param attentionAndCalculationScore the attention and calculation score
 * @param recallScore the recall score
 * @param languageScore the language score
 */
public record MentalStateExamResource(
        Long id,
        Long patientId,
        String examinerNationalProviderIdentifier,
        Date examDate,
        Integer orientationScore,
        Integer registrationScore,
        Integer attentionAndCalculationScore,
        Integer recallScore,
        Integer languageScore
) {
}