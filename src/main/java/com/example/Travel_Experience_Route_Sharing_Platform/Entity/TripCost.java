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
@Table(name = "trip_costs")
public class TripCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "trip_id", nullable = false, unique = true)
    private Trip trip;

    @Column(name = "budget_type", nullable = false, length = 30)
    private String budgetType;

    @Column(name = "estimated_cost", precision = 10, scale = 2)
    private BigDecimal estimatedCost;

    @Column(name = "actual_cost", nullable = false, precision = 10, scale = 2)
    private BigDecimal actualCost;

    @Builder.Default
    @Column(name = "currency", length = 10)
    private String currency = "INR";
}


