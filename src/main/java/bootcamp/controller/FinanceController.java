package bootcamp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.model.finance.Finance;
import bootcamp.service.InventoryService;

@RestController
public class FinanceController {
	
	@Autowired
	private Finance finance;
	
	@Autowired
	private InventoryService service;

    @RequestMapping (value = "/company")
    public List<Double> giveStock(){
    	List<Double> list = new ArrayList<>();
    	list.add(finance.getOperatingCash().doubleValue());
    	list.add(service.getInventoryValue());
    	return list;
    }
    
}