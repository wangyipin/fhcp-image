package com.njsecnet.fhcp.image.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @ProjectName: fhcp-image
 * @Package: com.njsecnet.fhcp.image.config
 * @ClassName: ApplicationProperties
 * @Description: 获取配置信息
 * @Author: wangyipin
 * @CreateDate: 2018/8/29 8:34
 * @Version: 1.0
 */

@Configuration
@ConfigurationProperties(prefix = "fhcp.image")
@PropertySource(value = {
		"classpath:config/applicationConfig.properties"}, encoding = "UTF-8", ignoreResourceNotFound = true)
public class ApplicationProperties {

	private String url;

	private String username;

	private String password;

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
