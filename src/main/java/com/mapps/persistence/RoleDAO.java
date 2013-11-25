package com.mapps.persistence;


import com.mapps.exceptions.RoleNotFoundException;
import com.mapps.model.Role;

/**
 * Defines the operations with re Role table on the database
 */
public interface RoleDAO {
    /**
     * Returns a role by its ID
     * @param id id of the Role
     * @return the role
     */
    Role getByID(Long id) throws RoleNotFoundException;
}
