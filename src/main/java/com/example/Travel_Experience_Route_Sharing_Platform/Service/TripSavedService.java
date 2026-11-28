package com.example.Travel_Experience_Route_Sharing_Platform.Service;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.CostBreakdowns;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Trip;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.TripSaved;
import com.example.Travel_Experience_Route_Sharing_Platform.Repository.TripRepository;
import com.example.Travel_Experience_Route_Sharing_Platform.Repository.TripSavedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripSavedService {
    @Autowired
    TripSavedRepository tripSavedRepository;

    public TripSaved insert(TripSaved tripSaved)
    {

        return tripSavedRepository.save(tripSaved);
    }

    public List<TripSaved> insertMany(List<TripSaved> tripSaved)
    {
        return tripSavedRepository.saveAll(tripSaved);
    }

    public List<TripSaved> fetch()
    {

        return tripSavedRepository.findAll();
    }

    public String delete(Long id)
    {
        if(tripSavedRepository.existsById(id)){
            tripSavedRepository.deleteById(id);
            return "Deletion success";
        }
        return "Deletion unsuccess or user not found";
    }

    public TripSaved fetchid(Long id)
    {
        return tripSavedRepository.findById(id).orElse(null);
    }

    public TripSaved update(Long id, TripSaved tripSaved)
    {
        TripSaved tripSaved1=tripSavedRepository.findById(id).orElse(null);
        if(tripSaved1!=null){

            tripSaved1.setUser(tripSaved.getUser());
            tripSaved1.setTrip(tripSaved.getTrip());
            tripSaved1.setSavedAt(tripSaved.getSavedAt());
            tripSaved1.setNotes(tripSaved.getNotes());


            return tripSavedRepository.save(tripSaved1);
        }
        return null;
    }
}

