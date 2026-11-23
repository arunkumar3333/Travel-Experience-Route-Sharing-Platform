package com.example.Travel_Experience_Route_Sharing_Platform.Repository;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.TripCost;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;

@ReadingConverter
public interface TripCostRepository extends JpaRepository<TripCost,Long> {
}
