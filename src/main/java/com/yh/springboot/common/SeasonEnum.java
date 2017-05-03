package com.yh.springboot.common;

/**
 * md_product_info
 * season 默认0001，0001非季节性商品；0002季节性商品；0003春；0004夏；0005秋；0006冬
 */
public enum SeasonEnum implements GenericEnum {

	NON_SEASONAL_COMMODITY("0001", "非季节性商品"),
	SEASONAL_COMMODITY("0002", "季节性商品"),
	SPRING("0003", "春"),
	SUMMER("0004", "夏"),
	AUTUMN("0005", "秋"),
	WINTER("0006", "冬"),
	;

    private String value;
    private String name;

    private SeasonEnum(String value, String name) {
    	
        this.value = value;
        this.name = name;
    }

    public static SeasonEnum fromInt(Integer value) {
    	
        for (SeasonEnum e : SeasonEnum.values()) {
            if (e.getValue().equals(value)) {
                return e;
            }
        }
        throw new IllegalArgumentException("参数不正确，没有找到对应的BusinessTypeEnum");
    }
    
	@Override
	public String getValue() {
		
		return value;
	}
	
	@Override
	public String getName() {
		
		return name;
	}
}
