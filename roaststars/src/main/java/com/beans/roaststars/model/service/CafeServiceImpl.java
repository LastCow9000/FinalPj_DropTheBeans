package com.beans.roaststars.model.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.beans.roaststars.model.mapper.CafeMapper;
import com.beans.roaststars.model.vo.CafeVO;

@Service
public class CafeServiceImpl implements CafeService {

	@Resource
	private CafeMapper cafeMapper;
	
	@Override
	public CafeVO findCafeByCafeNo(String cafeNo) {
		return cafeMapper.findCafeByCafeNo(cafeNo);
	}
	
	@Override
	public List<CafeVO> findListByLoc(String loc) {
		return cafeMapper.findListByLoc(loc);
	}

}
