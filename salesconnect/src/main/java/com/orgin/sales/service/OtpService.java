package com.orgin.sales.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orgin.sales.model.User;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
@Transactional
public class OtpService {
    
	public static final String ACCOUNT_SID = "ACcb9922ce786b11b55064156067b0665c";
	public static final String AUTH_TOKEN = "734343bec88110a92bc137b2cf373d08";
	public OtpService() {
		Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	}
	public boolean sendSmsOtp(User user) {
		String otp = getOtpForSms(user);
		System.out.println("otp is : "+otp);
		return sendOtpSms(otp);
	}

	private boolean sendOtpSms(String otp) {
		try {
	    System.out.println("sendiing opt...");
		String msg = "Hi Indhu OTP code is "+otp;
		Message message = Message.creator(
		        new PhoneNumber("9042004324"),
		        new PhoneNumber("+12057369612"),
		        msg).create();

		    System.out.println(message.getSid());
		    return true;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
           return false;
		}
	}
	public boolean sendEmailOtp(User user) {
		String otp = getOtpForMail(user);
		System.out.println("otp sms "+otp);
		return true;
	}
	
	public String getOtpForSms(User user)
	{
		try {
		long mobile = Long.parseLong(user.getPhoneNumber());
	   	String userName = user.getName();
	   	String strMobile = String.valueOf(mobile);
	   	int num1 = strMobile.charAt(1)*999;
	   	int num2 = strMobile.charAt(strMobile.length()-2)*239;	   	
	   	long mobileOut = (num1+num2)*mobile;
	   	long nameOut=0;
	   	for (int i = 0; i < userName.length(); i++){
	   		nameOut += (int)userName.charAt(i);
	   	}
	   	nameOut=nameOut*12523; 
	   	return String.valueOf(mobileOut).substring(2,4)+""+String.valueOf(nameOut).substring(2,4);
		}catch (Exception e) {
            return "5438";
		}
	}
	public String getOtpForMail(User user)
	{
		try {
		String email = user.getEmail();
	   	String userName = user.getName();
	   	int num1 = email.charAt(1)*911;
	   	int num2 = email.charAt(email.length()-2)*168;
	   	long mailout = 0;
	   	for (int i = 0; i < email.length(); i++){
	   		mailout += (int)email.charAt(i);
	   	}
	   	 mailout = mailout * (num1+num2);
	   	long nameOut=0;
	   	for (int i = 0; i < userName.length(); i++){
	   		nameOut += (int)userName.charAt(i);
	   	}
	   	nameOut=nameOut*12523; 
	   	return String.valueOf(mailout).substring(2,4)+""+String.valueOf(nameOut).substring(2,4);
		}
		catch (Exception e) {
			return "2412";
		}
	}
	public boolean isValidOtpForMail(User user, String otp) {
		if(getOtpForMail(user).equals(otp))
			return true;
		return false;
	}
	public boolean isValidOtpForPhoneNumber(User user, String otp) {
		if(getOtpForSms(user).equals(otp))
			return true;
		return false;
	}
}
