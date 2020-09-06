package com.orgin.sales.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgin.sales.model.Custumer;
import com.orgin.sales.repository.CustumerRepository;

@Service
@Transactional
public class CustumerServiceImpl implements CustumerService {

	@Autowired
	CustumerRepository custumerRepository;
	
	@Override
	public Custumer saveCustumerByMobile(Custumer custumer) {
		return custumerRepository.saveCustumerByMobile(custumer);
	}

}
