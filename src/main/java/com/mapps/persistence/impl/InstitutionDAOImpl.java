package com.mapps.persistence.impl;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.mapps.exceptions.InstitutionNotFoundException;
import com.mapps.model.Institution;
import com.mapps.persistence.InstitutionDAO;

/**
 *
 */
@Stateless(name = "InstitutionDao")
public class InstitutionDAOImpl implements InstitutionDAO {

    Logger logger = Logger.getLogger(InstitutionDAOImpl.class);
    @PersistenceContext(unitName="mapps-persistence")
    EntityManager entityManager;

    @Override
    public void addInstitution(Institution institution) {
        logger.info("A Institution was added to the database");
        entityManager.persist(institution);
    }

    @Override
    public void deleteInstitution(Long institutionId) throws InstitutionNotFoundException {
        Institution institution=getInstitutionById(institutionId);
        if(institution!=null){
            entityManager.remove(institution);
            logger.info("A Institution was removed from the database");
        }
    }

    @Override
    public void updateInstitution(Institution institution) throws InstitutionNotFoundException {
        Institution instAux=getInstitutionById(institution.getId());
        if(instAux!=null){
            entityManager.merge(institution);
            logger.info("A Institution was updated in the database");
        }
    }

    @Override
    public Institution getInstitutionById(Long institutionId) throws InstitutionNotFoundException {
        Institution instAux=entityManager.find(Institution.class, institutionId);
        if(instAux!=null){
            logger.info("A Institution was fetched from the database");
            return instAux;
        }else{
            logger.error("The Institution is not in the database");
            throw new InstitutionNotFoundException();
        }
    }

    @Override
    public Institution getByName(String name) throws InstitutionNotFoundException {
        Query query = entityManager.createQuery("from Institutions as i where i.name = :name")
                .setParameter("name", name);
        List<Institution> institutions = query.getResultList();
        if (institutions.size() != 1){
            logger.error("The Institution is not in the database");
            throw new InstitutionNotFoundException();
        }
        return institutions.get(0);
    }

    @Override
    public List<Institution> getAll() {
        Query query = entityManager.createQuery("from Institutions");
        return query.getResultList();
    }
}
