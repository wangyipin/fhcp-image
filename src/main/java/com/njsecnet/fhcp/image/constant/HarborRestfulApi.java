package com.njsecnet.fhcp.image.constant;

import com.njsecnet.fhcp.image.config.ApplicationProperties;
import com.njsecnet.fhcp.image.util.SpringContextUtils;

public class HarborRestfulApi {

	/**
	 * api_search 获取project 和 repositories
	 */
	public static final String api_search = SpringContextUtils.getBean(ApplicationProperties.class).getUrl()
			+ "/api/search";

	/**
	 * harbor restful api 获取项目列表，检查用户提供的项目名称是否存在，创建一个新项目地址
	 */
	public static final String api_projects = SpringContextUtils.getBean(ApplicationProperties.class).getUrl()
			+ "/api/projects";

	/**
	 * 检查用户提供的项目名称是否已存在
	 */
	public static final String api_project_name_isExists = SpringContextUtils.getBean(ApplicationProperties.class)
			.getUrl() + "/api/projects";

	/**
	 * 创建一个新项目
	 */
	public static final String api_create_new_project = SpringContextUtils.getBean(ApplicationProperties.class).getUrl()
			+ "/api/projects";
}
