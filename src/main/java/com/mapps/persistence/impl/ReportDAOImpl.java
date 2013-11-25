package com.mapps.persistence.impl;

import com.mapps.exceptions.ReportNotFoundException;
import com.mapps.model.Report;
import com.mapps.persistence.ReportDAO;
import org.apache.log4j.Logger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: Usuario1
 * Date: 22/11/13
 * Time: 03:54 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless(name="ReportDAO")
public class ReportDAOImpl implements ReportDAO {

    Logger logger= Logger.getLogger(ReportDAOImpl.class);
    @PersistenceContext(unitName = "mapps-persistence")
    EntityManager entityManager;

    @Override
    public void addReport(Report report) {
        logger.info("a Report was added to the database");
        entityManager.persist(report);
    }

    @Override
    public void deleteReport(Long reportId) throws ReportNotFoundException {
      Report repAux=getReportById(reportId);
      if(repAux!=null){
        entityManager.remove(repAux);
        logger.info("a Report was removed from the database");
        }
    }

    @Override
    public void updateReport(Report report) throws ReportNotFoundException {
        Report repAux=getReportById(report.getId());
        if(repAux!=null){
            entityManager.merge(repAux);
            logger.info("A Report was updated in the database");
        }
    }

    @Override
    public Report getReportById(Long reportId) throws ReportNotFoundException {
       Report repAux=entityManager.find(Report.class,reportId);
       if(repAux!=null){
           return repAux;
       }else{
           throw new ReportNotFoundException();
       }
    }
}
