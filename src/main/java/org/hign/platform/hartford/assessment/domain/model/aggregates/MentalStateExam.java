package org.hign.platform.hartford.assessment.domain.model.aggregates;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import org.hign.platform.hartford.assessment.domain.model.commands.CreateMentalStateExamCommand;
import org.hign.platform.hartford.assessment.domain.model.valueobjects.ExaminerNationalProviderIdentifier;
import org.hign.platform.hartford.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;

import java.util.Date;

@Entity
public class MentalStateExam extends AuditableAbstractAggregateRoot<MentalStateExam> {

    @NotNull
    private Long patientId;

    @NotNull
    @Embedded
    ExaminerNationalProviderIdentifier examinerNationalProviderIdentifier;

    @Getter
    @NotNull
    private Date examDate;

    @Getter
    @NotNull
    @Min(0)
    @Max(10)
    private Integer orientationScore;

    @Getter
    @NotNull
    @Min(0)
    @Max(3)
    private Integer registrationScore;

    @Getter
    @NotNull
    @Min(0)
    @Max(5)
    private Integer attentionAndCalculationScore;

    @Getter
    @NotNull
    @Min(0)
    @Max(3)
    private Integer recallScore;

    @Getter
    @NotNull
    @Min(0)
    @Max(9)
    private Integer languageScore;

    public MentalStateExam() {
    }

    public MentalStateExam(CreateMentalStateExamCommand command, Date examDate) {
        this.patientId = command.patientId();
        this.examinerNationalProviderIdentifier = new ExaminerNationalProviderIdentifier(
                command.examinerNationalProviderIdentifier());
        this.examDate = examDate;
        this.orientationScore = command.orientationScore();
        this.registrationScore = command.registrationScore();
        this.attentionAndCalculationScore = command.attentionAndCalculationScore();
        this.recallScore = command.recallScore();
        this.languageScore = command.languageScore();
    }

    public String getExaminerNationalProviderIdentifier() {
        return examinerNationalProviderIdentifier.examinerNationalProviderIdentifier();
    }
}
