package com.orgin.sales.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.orgin.sales.model.Custumer;

@Repository
public class CustumerRepositoryImpl implements CustumerRepository {

	@Autowired 
	private MongoOperations mongoOperations;
	

	@Override
	public Custumer saveCustumerByMobile(Custumer custumer) {
		Query query = new Query();
		query.addCriteria(Criteria.where("custumerPhone").is(custumer.getCustumerPhone()));
		Update update = new Update();
		update.set("custumerPhone", custumer.getCustumerPhone());	
		mongoOperations.upsert(query, update , Custumer.class);
		return mongoOperations.findOne(query,Custumer.class);
	}
}
