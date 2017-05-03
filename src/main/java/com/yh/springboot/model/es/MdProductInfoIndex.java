package com.yh.springboot.model.es;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.yh.springboot.common.BarTypeEnum;
import com.yh.springboot.common.ProductTypeEnum;
import com.yh.springboot.common.SeasonEnum;

@lombok.Data
@Document(indexName = "md_product_info", type = "md_product_info", shards = 1, replicas = 1, indexStoreType = "fs", refreshInterval = "-1")
public class MdProductInfoIndex implements java.io.Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
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
	
	public String GenerateKey() {
		this.id = this.productCode;
		return this.id;
	}
}
