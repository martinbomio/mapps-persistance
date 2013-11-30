package com.mapps.persistence.impl;

import com.mapps.exceptions.DeviceAlreadyExistException;
import com.mapps.exceptions.DeviceNotFoundException;
import com.mapps.model.Device;
import com.mapps.persistence.DeviceDAO;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


/**
 *
 */
@Stateless(name = "DeviceDao")
public class DeviceDAOImpl implements DeviceDAO{

    Logger logger=Logger.getLogger(DeviceDAOImpl.class);
    @PersistenceContext(unitName="mapps-persistence")
    EntityManager entityManager;

    @Override
    public void addDevice(Device device) throws DeviceAlreadyExistException{

        if(isInDatabase(device)){
            throw new DeviceAlreadyExistException();
        }
        logger.info("add a Device to database");
        entityManager.persist(device);
    }

    @Override
    public boolean isInDatabase(Device device) {
        boolean aux=true;
        Query query=entityManager.createQuery("from Devices as d where d.dirLow=?");
        query.setParameter(0,device.getDirLow());
        List<Device> results=query.getResultList();
        if(results.size()==0){
           aux=false;
        }else{
            aux=true;
        }
        return aux;

    }

    @Override
    public void deleteDevice(Long deviceId) throws DeviceNotFoundException {
        logger.info("A Device was removed from the database");
        Device deviceAux=getDeviceById(deviceId);
        if(deviceAux!=null){
            entityManager.remove(deviceAux);
        }
    }

    @Override
    public void updateDevice(Device device) throws DeviceNotFoundException {
       Device deviceAux=getDeviceById(device.getId());
       if(deviceAux!=null){
           entityManager.merge(device);
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

    @Override
    public Device getDeviceByDir(long dirLow) throws DeviceNotFoundException {
        Query query=entityManager.createQuery("from Devices as d where d.dirLow=?");
        query.setParameter(0,dirLow);
        List<Device> results=query.getResultList();
        if(results.size()!=1){
            throw new DeviceNotFoundException();
        }
        return results.get(0);
    }
}
