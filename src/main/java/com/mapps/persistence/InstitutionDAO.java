package com.mapps.persistence;

import java.util.List;

import com.mapps.exceptions.InstitutionAlreadyExistException;
import com.mapps.exceptions.InstitutionNotFoundException;
import com.mapps.model.Institution;

/**
 * InstitutionDAO interface
 */
public interface InstitutionDAO {

    /**
     * This method adds a Institution to the database.
     * @param institution - The Institution added to the database
     *@throws InstitutionAlreadyExistException
     */
     void addInstitution(Institution institution)throws InstitutionAlreadyExistException;

    /**
     * This method returns true if the Institution is in the database.
     * @param institution - The Institution added to the database
     */
    boolean isInDatabase(Institution institution);

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

    /**
     * Returns an institution by its name
     * @param name name of the institution
     * @return the institution with the name passed
     * @throws InstitutionNotFoundException thrown when no istitution has that name
     */
    Institution getInstitutionByName(String name) throws InstitutionNotFoundException;

    /**
     * Returns all the institutions in the database.
     * @return list of institutions.
     */
    List<Institution> getAllInstitutions();
}
