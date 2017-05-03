package com.yh.springboot.vo;

import java.util.Date;

import com.yh.springboot.common.BarTypeEnum;
import com.yh.springboot.common.ProductTypeEnum;
import com.yh.springboot.common.SeasonEnum;

@lombok.Data
public class MdProductInfoVO {

	private String id;

	private String productCode;

	private String productName;

	private String productBarCode;

	private String shortName;

	private String smallCategoryCode;

	private String brandCode;

	private BarTypeEnum barType;

	private ProductTypeEnum productType;

	private String productFlag;

	private Long taxRate;

	private Integer qualitativePeriod;

	private String unit;

	private String spec;

	private Long ppiTax;

	private Long contractPrice;

	private Long netWeight;

	private Long grossWeight;

	private SeasonEnum season;

	private String placeOrigin;

	private String manufacturer;

	private String purchasingLevel;

	private String ename;

	private String priceBeltType;

	private String countryOrigin;

	private Long creatorId;

	private Date createdStamp;

	private Date updateStamp;
}
