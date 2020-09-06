package com.orgin.sales.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgin.sales.model.Bill;
import com.orgin.sales.repository.BillRepository;

@Service
@Transactional
public class BillServiceImpl implements BillService {
 
	@Autowired
	BillRepository billRepository;

	@Override
	public Bill save(Bill bill) {
		return billRepository.save(bill);		
	}

	@Override
	public List<Bill> findAllByAdminId(long adminId) {
			return (List<Bill>)billRepository.findByAdminId(adminId);				
	}
}
