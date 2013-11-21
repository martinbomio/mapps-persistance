package com.mapps.persistence;

import com.mapps.model.User;

/**
 *
 */
public interface UserDAO {
    /**
     *
     * @param username
     * @return
     */
    User getUserByUsername(String username);
}
