package com.mapps.persistance;

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
    User getUserbyUsername(String username);
}
