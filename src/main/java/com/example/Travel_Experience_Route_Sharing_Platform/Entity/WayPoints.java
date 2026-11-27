package com.example.Travel_Experience_Route_Sharing_Platform.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "way_points")
public class WayPoints {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_segment_id", nullable = false)
    private  RouteSegment routeSegment;

    @Column(name = "place_name", nullable = false,columnDefinition = "TEXt")
    private String placeName;

    @Column(name = "latitude",nullable = false,precision = 10,scale = 8)
    private BigDecimal latitude;

    @Column(name = "longitude",nullable = false,precision = 11,scale = 8)
    private BigDecimal longitude;

    @Column(name = "notes",nullable = true,columnDefinition = "Text")
    private String notes;

    @Column(name = "image_url",nullable = true,columnDefinition = "Text")
    private String imageUrl;

    @Column(name = "stop_order",nullable = false)
    private Integer stopOrder;

}
