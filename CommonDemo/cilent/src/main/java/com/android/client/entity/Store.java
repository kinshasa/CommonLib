package com.android.client.entity;

import java.io.Serializable;

/**
 * 门店简要数据
 * 
 * @author liushaobo
 * 
 * 
 */
public class Store implements Serializable {

	private static final long serialVersionUID = 9072453042124423072L;
	//public String store_id;
	public String store_name;
	public String store_address;
	public int distance;
	public int store_store_used;// 门店卡是否可用｛0,1｝
	public int store_platform_used;// 枫车券是否可用｛0,1｝
	public int store_bonus_used;// 红包是否可用｛0,1｝
	public String store_logo;
	public int store_open_type;// 门店是否营业{0,1}
	public String store_open_formated;
	public String latitude;
	public String longitude;
	public String store_score_avg;// 门店评分
	public String region_id;
	public String region_name;
}
