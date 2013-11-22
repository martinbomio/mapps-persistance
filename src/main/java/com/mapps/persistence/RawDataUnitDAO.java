package com.mapps.persistence;

import com.mapps.exceptions.RawDataUnitNotFoundException;
import com.mapps.model.RawDataUnit;

/**
 *    RawDataUnitDAO interface
 */
public interface RawDataUnitDAO {
    /**
     * This method adds a RawDataUnit to the database.
     * @param rawDataUnit - The RawDataUnit to add to the database
     */
    void addRawDataUnit(RawDataUnit rawDataUnit);

    /**
     * This method deletes a RawDataUnit from the database.
     * @param rawDataUnitId - The RawDataUnit identification id to find the RawDataUnit to delete
     * @throws RawDataUnitNotFoundException - If the RawDataUnit is not in the database
     */
    void deleteRawDataUnit(Long rawDataUnitId) throws RawDataUnitNotFoundException;

    /**
     * This method updates a RawDataUnit in the database.
     * @param rawDataUnit - The RawDataUnit identification id to find the RawDataUnit to update
     * @throws RawDataUnitNotFoundException  - If the RawDataUnit is not in the database
     */
    void updateRawDataUnit(RawDataUnit rawDataUnit) throws RawDataUnitNotFoundException;

    /**
     * This method gets a RawDataUnit from the database
     * @param rawDataUnitId - the RawDataUnit identification id to find the RawDataUnit in the database
     * @return - The RawDataUnit in the database
     * @throws RawDataUnitNotFoundException - If the RawDataUnit is not in the database
     */
    RawDataUnit getRawDataUnitById (Long rawDataUnitId) throws RawDataUnitNotFoundException;
}
