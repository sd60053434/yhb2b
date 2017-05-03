package com.yh.springboot.service;

import com.yh.springboot.model.MdProductInfo;
import com.yh.springboot.vo.MdProductInfoVO;

public interface MdProductInfoService {

	MdProductInfo getProduct(String productCode);
	
	MdProductInfoVO searchProduct(String productCode);
}
