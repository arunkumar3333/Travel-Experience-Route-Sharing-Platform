package com.example.Travel_Experience_Route_Sharing_Platform.Service;

import com.example.Travel_Experience_Route_Sharing_Platform.Entity.CostBreakdowns;
import com.example.Travel_Experience_Route_Sharing_Platform.Entity.TripCost;
import com.example.Travel_Experience_Route_Sharing_Platform.Repository.CostBreakdownRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostBreakdownService {

    @Autowired
    CostBreakdownRepository CostBreakdownRepository;

    public CostBreakdowns insert(CostBreakdowns CostBreakdowns)
    {
        return CostBreakdownRepository.save(CostBreakdowns);
    }

    public List<CostBreakdowns> insertMany(List<CostBreakdowns> CostBreakdowns)
    {
        return CostBreakdownRepository.saveAll(CostBreakdowns);
    }
    public List<CostBreakdowns> fetch(){
        return CostBreakdownRepository.findAll();
    }
    public CostBreakdowns fetchByid(Long id){
        return CostBreakdownRepository.findById(id).orElse(null);
    }
    public String delete(Long id) {
        if( CostBreakdownRepository.existsById(id)){
            CostBreakdownRepository.deleteById(id);
            return "deletion successfully";
        }
        return "id not found";
    }
    public CostBreakdowns update(Long id,  CostBreakdowns CostBreakdowns) {
        CostBreakdowns CostBreakdowns1= CostBreakdownRepository.findById(id).orElse(null);
        if(  CostBreakdowns1!=null){

            CostBreakdowns1.setAmount(CostBreakdowns.getAmount());
            CostBreakdowns1.setCategory(CostBreakdowns.getCategory());
            CostBreakdowns1.setItemDescription(CostBreakdowns.getItemDescription());
            CostBreakdowns1.setReceiptImageUrl(CostBreakdowns.getReceiptImageUrl());
            CostBreakdowns1.setTripCost(CostBreakdowns.getTripCost());
            return CostBreakdownRepository.save(CostBreakdowns1);
        }
        return null;
    }
}
