package com.example.Travel_Experience_Route_Sharing_Platform.Repository;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.TripSaved;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripSavedRepository extends JpaRepository<TripSaved,Long> {
}
