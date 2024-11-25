package org.hign.platform.hartford.personnel.interfaces.acl;

/**
 * PersonnelContextFacade
 * @summary
 * This class is responsible for handling the personnel context facade.
 */
public interface PersonnelContextFacade {
    /**
     * @summary
     * This method is responsible for checking if the examiner exists.
     * @param examinerNationalProviderIdentifier The examiner national provider identifier.
     */
    void existsExaminer(String examinerNationalProviderIdentifier);
}
