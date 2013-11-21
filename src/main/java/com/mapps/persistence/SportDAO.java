package com.mapps.persistence;

import com.mapps.exceptions.SportNotFoundException;
import com.mapps.model.Sport;

/**
 * SportDAO interface
 */
public interface SportDAO {

    /**
     * This method adds a Sport to the database.
     * @param sport - The Permission to add to the database
     */
    void addSport(Sport sport);

    /**
     * This method deletes a Sport from the database.
     * @param sportId - The Sport identification id to find the Sport to delete
     * @throws SportNotFoundException - If the Sport is not in the database
     */
    void deleteSport(Long sportId) throws SportNotFoundException;

    /**
     * This method updates a Sport in the database.
     * @param sport - The Sport identification id to find the Sport to update
     * @throws SportNotFoundException  - If the sport is not in the database
     */
    void updateSport(Sport sport) throws SportNotFoundException;

    /**
     * This method gets a Sport from the database
     * @param sportId - the Sport identification id to find the Sport in the database
     * @return - The Sport in the database
     * @throws SportNotFoundException - If the Sport is not in the database
     */
    Sport getSportById (Long sportId) throws SportNotFoundException;
}
