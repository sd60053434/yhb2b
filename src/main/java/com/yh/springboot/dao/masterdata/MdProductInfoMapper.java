package com.yh.springboot.dao.masterdata;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.yh.springboot.model.MdProductInfo;

@Repository
public interface MdProductInfoMapper {

	int add(MdProductInfo record);

	int insertSelective(MdProductInfo record);

	MdProductInfo getModel(String id);

	MdProductInfo getByProductCode(@Param("productCode") String productCode);

	MdProductInfo getByProductBarCode(@Param("productBarCode") String productBarCode);
}