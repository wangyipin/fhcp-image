package com.njsecnet.fhcp.image.util;

import org.springframework.context.ApplicationContext;

/**
 * @ProjectName: fhcp-image
 * @Package: com.njsecnet.fhcp.image.util
 * @ClassName: SpringContextUtils
 * @Description: java类作用描述
 * @Author: wangyipin
 * @CreateDate: 2018/9/17 14:55
 * @Version: 1.0
 */
public final class SpringContextUtils {

	private SpringContextUtils() {
	}

	private static ApplicationContext applicationContext;

	public static void setApplicationContext(ApplicationContext applicationContext) {
		SpringContextUtils.applicationContext = applicationContext;
	}

	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}

}
