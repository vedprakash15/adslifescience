package com.august.v1.dao;

import java.util.List;

import com.august.v1.domain.entity.GuestEntityBean;

public interface SelectDbColumnDao {
	public List<GuestEntityBean> selectAllDbColumn();
}
