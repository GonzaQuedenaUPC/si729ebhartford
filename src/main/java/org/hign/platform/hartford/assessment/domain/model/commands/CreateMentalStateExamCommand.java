package org.hign.platform.hartford.assessment.domain.model.commands;

public record CreateMentalStateExamCommand(Long patientId,
                                           String examinerNationalProviderIdentifier,
                                           String examDate,
                                           Integer orientationScore,
                                           Integer registrationScore,
                                           Integer attentionAndCalculationScore,
                                           Integer recallScore,
                                           Integer languageScore) {
}
