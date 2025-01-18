package org.zahin.DrivingSpotter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.zahin.DrivingSpotter.model.Report;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
