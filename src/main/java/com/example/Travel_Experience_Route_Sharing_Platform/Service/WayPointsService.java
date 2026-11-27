package com.example.Travel_Experience_Route_Sharing_Platform.Service;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.WayPoints;
import com.example.Travel_Experience_Route_Sharing_Platform.Repository.WayPointsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WayPointsService
{
    @Autowired
    WayPointsRepository wayPointsRepository;

    public WayPoints insert(WayPoints wayPoints)
    {
        return wayPointsRepository.save(wayPoints);
    }

    public List<WayPoints> insertMany(List<WayPoints> wayPoints)
    {
        return wayPointsRepository.saveAll(wayPoints);
    }

    public List<WayPoints> fetch()
    {
        return wayPointsRepository.findAll();
    }

    public WayPoints fetchid(Long id)
    {
        return wayPointsRepository.findById(id).orElse(null);
    }

    public String delete(Long id)
    {
        if(wayPointsRepository.existsById(id)){
            wayPointsRepository.deleteById(id);
            return "Deletion success";
        }
        return "Id not found or delection unsuccess";
    }
}
