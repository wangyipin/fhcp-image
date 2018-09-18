package com.njsecnet.fhcp.image.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ProjectName: fhcp-image
 * @Package: com.njsecnet.fhcp.image.config
 * @ClassName: ApplicationProperties
 * @Description: java类作用描述
 * @Author: wangyipin
 * @CreateDate: 2018/9/18 9:35
 * @Version: 1.0
 */
@Configuration
@PropertySource(value = {
		"classpath:config/applicationConfig.properties"}, encoding = "utf-8", ignoreResourceNotFound = true)
@ConfigurationProperties(prefix = "fhcp.image")
public class ApplicationProperties {

	private String url;
	private String userName;
	private String password;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
