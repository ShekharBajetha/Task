package com.payment.paynet.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

import com.payment.paynet.dto.LoginDto;
import com.payment.paynet.models.UserAccount;
import com.payment.paynet.models.Wallet;
import com.payment.paynet.repositories.UserAccountRepository;
import com.payment.paynet.repositories.WalletRepository;
import com.payment.paynet.services.UserAccountService;

@Service
public class UserAccountImpl implements UserAccountService {

	@Autowired
	UserAccountRepository userAccountRepository;

	@Autowired
	WalletRepository walletRepository;

	final static BigDecimal INITIAL_AMOUNT = new BigDecimal("1000");
	
	@Override
	public UserAccount signUp(UserAccount useraccount) {
		UserAccount user = userAccountRepository.save(useraccount);
		Wallet wallet = new Wallet(INITIAL_AMOUNT, user);
		walletRepository.save(wallet);
		return user;
	}

	@Override
	public UserAccount login(LoginDto loginDto) throws Exception {
		UserAccount user = findByMobileNo(loginDto.getMobieNo());
		
		if(user.getMobileNo().equals(loginDto.getMobieNo()) && user.getPassword().equals(loginDto.getPassword()) ) {
			return user;
		}
		throw new Exception("User Not FOUND");
		
	}

	@Override
	public UserAccount findByMobileNo(String MobileNo) {
		return userAccountRepository.findByMobileNo(MobileNo);
	}
	

	
	

}
