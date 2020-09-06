package com.orgin.sales.repository;

import org.springframework.stereotype.Repository;

import com.orgin.sales.model.Custumer;

@Repository
public interface CustumerRepository {

	public Custumer saveCustumerByMobile(Custumer custumer);
}
