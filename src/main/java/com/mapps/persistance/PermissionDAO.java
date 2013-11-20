package com.mapps.persistance;

import com.mapps.exceptions.PermissionNotFoundException;
import com.mapps.model.Permission;

/**
 * PermissionDAO interface
 */
public interface PermissionDAO {
    /**
     * This method adds a Permission to the database.
     * @param permission - The Permission to add to the database
     */
    void addPermission(Permission permission);

    /**
     * This method deletes a Permission from the database.
     * @param permissionId - The Permission identification id to find the Permission to delete
     * @throws PermissionNotFoundException - If the Permission is not in the database
     */
    void deletePermission(Long permissionId) throws PermissionNotFoundException;

    /**
     * This method updates a Permission in the database.
     * @param permission - The Permission identification id to find the Permission to update
     * @throws PermissionNotFoundException  - If the  is not in the database
     */
    void updatePermission(Permission permission) throws PermissionNotFoundException;

    /**
     * This method gets a Permission from the database
     * @param permissionId - the Permission identification id to find the Permission in the database
     * @return - The Permission in the database
     * @throws PermissionNotFoundException - If the Permission is not in the database
     */
    Permission getPermissionById (Long permissionId) throws PermissionNotFoundException;
}
