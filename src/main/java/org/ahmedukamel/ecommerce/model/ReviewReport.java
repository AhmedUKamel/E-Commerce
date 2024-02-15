package org.ahmedukamel.ecommerce.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "review_reports")
public class ReviewReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportId;
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
    @ManyToOne
    @JoinColumn(name = "review_id", nullable = false)
    private Review review;
    @Enumerated(value = EnumType.STRING)
    @Column(nullable = false)
    private ReportType type;
    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime dateTime;
}
