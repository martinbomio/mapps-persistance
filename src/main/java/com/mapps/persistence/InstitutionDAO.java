package com.mapps.persistence;

import com.mapps.exceptions.InstitutionNotFoundException;
import com.mapps.model.Institution;

/**
 * InstitutionDAO interface
 */
public interface InstitutionDAO {

    /**
     * This method adds a Institution to the database.
     * @param institution - The Institution added to the database
     */
     void addInstitution(Institution institution);

    /**
     * This method deletes a Institution from the database.
     * @param institutionId - The Institution identification id to find the Institution to delete
     * @throws InstitutionNotFoundException - If the Institution is not in the database
     */
    void deleteInstitution(Long institutionId) throws InstitutionNotFoundException;

    /**
     * This method updates a Institution in the database.
     * @param institution - The Institution identification id to find the Institution to update
     * @throws InstitutionNotFoundException  - If the  is not in the database
     */
    void updateInstitution(Institution institution) throws InstitutionNotFoundException;

    /**
     * This method gets a Institution from the database
     * @param institutionId - he Institution identification id to find the Institution in the database
     * @return - The Institution in the database
     * @throws InstitutionNotFoundException - If the Institution is not in the database
     */
    Institution getInstitutionById (Long institutionId) throws InstitutionNotFoundException;
}
