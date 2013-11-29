package com.mapps.persistence;

import com.mapps.exceptions.AthleteNotFoundException;
import com.mapps.model.Athlete;
import com.mapps.model.Institution;

/**
 * AthleteDAO interface
 */
public interface AthleteDAO {
    /**
     * This method adds a Athlete to the database.
     * @param athlete - The Athlete to add to the database
     */
    void addAthlete(Athlete athlete);

    /**
     * This method deletes a Athlete from the database.
     * @param athleteId - The Athlete identification id to find the Athlete to delete
     * @throws AthleteNotFoundException - If the Athlete is not in the database
     */
    void deleteAthlete(Long athleteId) throws AthleteNotFoundException;

    /**
     * This method updates a Athlete in the database.
     * @param athlete - The Athlete identification id to find the Athlete to update
     * @throws AthleteNotFoundException  - If the Athlete is not in the database
     */
    void updateAthlete(Athlete athlete) throws AthleteNotFoundException;

    /**
     * This method gets a Athlete from the database
     * @param athleteId - the Athlete identification id to find the Athlete in the database
     * @return - The Athlete in the database
     * @throws AthleteNotFoundException - If the Athlete is not in the database
     */
    Athlete getAthleteById (Long athleteId) throws AthleteNotFoundException;

    /**
     * This method gets a Athlete from the database
     * @param name - the Athlete identification name to find the Athlete in the database
     * @return - The Athlete in the database
     * @throws AthleteNotFoundException - If the Athlete is not in the database
     */
    Athlete getAthleteByName (String name) throws AthleteNotFoundException;

    /**
     * This method gets a Athlete from the database
     * @param name - the Athlete identification name to find the Athlete in the database
     * @param institution - the Athlete institution
     * @return - The Athlete in the database
     * @throws AthleteNotFoundException - If the Athlete is not in the database
     */
    Athlete getAthleteByNameAndInstitution (String name,Institution institution) throws AthleteNotFoundException;



}

