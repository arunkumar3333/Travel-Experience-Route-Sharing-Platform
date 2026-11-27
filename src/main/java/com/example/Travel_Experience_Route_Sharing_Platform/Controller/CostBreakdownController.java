package com.example.Travel_Experience_Route_Sharing_Platform.Controller;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.CostBreakdowns;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.Trip;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.TripCost;
import com.example.Travel_Experience_Route_Sharing_Platform.Service.CostBreakdownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cost_breakdowns")
@CrossOrigin(origins = "*")
public class CostBreakdownController {
    @Autowired
    CostBreakdownService costBreakdownService;

    @PostMapping("/insert")
    public CostBreakdowns insert(@RequestBody CostBreakdowns CostBreakdowns){
        return costBreakdownService.insert(CostBreakdowns);
    }
    @PostMapping("/insertmany")
    public List<CostBreakdowns> insertMany(@RequestBody List<CostBreakdowns> CostBreakdowns){
        return costBreakdownService.insertMany(CostBreakdowns);
    }
    @GetMapping("/fetch")
    public List<CostBreakdowns> fetch(){
        return costBreakdownService.fetch();
    }
    @GetMapping("/fetch/{id}")
    public CostBreakdowns fetchid(@PathVariable Long id){
        return costBreakdownService.fetchByid(id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return costBreakdownService.delete(id);
    }
    @PutMapping("/update/{id}")
    public CostBreakdowns update(@PathVariable Long id, @RequestBody CostBreakdowns CostBreakdowns){
        return costBreakdownService.update(id,CostBreakdowns);
    }


}
