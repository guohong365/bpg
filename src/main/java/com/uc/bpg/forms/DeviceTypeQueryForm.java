package com.uc.bpg.forms;

import java.util.Map;


public class DeviceTypeQueryForm extends QueryFormBase  {
	public static final String ORDER_BY_COLUMN_NAME="型号";
	public static final String ORDER_BY_COLUMN_PRODUCT="产品名称";
	public static final String ORDER_BY_COLUMN_SHOW_ORDER="显示顺序";
	
	private String queryName;
	private String queryProduct;
	
	
	@Override
	protected void buildOrderByColumnMap() {
		Map<String, String> map= getColumnMap();
		map.put(ORDER_BY_COLUMN_NAME, "NAME");
		map.put(ORDER_BY_COLUMN_PRODUCT, "PRODUCT");
		map.put(ORDER_BY_COLUMN_SHOW_ORDER, "SHOW_ORDER");		
	}


	public String getQueryName() {
		return queryName;
	}


	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}


	public String getQueryProduct() {
		return queryProduct;
	}


	public void setQueryProduct(String queryProduct) {
		this.queryProduct = queryProduct;
	}
}
