package com.example.Travel_Experience_Route_Sharing_Platform.Controller;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Trip;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.TripCost;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.TripSaved;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Users;
import com.example.Travel_Experience_Route_Sharing_Platform.Service.TripCostService;
import com.example.Travel_Experience_Route_Sharing_Platform.Service.TripSavedService;
import com.example.Travel_Experience_Route_Sharing_Platform.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip_saved")
public class TripSavedController {
    @Autowired
    TripSavedService tripSavedService;

    @PostMapping("/insert")
    public TripSaved insert(@RequestBody TripSaved tripSaved){
        return  tripSavedService .insert(tripSaved);
    }

    @PostMapping("/insertmany")
    public List<TripSaved> insertMany(@RequestBody List<TripSaved> tripSaved){
        return tripSavedService.insertMany(tripSaved);
    }

    @GetMapping("/fetch")
    public List<TripSaved> fetch(){
        return tripSavedService.fetch();
    }

    @GetMapping("/fetch/{id}")
    public TripSaved fetchid(@PathVariable Long id){
        return tripSavedService.fetchid(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return  tripSavedService.delete(id);
    }

    @PutMapping("/update/{id}")
    public TripSaved update(@PathVariable Long id,@RequestBody TripSaved tripSaved){
        return  tripSavedService.update(id,tripSaved);
    }
}


