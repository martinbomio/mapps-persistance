package com.mapps.persistence;

import com.mapps.exceptions.UserNotFoundException;
import com.mapps.model.User;

/**
 *
 */
public interface UserDAO {
    /**
     * This method adds a User to the database.
     * @param user - The User to add to the database
     */
    void addUser(User user);

    /**
     * This method deletes a User from the database.
     * @param userId - The User identification id to find the User to delete
     * @throws UserNotFoundException - If the User is not in the database
     */
    void deleteUser(Long userId) throws UserNotFoundException;

    /**
     * This method updates a User in the database.
     * @param user - The User identification id to find the User to update
     * @throws UserNotFoundException  - If the User is not in the database
     */
    void updateUser(User user) throws UserNotFoundException;

    /**
     * This method gets a User from the database
     * @param userId - the User identification id to find the User in the database
     * @return - The User in the database
     * @throws UserNotFoundException - If the User is not in the database
     */
    User getUserById (Long userId) throws UserNotFoundException;
}
