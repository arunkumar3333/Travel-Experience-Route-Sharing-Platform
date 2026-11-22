package com.example.Travel_Experience_Route_Sharing_Platform.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "route_segments")
public class RouteSegment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rid;

// fetch controls when Hibernate loads the linked parent entity from the database—either immediately alongside the child (EAGER)
// or only on demand when its fields are actually accessed (LAZY).
    //LAZY means Hibernate does NOT query or load data from the linked foreign-key table (trips) right away.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id",nullable = false)
    private Trip trip;

    @Column(name = "segment_order", nullable = false)
    private Integer order;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @Column(name = "mode_of_travel",nullable = false,columnDefinition = "ENUM('CAR','BIKE','BUS','TRAIN') DEFAULT 'BIKE'")
    private ModeOfTravel modeOfTravel=ModeOfTravel.BIKE;

    @Column(name = "start_lat",nullable = false,precision = 10,scale = 8)
    private BigDecimal startLat;

    @Column(name = "start_lng",nullable = false,precision = 11,scale = 8)
    private BigDecimal startLng;

    @Column(name = "end_lat",nullable = false,precision = 10,scale = 8)
    private BigDecimal endLat;

    @Column(name = "end_lng",nullable = false,precision = 11,scale = 8)
    private BigDecimal endLng;

    @Column(name = "distance_km",nullable = false,precision = 8,scale = 2)
    private BigDecimal distanceKm;

}
