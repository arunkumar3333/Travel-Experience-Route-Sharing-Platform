package com.example.Travel_Experience_Route_Sharing_Platform.Controller;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.RouteSegment;
import com.example.Travel_Experience_Route_Sharing_Platform.Service.RouteSegmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/route segment")
public class RouteSegmentController
{
    @Autowired
    RouteSegmentService routeSegmentService;

    @PostMapping("/insert")
    public RouteSegment insert(@RequestBody RouteSegment routeSegment){
        return routeSegmentService.insert(routeSegment);
    }

    @GetMapping("/fetch")
    public List<RouteSegment> fetch(){
        return routeSegmentService.fetch();
    }

    @GetMapping("/fetch/{id}")
    public RouteSegment fetchid(@PathVariable Long id){
        return routeSegmentService.fetchid(id);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return routeSegmentService.delete(id);
    }

    @PutMapping("/update/{id}")
    public RouteSegment update(@PathVariable Long id, RouteSegment routeSegment){
        return routeSegmentService.update(id,routeSegment);
    }


}
