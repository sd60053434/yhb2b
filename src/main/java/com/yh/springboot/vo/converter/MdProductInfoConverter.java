package com.yh.springboot.vo.converter;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Lists;
import com.yh.springboot.model.es.MdProductInfoIndex;
import com.yh.springboot.vo.MdProductInfoVO;

public class MdProductInfoConverter {

	public static final MdProductInfoVO toVO(MdProductInfoIndex index) {
		if (null == index) {
			return null;
		}
		MdProductInfoVO vo = new MdProductInfoVO();
		vo.setId(index.getId());
		vo.setBarType(index.getBarType());
		vo.setBrandCode(index.getBrandCode());
		vo.setContractPrice(index.getContractPrice());
		vo.setCountryOrigin(index.getCountryOrigin());
		vo.setCreatedStamp(index.getCreatedStamp());
		vo.setCreatorId(index.getCreatorId());
		vo.setEname(index.getEname());
		vo.setGrossWeight(index.getGrossWeight());
		vo.setManufacturer(index.getManufacturer());
		vo.setNetWeight(index.getNetWeight());
		vo.setPlaceOrigin(index.getPlaceOrigin());
		vo.setPpiTax(index.getPpiTax());
		vo.setPriceBeltType(index.getPriceBeltType());
		vo.setProductType(index.getProductType());
		vo.setProductBarCode(index.getProductBarCode());
		vo.setProductCode(index.getProductCode());
		vo.setProductFlag(index.getProductFlag());
		vo.setProductName(index.getProductName());
		vo.setPurchasingLevel(index.getPurchasingLevel());
		vo.setQualitativePeriod(index.getQualitativePeriod());
		vo.setSeason(index.getSeason());
		vo.setShortName(index.getShortName());
		vo.setSmallCategoryCode(index.getSmallCategoryCode());
		vo.setSpec(index.getSpec());
		vo.setTaxRate(index.getTaxRate());
		vo.setUnit(index.getUnit());
		vo.setUpdateStamp(index.getUpdateStamp());
		return vo;
	}

	public static final List<MdProductInfoVO> toVOs(Collection<MdProductInfoIndex> domains) {
		if (CollectionUtils.isEmpty(domains)) {
			return Collections.<MdProductInfoVO>emptyList();
		}
		List<MdProductInfoVO> vos = Lists.<MdProductInfoVO>newArrayList();
		for (MdProductInfoIndex domain : domains) {
			vos.add(toVO(domain));
		}
		return vos;
	}
}
