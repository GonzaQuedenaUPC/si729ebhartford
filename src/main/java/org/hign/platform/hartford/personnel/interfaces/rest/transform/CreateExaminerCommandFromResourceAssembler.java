package org.hign.platform.hartford.personnel.interfaces.rest.transform;

import org.hign.platform.hartford.personnel.domain.model.commands.CreateExaminerCommand;
import org.hign.platform.hartford.personnel.interfaces.rest.resources.CreateExaminerResource;

/**
 * @summary
 * This class is responsible for transforming a {@link CreateExaminerResource} into a {@link CreateExaminerCommand}.
 */
public class CreateExaminerCommandFromResourceAssembler {
    /**
     * @summary
     * This method transforms a {@link CreateExaminerResource} into a {@link CreateExaminerCommand}.
     * @param resource The resource to transform.
     * @return The transformed command.
     */
    public static CreateExaminerCommand toCommandFromResource(CreateExaminerResource resource) {
        return new CreateExaminerCommand(
                resource.firstName(),
                resource.lastName(),
                resource.nationalProviderIdentifier()
        );
    }
}
