package com.yh.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yh.springboot.model.MdProductInfo;
import com.yh.springboot.service.MdProductInfoService;
import com.yh.springboot.vo.MdProductInfoVO;

@RestController
public class ProductController {

	@Autowired
	private MdProductInfoService mdProductInfoService;

	@GetMapping("/productCode/{id}")
	public MdProductInfo getProduct(@PathVariable("id") String productCode) {
		return mdProductInfoService.getProduct(productCode);
	}

	@GetMapping("/search/productCode/{id}")
	public MdProductInfoVO searchProduct(@PathVariable("id") String productCode) {
		MdProductInfoVO vo = mdProductInfoService.searchProduct(productCode);
		return vo;
	}
}
