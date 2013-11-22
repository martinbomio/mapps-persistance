package com.mapps.persistence;

import com.mapps.exceptions.ReportNotFoundException;
import com.mapps.model.Report;

/**
 * ReportDAO interface
 */
public interface ReportDAO {
    /**
     * This method adds a Report to the database.
     * @param report - The Report to add to the database
     */
    void addReport(Report report);

    /**
     * This method deletes a Report from the database.
     * @param reportId - The Report identification id to find the Report to delete
     * @throws ReportNotFoundException - If the Report is not in the database
     */
    void deleteReport(Long reportId) throws ReportNotFoundException;

    /**
     * This method updates a Report in the database.
     * @param report - The Report identification id to find the Report to update
     * @throws ReportNotFoundException  - If the Report is not in the database
     */
    void updateReport(Report report) throws ReportNotFoundException;

    /**
     * This method gets a Report from the database
     * @param reportId - the Report identification id to find the Report in the database
     * @return - The Report in the database
     * @throws ReportNotFoundException - If the Report is not in the database
     */
    Report getReportById (Long reportId) throws ReportNotFoundException;
}