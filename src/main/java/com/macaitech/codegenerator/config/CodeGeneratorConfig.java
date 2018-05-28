package com.macaitech.codegenerator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(locations = {"classpath:application.yml"},prefix = "codeGenerator")
@EnableAutoConfiguration  
public class CodeGeneratorConfig {

    /**
     * 网站的根路径 例如 /CodeGenerator
     */
    private String webRoot;

    /**
     * 网站绝对物理路径 例如 D:/Tomcat/webapps/codegenerator/WEB-INF/classes/
     */
    private String absoluteWebRoot;

    //@Value("${codeGenerator.title}")
    private String title;

   // @Value("${codeGenerator.pageSize}")
    private Integer pageSize;

   // @Value("${codeGenerator.baiduMapAk}")
    private String baiduMapAk;

    //@Value("${spring.mail.username}")
    private String mailFrom;

	public String getWebRoot() {
		return webRoot;
	}

	public void setWebRoot(String webRoot) {
		this.webRoot = webRoot;
	}

	public String getAbsoluteWebRoot() {
		return absoluteWebRoot;
	}

	public void setAbsoluteWebRoot(String absoluteWebRoot) {
		this.absoluteWebRoot = absoluteWebRoot;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public String getBaiduMapAk() {
		return baiduMapAk;
	}

	public void setBaiduMapAk(String baiduMapAk) {
		this.baiduMapAk = baiduMapAk;
	}

	public String getMailFrom() {
		return mailFrom;
	}

	public void setMailFrom(String mailFrom) {
		this.mailFrom = mailFrom;
	}
    
    
}
