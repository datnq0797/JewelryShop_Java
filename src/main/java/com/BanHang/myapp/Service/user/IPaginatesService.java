package com.BanHang.myapp.Service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BanHang.myapp.Dto.PaginateDto;

@Service
public interface IPaginatesService {
	@Autowired
	public PaginateDto GetInfoPaginates(int totalData,int limit,int currentPage);
}
