package com.example.Travel_Experience_Route_Sharing_Platform.Service;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.RouteSegment;
import com.example.Travel_Experience_Route_Sharing_Platform.Repository.RouteSegmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RouteSegmentService
{

    @Autowired
    RouteSegmentRepository routeSegmentRepository;

    public RouteSegment insert(RouteSegment routeSegment)
    {
        return routeSegmentRepository.save(routeSegment);
    }

    public List<RouteSegment> fetch()
    {
        return routeSegmentRepository.findAll();
    }

    public String delete(Long id)
    {
        if(routeSegmentRepository.existsById(id)){
            routeSegmentRepository.deleteById(id);
            return "Deletion success";
        }
        return "Deletion unsuccess or id not found";
    }

    public RouteSegment update(Long id, RouteSegment routeSegment)
    {
        RouteSegment routeSegment1=routeSegmentRepository.findById(id).orElse(null);
        if(routeSegment1!=null){
            routeSegment1.setOrder(routeSegment.getOrder());
            routeSegment1.setDistanceKm(routeSegment.getDistanceKm());
            routeSegment1.setTrip(routeSegment.getTrip());
            routeSegment1.setStartLat(routeSegment.getStartLat());
            routeSegment1.setStartLng(routeSegment.getStartLng());
            routeSegment1.setEndLat(routeSegment.getEndLat());
            routeSegment1.setEndLng(routeSegment.getEndLng());
            routeSegment1.setModeOfTravel(routeSegment.getModeOfTravel());
            return routeSegmentRepository.save(routeSegment1);
        }
        return null;
    }

    public RouteSegment fetchid(Long id)
    {
            return routeSegmentRepository.findById(id).orElse(null);
    }
}
