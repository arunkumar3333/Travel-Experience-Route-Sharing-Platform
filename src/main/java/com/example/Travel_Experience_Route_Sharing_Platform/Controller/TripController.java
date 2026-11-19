package com.example.Travel_Experience_Route_Sharing_Platform.Controller;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Trip;
import com.example.Travel_Experience_Route_Sharing_Platform.Service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trip")
public class TripController
{
    @Autowired
    TripService tripService;

    @PostMapping("/insert")
    public Trip insert(@RequestBody Trip trip){
        return tripService.insert(trip);
    }

    @GetMapping("/fetch")
    public List<Trip> fetch(){
        return tripService.fetch();
    }

    @GetMapping("/fetch/{id}")
    public Trip fetchid(@PathVariable Long id){
        return tripService.fetchid(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return tripService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Trip update(@PathVariable Long id,@RequestBody Trip trip){
        return tripService.update(id,trip);
    }
}
