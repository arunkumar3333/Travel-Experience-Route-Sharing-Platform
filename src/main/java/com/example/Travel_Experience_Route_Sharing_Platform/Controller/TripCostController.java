package com.example.Travel_Experience_Route_Sharing_Platform.Controller;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Trip;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.TripCost;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Users;
import com.example.Travel_Experience_Route_Sharing_Platform.Service.TripCostService;
import com.example.Travel_Experience_Route_Sharing_Platform.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip_costs")
public class TripCostController {
    @Autowired
    TripCostService tripCostService;

    @PostMapping("/insert")
    public TripCost insert(@RequestBody TripCost tripCost){
        return tripCostService.insert(tripCost);
    }
    @PostMapping("/insertmany")
    public List<TripCost> insertMany(@RequestBody List<TripCost> tripCost){
        return tripCostService.insertMany(tripCost);
    }

    @GetMapping("/fetch")
    public List<TripCost> fetch(){
        return tripCostService.fetch();
    }
    @GetMapping("/fetch/{id}")
    public TripCost fetchId(@PathVariable Long id){
        return tripCostService.fetchByid(id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return tripCostService.delete(id);
    }
    @PutMapping("/update/{id}")
    public TripCost update(@PathVariable Long id, @RequestBody TripCost tripCost){
        return tripCostService.update(id,tripCost);
    }
}
