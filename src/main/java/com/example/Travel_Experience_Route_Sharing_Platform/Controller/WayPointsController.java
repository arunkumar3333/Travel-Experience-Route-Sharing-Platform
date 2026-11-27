package com.example.Travel_Experience_Route_Sharing_Platform.Controller;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.WayPoints;
import com.example.Travel_Experience_Route_Sharing_Platform.Service.WayPointsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/waypoint")
public class WayPointsController
{
    @Autowired
    WayPointsService wayPointsService;

    @PostMapping("/insert")
    public WayPoints insert(@RequestBody WayPoints wayPoints)
    {
        return wayPointsService.insert(wayPoints);
    }

    @PostMapping("/insertMany")
    public List<WayPoints> insertMany(@RequestBody List<WayPoints> wayPoints)
    {
        return wayPointsService.insertMany(wayPoints);
    }

    @GetMapping("/fetch")
    public List<WayPoints> fetch(){
        return wayPointsService.fetch();
    }

    @GetMapping("/fetch/{id}")
    public WayPoints fetchid(@PathVariable Long id){
        return wayPointsService.fetchid(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return wayPointsService.delete(id);
    }

}
