package com.orgin.sales.validator;
import org.springframework.stereotype.Service;

import com.orgin.sales.model.User;

@Service
public class UserDetailValidation {

	public boolean vaildateUserName(String userName)
	{
		if(userName==null || userName.trim().equalsIgnoreCase(""))
			return false;
		return true;
	}
	
	public boolean vaildatePassword(String password)
	{
		if(password==null)
		   return false;
		return true;
	}
	
	public boolean validateEmail(String email)
	{
		if(email==null)
			return false;
		 String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	     return email.matches(regex);
	}

	public boolean validatePhoneNumber(String phoneNumber) {
		if(phoneNumber==null)
			return false;
		try {  
		    Double.parseDouble(phoneNumber);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
	}
    
	public boolean validatePassword(String password)
	{
		if(password==null)
			return false;
		if(password.length()<8)
			return false;
		return true;
	}

	public boolean valdateUserByEmail(User user) {
		if(vaildateUserName(user.getName()) && validatePassword(user.getPassword()) && validateEmail(user.getEmail()))
		{
			return true;
		}
		return false;
	}

	public boolean valdateUserByPhoneNumber(User user) {
		System.out.println(user.getName());
		if(vaildateUserName(user.getName()) &&  validatePassword(user.getPassword()) && validatePhoneNumber(user.getPhoneNumber()))
		{
			return true;
		}
		return false;
	}
}
