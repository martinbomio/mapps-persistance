package com.mapps.persistance.impl;

import com.mapps.exceptions.PermissionNotFoundException;
import com.mapps.model.Permission;
import com.mapps.persistance.PermissionDAO;

/**
 * Created with IntelliJ IDEA.
 * User: Usuario1
 * Date: 20/11/13
 * Time: 08:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class PermissionDAOImpl implements PermissionDAO {
    @Override
    public void addPermission(Permission permission) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void deletePermission(Long permissionId) throws PermissionNotFoundException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void updateInstitution(Permission permission) throws PermissionNotFoundException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Permission getInstitutionById(Long permissionId) throws PermissionNotFoundException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
