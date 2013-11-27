package com.mapps.persistence;

import com.mapps.exceptions.TrainingNotFoundException;
import com.mapps.model.Training;

/**
 * TrainingDAO interface
 */
public interface TrainingDAO {

    /**
     * This method adds a Training to the database.
     * @param training - The Training added to the database
     */
    void addTraining(Training training);

    /**
     * This method deletes a Training from the database.
     * @param trainingId - The Training identification id to find the Training to delete
     * @throws TrainingNotFoundException - If the Training is not in the database
     */
    void deleteTraining(Long trainingId) throws TrainingNotFoundException;

    /**
     * This method updates a Training in the database.
     * @param training - The Training identification id to find the Training to update
     * @throws TrainingNotFoundException  - If the Training is not in the database
     */
    void updateTraining(Training training) throws TrainingNotFoundException;

    /**
     * This method gets a Training from the database
     * @param trainingId - the Training identification id to find the Training in the database
     * @return - The Training in the database
     * @throws TrainingNotFoundException - If the Training is not in the database
     */
    Training getTrainingById (Long trainingId) throws TrainingNotFoundException;
}
