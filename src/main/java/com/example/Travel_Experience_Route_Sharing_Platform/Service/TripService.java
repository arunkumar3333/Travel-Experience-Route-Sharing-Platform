package com.example.Travel_Experience_Route_Sharing_Platform.Service;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Trip;
import com.example.Travel_Experience_Route_Sharing_Platform.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripService
{
    @Autowired
    TripRepository tripRepository;

    public Trip insert(Trip trip)
    {

        return tripRepository.save(trip);
    }

    public List<Trip> fetch()
    {

        return tripRepository.findAll();
    }

    public String delete(Long id)
    {
        if(tripRepository.existsById(id)){
            tripRepository.deleteById(id);
            return "Deletion success";
        }
        return "Deletion unsuccess or user not found";
    }

    public Trip fetchid(Long id)
    {
      return tripRepository.findById(id).orElse(null);
    }

    public Trip update(Long id, Trip trip)
    {
        Trip trip1=tripRepository.findById(id).orElse(null);
        if(trip1!=null){
            trip1.setCurrency(trip.getCurrency());
            trip1.setDescription(trip.getDescription());
            trip1.setEndLng(trip.getEndLng());
            trip1.setCreatedAt(trip.getCreatedAt());
            trip1.setTitle(trip.getTitle());
            trip1.setStartLocation(trip.getStartLocation());
            trip1.setTotalCost(trip.getTotalCost());
            trip1.setStartLng(trip.getStartLng());
            trip1.setCoverImageUrl(trip.getCoverImageUrl());
            trip1.setTotalDistanceKm(trip.getTotalDistanceKm());
            trip1.setUsers(trip.getUsers());
            trip1.setStartLat(trip.getStartLat());
            trip1.setEndLat(trip.getEndLat());
            return tripRepository.save(trip1);
        }
        return null;
    }
}
