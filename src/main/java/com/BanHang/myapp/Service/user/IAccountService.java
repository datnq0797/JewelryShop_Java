package com.BanHang.myapp.Service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BanHang.myapp.Entity.Users;

@Service
public interface IAccountService {
	@Autowired
	public int AddAccount(Users user);
	@Autowired
	public Users CheckAccount(Users user);
}
