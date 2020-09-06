package com.orgin.sales.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.orgin.sales.domain.Response;
import com.orgin.sales.model.Bill;
import com.orgin.sales.model.Custumer;
import com.orgin.sales.model.User;
import com.orgin.sales.service.BillService;
import com.orgin.sales.service.CustumerService;

@RestController
public class BillController {
  
	@Autowired
	BillService billService;
	@Autowired 
	CustumerService custumerService;
    @PostMapping(value = "/addBill")
    public ResponseEntity<Response> addBill(@RequestBody Bill bill)
    {
    	try {
        Custumer custumer = new Custumer();    		
        if(!bill.getCustumerPhone().isEmpty()) {
        	System.out.println(custumer.getId());
    		custumer = new Custumer(null,bill.getCustumerPhone());
        	custumer = custumerService.saveCustumerByMobile(custumer);
            bill.setCustomerId(custumer.getId());
    	}
    	else
    	{
        bill.setCustomerId("NOT_PROVIDED");
    	}
    	bill.setCustumerPhone(null);
    	bill.setBillDate(new Date());
    	Bill savedBill = billService.save(bill);
    	custumer = null;
    	if(savedBill != null)
    	{
    		return new ResponseEntity<Response>(new Response("OK"), HttpStatus.OK);
    	}
    	else
    	{
    		return new ResponseEntity<Response>(new Response("FAILED"), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    	}
    	catch(Exception e)
    	{
    		System.out.println(e.getMessage());
    	return new ResponseEntity<Response>(new Response("FAILED"), HttpStatus.INTERNAL_SERVER_ERROR);
    	}
    }
    
    @PostMapping(value = "/bills")
    public ResponseEntity<List<Bill>> findAllByAdminId(@RequestBody User user)
    {
    	System.out.println("User"+user);
    	List<Bill> bills = billService.findAllByAdminId(user.getAdminId());
    	return new ResponseEntity<List<Bill>>(bills,HttpStatus.OK);
    }
}