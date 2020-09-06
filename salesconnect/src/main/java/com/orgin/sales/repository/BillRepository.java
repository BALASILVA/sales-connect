package com.orgin.sales.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.orgin.sales.model.Bill;

@Repository
public interface BillRepository extends MongoRepository<Bill, String> {

	List<Bill> findByAdminId(long adminId);

}
