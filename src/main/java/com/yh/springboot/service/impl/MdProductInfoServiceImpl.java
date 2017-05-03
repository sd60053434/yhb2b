package com.yh.springboot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yh.springboot.dao.es.MdProductInfoEsDAO;
import com.yh.springboot.dao.masterdata.MdProductInfoMapper;
import com.yh.springboot.model.MdProductInfo;
import com.yh.springboot.model.es.MdProductInfoIndex;
import com.yh.springboot.service.MdProductInfoService;
import com.yh.springboot.vo.MdProductInfoVO;
import com.yh.springboot.vo.converter.MdProductInfoConverter;

@Service("mdProductInfoService")
public class MdProductInfoServiceImpl implements MdProductInfoService {

	@Autowired
	private MdProductInfoMapper mdProductInfoMapper;
	@Autowired
	private MdProductInfoEsDAO mdProductInfoEsDAO;

	public MdProductInfo getProduct(String productCode) {
		
		MdProductInfo domain = this.mdProductInfoMapper.getModel(productCode);
		return domain;
	}

	@Override
	public MdProductInfoVO searchProduct(String productCode) {
		MdProductInfoIndex index = mdProductInfoEsDAO.findByProductCode(productCode);
		return MdProductInfoConverter.toVO(index);
	}

}

