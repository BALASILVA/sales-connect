package com.orgin.sales.service;

import java.util.List;

import com.orgin.sales.model.Bill;

public interface BillService {

	Bill save(Bill bill);

	List<Bill> findAllByAdminId(long adminId);

}
