package org.zahin.DrivingSpotter.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.zahin.DrivingSpotter.model.common.BaseAuditEntity;

@Entity
@Table(name = "report")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Report extends BaseAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "violation_description", length = 500, nullable = false)
    private String violationDescription;

    @Column(name = "location", length = 500, nullable = false)
    private String location;

    @Column(name = "datetime", nullable = false)
    private String datetime;

    @Column(name = "license_plate", length = 7, nullable = false)
    private String licensePlate;

    @Lob
    @Column(name = "evidence_img", nullable = false)
    private String evidenceImg;

    @Lob
    @Column(name = "license_plate_img")
    private String licensePlateImg;

    @Column(name = "license_plate_text", nullable = false)
    private String licensePlateText;
}
