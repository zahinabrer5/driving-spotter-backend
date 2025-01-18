package org.zahin.DrivingSpotter.model.common;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.zahin.DrivingSpotter.constants.ReviewStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
public abstract class BaseAuditEntity {
    @Enumerated(EnumType.STRING)
    @Column(name = "review_status"/*, nullable = false*/)
    private ReviewStatus reviewStatus;

//    @Column(name = "insert_by", nullable = false)
//    private Long insertBy;

//    @Column(name = "created_at"/*, nullable = false*/)
//    private LocalDateTime insertDate;

//    @Column(name = "update_by")
//    private Long updateBy;

//    @Column(name = "updated_at")
//    private LocalDateTime updateDate;
}
