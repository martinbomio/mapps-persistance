package com.mapps.persistence.impl;

import com.mapps.exceptions.DeviceNotFoundException;
import com.mapps.model.Device;
import com.mapps.persistence.DeviceDAO;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 */
@Stateless(name = "DeviceDao")
public class DeviceDAOImpl implements DeviceDAO{

    Logger logger=Logger.getLogger(DeviceDAOImpl.class);
    @PersistenceContext(unitName="mapps-persistence")
    EntityManager entityManager;

    @Override
    public void addDevice(Device device) {
        logger.info("add Device to database");
        entityManager.persist(device);
    }

    @Override
    public void deleteDevice(Long deviceId) throws DeviceNotFoundException {
        logger.info("A Device was removed from the database");
        Device deviceAux=getDeviceById(deviceId);
        entityManager.remove(deviceAux);
    }

    @Override
    public void updateDevice(Device device) throws DeviceNotFoundException {
       Device deviceAux=getDeviceById(device.getId());
       if(deviceAux!=null){
           entityManager.merge(deviceAux);
           logger.info("A Device was updated in the database");
       }
    }

    @Override
    public Device getDeviceById(Long deviceId) throws DeviceNotFoundException {
       Device deviceAux=entityManager.find(Device.class,deviceId);
       if(deviceAux!=null){
           return deviceAux;
       }else{
           throw new DeviceNotFoundException();
       }
    }
}
