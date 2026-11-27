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
@Table(name = "cost_breakdowns")
public class CostBreakdowns {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_cost_id", nullable = false)
    private TripCost tripCost;

    @Column(nullable = false, length = 50)
    private String category;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal amount;

    @Column(name = "item_description", length = 255)
    private String itemDescription;

    @Column(name = "receipt_image_url", length = 500)
    private String receiptImageUrl;
}

