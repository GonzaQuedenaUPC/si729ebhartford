package org.hign.platform.hartford.assessment.application.internal.outboundservices.acl;

import org.hign.platform.hartford.personnel.interfaces.acl.PersonnelContextFacade;
import org.springframework.stereotype.Service;

/**
 * ExternalPersonalService
 * @summary
 * This class is responsible for handling the external personal service.
 */
@Service
public class ExternalPersonalService {

    /**
     * @summary
     * The personnel context facade is used to interact with the personnel context.
     */
    private final PersonnelContextFacade personnelContextFacade;

    /**
     * @summary
     * Constructor for the external personal service.
     * @param personnelContextFacade The personnel context facade.
     */
    public ExternalPersonalService(PersonnelContextFacade personnelContextFacade) {
        this.personnelContextFacade = personnelContextFacade;
    }

    /**
     * @summary
     * This method is used to check if the examiner exists.
     * @param examinerNationalProviderIdentifier The examiner national provider identifier.
     */
    public void existsExaminer(String examinerNationalProviderIdentifier) {
        personnelContextFacade.existsExaminer(examinerNationalProviderIdentifier);
    }
}
