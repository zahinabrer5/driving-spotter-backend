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
    public Report create(Report report) throws Exception {
//        log.info("Creating new report for user with email: {}", report.getUser().getEmail());

        String plateImg = report.getLicensePlateImg();
        if (plateImg == null || plateImg.isBlank())
            return reportRepository.save(report);

        String plateText = LicensePlateHelper.getPlateText(plateImg);
        if (LicensePlateHelper.isValidPlate(plateText))
            report.setLicensePlateText(plateText);
        else
            return null;

        return reportRepository.save(report);
    }

    @Override
    public Report getById(Long id) {
        log.info("Fetching report by id: {}", id);
        return reportRepository.findById(id).get();
    }

    @Override
    public List<Report> list(int limit) {
        return reportRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Report update(Report report) throws Exception {
        log.info("Updating report with id: {}", report.getId());

        String plateImg = report.getLicensePlateImg();
        if (plateImg == null || plateImg.isBlank())
            return reportRepository.save(report);

        String plateText = LicensePlateHelper.getPlateText(plateImg);
        if (LicensePlateHelper.isValidPlate(plateText))
            report.setLicensePlateText(plateText);
        else
            return null;

        return reportRepository.save(report);
    }

    @Override
    public Boolean deleteById(Long id) {
        log.warn("Deleting report by id: {}", id);
        reportRepository.deleteById(id);
        return TRUE;
    }
}
