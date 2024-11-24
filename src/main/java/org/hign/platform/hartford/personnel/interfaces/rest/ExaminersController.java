package org.hign.platform.hartford.personnel.interfaces.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hign.platform.hartford.personnel.domain.services.ExaminerCommandService;
import org.hign.platform.hartford.personnel.interfaces.rest.resources.CreateExaminerResource;
import org.hign.platform.hartford.personnel.interfaces.rest.resources.ExaminerResource;
import org.hign.platform.hartford.personnel.interfaces.rest.transform.CreateExaminerCommandFromResourceAssembler;
import org.hign.platform.hartford.personnel.interfaces.rest.transform.ExaminerResourceFromEntityAssembler;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST controller for managing examiners
 * @summary
 * This controller provides endpoints for managing examiners
 */
@RestController
@RequestMapping(value = "api/v1/examiners", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Examiners", description = "Endpoints for managing examiners")
public class ExaminersController {

    /**
     * Service for handling examiner commands
     */
    private final ExaminerCommandService examinerCommandService;

    /**
     * Constructor
     * @param examinerCommandService the service for handling examiner commands
     */
    public ExaminersController(ExaminerCommandService examinerCommandService) {
        this.examinerCommandService = examinerCommandService;
    }

    /**
     * Create a new examiner
     * @summary
     * Create a new examiner with the provided data
     * @param resource the data for creating the examiner
     * @return the created examiner
     */
    @PostMapping
    @Operation(summary = "Create a new examiner", description = "Create a new examiner with the provided data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Examiner created"),
            @ApiResponse(responseCode = "400", description = "Invalid data provided")
    })
    public ResponseEntity<ExaminerResource> createExaminer(@RequestBody CreateExaminerResource resource) {
        var command = CreateExaminerCommandFromResourceAssembler.toCommandFromResource(resource);
        var examiner = examinerCommandService.handle(command);

        if (examiner.isEmpty()) return ResponseEntity.badRequest().build();

        var createdExaminer = examiner.get();
        var examineResource = ExaminerResourceFromEntityAssembler.toResourceFromEntity(createdExaminer);

        return new ResponseEntity<>(examineResource, HttpStatus.CREATED);
    }
}
