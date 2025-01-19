package org.zahin.DrivingSpotter.service;

import org.zahin.DrivingSpotter.model.Report;

import java.util.List;

public interface ReportService {
    Report create(Report report) throws Exception;

    Report getById(Long id);
    List<Report> list(int limit);

    Report update(Report user) throws Exception;

    Boolean deleteById(Long id);
}
