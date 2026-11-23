package com.example.Travel_Experience_Route_Sharing_Platform.Service;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Trip;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.TripCost;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Users;
import com.example.Travel_Experience_Route_Sharing_Platform.Repository.TripCostRepository;
import com.example.Travel_Experience_Route_Sharing_Platform.Repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TripCostService {
    @Autowired
    TripCostRepository tripCostRepository;

    public TripCost insert(TripCost tripCost)
    {

        return tripCostRepository.save(tripCost);
    }

    public List<TripCost> insertMany(List<TripCost> tripCost) {
        return tripCostRepository.saveAll(tripCost);
    }
    public List<TripCost> fetch(){
    return tripCostRepository.findAll();
    }

    public TripCost fetchByid(Long id){
        return tripCostRepository.findById(id).orElse(null);
    }

    public String delete(Long id) {
        if(tripCostRepository.existsById(id)){
            tripCostRepository.deleteById(id);
            return "deletion success";
        }
        return "id not found";
    }

    public TripCost update(Long id, TripCost tripCost) {
        TripCost tripCost1=tripCostRepository.findById(id).orElse(null);
        if(tripCost1!=null){
            tripCost1.setBudgetType(tripCost.getBudgetType());
            tripCost1.setEstimatedCost(tripCost.getEstimatedCost());
            tripCost1.setActualCost(tripCost.getActualCost());
            tripCost1.setCurrency(tripCost.getCurrency());
            tripCost1.setTrip(tripCost.getTrip());
            return tripCostRepository.save(tripCost1);
        }
        return null;
    }

}
