package org.hign.platform.hartford.personnel.interfaces.rest.transform;

import org.hign.platform.hartford.personnel.domain.model.aggregates.Examiner;
import org.hign.platform.hartford.personnel.interfaces.rest.resources.ExaminerResource;

/**
 * @summary
 * This class is responsible for transforming an {@link Examiner} entity into an {@link ExaminerResource}.
 */
public class ExaminerResourceFromEntityAssembler {
    /**
     * @summary
     * This method transforms an {@link Examiner} entity into an {@link ExaminerResource}.
     * @param entity The entity to transform.
     * @return The transformed resource.
     */
    public static ExaminerResource toResourceFromEntity(Examiner entity) {
        return new ExaminerResource(
                entity.getId(),
                entity.getFirstName(),
                entity.getLastName(),
                entity.getNationalProviderIdentifier()
        );
    }
}
