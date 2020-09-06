package com.orgin.sales.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgin.sales.repository.UserRepository;
import com.orgin.sales.model.User;
import com.orgin.sales.util.PasswordUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	@Autowired
    SequenceGeneratorService sequenceGeneratorService;
	@Override
	public User save(User user) {
        String password = PasswordUtil.getPasswordHash(user.getPassword());
        user.setPassword(password);
        user.setJoinDate(new Date());
        if(user.getAdminId()==0 || user.getRole().equalsIgnoreCase("ADMIN"))
        {        	
        	user.setUserId(1);
        }
        else
        {        	
        	user.setUserId(sequenceGeneratorService.generateSequence("employee_sequence_of_admin_"+user.getAdminId()));
        }
        if(user.getRole().equalsIgnoreCase("ADMIN")) {
        user.setAdminId(sequenceGeneratorService.generateSequence("admin_sequence"));
        }
        User userRes = userRepository.save(user);
        user.setUserId(sequenceGeneratorService.generateSequence("employee_sequence_of_admin_"+userRes.getAdminId()));
		return userRes;
	}

	@Override
	public List<User> findAllByAdminId(long adminId) {
		return (List<User>) userRepository.findAllByAdminId(adminId);
	}

	@Override
	public User getUserByEmail(String email) {
		return userRepository.findByEmailIgnoreCase(email);
	}

	@Override
	public boolean checkPhoneExist(String phoneNUmber) {
		User user = userRepository.findByPhoneNumberIgnoreCase(phoneNUmber);
		return user!=null;
	}

	@Override
	public boolean checkEmailExist(String email) {
		User user = userRepository.findByEmailIgnoreCase(email);
		return user!=null;
	}
}
