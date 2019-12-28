package com.august.v1.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.august.v1.dao.SelectDbColumnDao;
import com.august.v1.domain.entity.GuestEntityBean;
import com.august.v1.service.SelectDbColumn;

@Service
public class SelectDbColumnImpl implements SelectDbColumn{
	
	@Autowired
	private SelectDbColumnDao selectDbColumnDao;
	@Override
	public List<GuestEntityBean> selectAllColumn() {
		System.out.println("SelectColumn Services ");
		return selectDbColumnDao.selectAllDbColumn();
	}

}
