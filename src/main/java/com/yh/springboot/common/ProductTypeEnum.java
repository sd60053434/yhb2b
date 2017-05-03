package com.yh.springboot.common;

/**
Z001
Z003
Z004
Z005
Z008
 *
 */
public enum ProductTypeEnum implements GenericEnum {

	Z001("Z001", "Z001"),
	Z003("Z003", "Z003"),
	Z004("Z004", "Z004"),
	Z005("Z005", "Z005"),
	Z008("Z008", "Z008"),
	;

    private String value;
    private String name;

    private ProductTypeEnum(String value, String name) {
    	
        this.value = value;
        this.name = name;
    }

    public static ProductTypeEnum fromInt(Integer value) {
    	
        for (ProductTypeEnum e : ProductTypeEnum.values()) {
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
