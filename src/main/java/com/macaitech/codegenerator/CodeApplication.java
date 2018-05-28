/**
 * 
 */
package com.macaitech.codegenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import com.macaitech.codegenerator.config.CodeGeneratorConfig;

/**
 * @author yuhui.tang 2018年5月23日 下午4:47:32
 * 
 */
@SpringBootApplication
public class CodeApplication implements ApplicationListener<ContextRefreshedEvent> {

	@Autowired
	private CodeGeneratorConfig codeGeneratorConfig;

	public static void main(String[] args) {
		SpringApplication.run(CodeApplication.class, args);
	}

	@Override
	public void onApplicationEvent(final ContextRefreshedEvent event) {
		codeGeneratorConfig.setWebRoot(event.getApplicationContext().getApplicationName() + "/");
		codeGeneratorConfig.setAbsoluteWebRoot(this.getClass().getResource("/").getPath().replaceFirst("/", ""));
	}
}
