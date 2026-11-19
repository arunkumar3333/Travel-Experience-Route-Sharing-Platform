package com.example.Travel_Experience_Route_Sharing_Platform.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users users;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(name = "description",columnDefinition = "TEXT")
    private String description;

    @Column(name = "cover_image_url", length = 500)
    private String coverImageUrl;

    @Column(name = "start_location", nullable = false, length = 150)
    private String startLocation;

    @Column(name = "end_location", nullable = false, length = 150)
    private String endLocation;

    @Column(name = "start_lat", nullable = false, precision = 10, scale = 8)
    private BigDecimal startLat;

    @Column(name = "start_lng", nullable = false, precision = 11,scale = 8)
    private BigDecimal startLng;

    @Column(name = "end_lat", nullable = false,precision =10,scale = 8)
    private BigDecimal endLat;

    @Column(name = "end_lng", nullable = false, precision = 11,scale = 8)
    private BigDecimal endLng;

    @Column(name = "total_distance_km", precision = 8,scale = 2)
    private BigDecimal totalDistanceKm;

    @Column(name = "total_cost", nullable = false,precision = 10,scale = 2)
    private BigDecimal totalCost;

    @Builder.Default
    @Column(name = "currency", length = 10)
    private String currency="INR";

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}
