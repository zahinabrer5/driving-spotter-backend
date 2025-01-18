package org.zahin.DrivingSpotter.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.zahin.DrivingSpotter.model.Response;
import org.zahin.DrivingSpotter.model.Report;
import org.zahin.DrivingSpotter.service.ReportService;

import java.time.LocalDateTime;
import java.util.Map;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/report")
@RequiredArgsConstructor
public class ReportController {
    private final ReportService reportService;

    @GetMapping("/list")
    public ResponseEntity<Response> list() {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("reports", reportService.list(30)))
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Reports retrieved")
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> get(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .data(Map.of("report", reportService.getById(id)))
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Retrieved report by id: "+id)
                        .build()
        );
    }

    @PostMapping("/create")
    public ResponseEntity<Response> create(@RequestBody @Valid Report report) {
        reportService.create(report);
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .message("Created report with id: "+report.getId())
                        .build()
        );
    }

    @PutMapping("/update")
    public ResponseEntity<Response> update(@RequestBody @Valid Report report) {
        reportService.update(report);
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Updated report with id: "+report.getId())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> delete(@PathVariable("id") Long id) {
        reportService.deleteById(id);
        return ResponseEntity.ok(
                Response.builder()
                        .timestamp(LocalDateTime.now())
                        .status(OK)
                        .statusCode(OK.value())
                        .message("Deleted report by id: "+id)
                        .build()
        );
    }
}
