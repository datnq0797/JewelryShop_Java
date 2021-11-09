package com.BanHang.myapp.Service.user;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.BanHang.myapp.Dto.CartDto;
import com.BanHang.myapp.Entity.Bills;
@Service
public interface IBillsService {
	public int AddBills(Bills bill);
	
	public void AddBillsDetail(HashMap<Long,CartDto> carts);
}
