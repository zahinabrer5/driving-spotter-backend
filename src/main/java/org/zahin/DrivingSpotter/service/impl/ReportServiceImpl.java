package org.zahin.DrivingSpotter.service.impl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.zahin.DrivingSpotter.model.Report;
import org.zahin.DrivingSpotter.repository.ReportRepository;
import org.zahin.DrivingSpotter.service.ReportService;

import java.util.List;

import static java.lang.Boolean.TRUE;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ReportServiceImpl implements ReportService {
    private final ReportRepository reportRepository;

    @Override
    public Report create(Report report) {
        /* TODO:
        *   1. Error logging
        *   2. Exception handling (exception advisor)
        *   3. Figure out how to use DTO
        *   4. Research @MappedSuperclass, @Builder */
        log.info("Creating new report with license plate: {}", report.getLicensePlate());
        return reportRepository.save(report);
    }

    @Override
    public Report getById(Long id) {
        log.info("Fetching user by id: {}", id);
        return reportRepository.findById(id).get();
    }

    @Override
    public List<Report> list(int limit) {
        return reportRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Report update(Report user) {
        log.info("Updating user with id: {}", user.getId());
        return reportRepository.save(user);
    }

    @Override
    public Boolean deleteById(Long id) {
        log.warn("Deleting user by id: {}", id);
        reportRepository.deleteById(id);
        return TRUE;
    }
}
