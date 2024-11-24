package org.hign.platform.hartford.personnel.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

import java.util.UUID;

/**
 * @summary
 * This class represents the National Provider Identifier (NPI) of a provider.
 * @param nationalProviderIdentifier The NPI of the provider.
 */
@Embeddable
public record NationalProviderIdentifier(String nationalProviderIdentifier) {
    /***
     * @summary
     * Constructor for the NationalProviderIdentifier class. It receives a string with the NPI of the provider.
     * @param nationalProviderIdentifier The NPI of the provider.
     */
    public NationalProviderIdentifier(String nationalProviderIdentifier) {
        this.nationalProviderIdentifier = UUID.fromString(nationalProviderIdentifier).toString();
    }
}
