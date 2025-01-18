package org.zahin.DrivingSpotter.service;

import org.zahin.DrivingSpotter.model.Report;

import java.util.List;

public interface ReportService {
    Report create(Report report);

    Report getById(Long id);
    List<Report> list(int limit);

    Report update(Report user);

    Boolean deleteById(Long id);
}
