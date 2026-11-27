package com.example.Travel_Experience_Route_Sharing_Platform.Repository;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.WayPoints;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface WayPointsRepository extends JpaRepository<WayPoints,Long>
{

}
