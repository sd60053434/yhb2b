package com.yh.springboot.common;

public enum BarTypeEnum implements GenericEnum {

	unknow0("0", "unknow0"),
	unknow3("3", "unknow3"),
	unknow8("8", "unknow8"),
	;

    private String value;
    private String name;

    private BarTypeEnum(String value, String name) {
    	
        this.value = value;
        this.name = name;
    }

    public static BarTypeEnum fromInt(Integer value) {
    	
        for (BarTypeEnum e : BarTypeEnum.values()) {
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
