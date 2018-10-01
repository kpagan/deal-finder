package org.kpagan.deal.finder;

import javax.annotation.PostConstruct;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.github.bonigarcia.wdm.WebDriverManager;

@Configuration
public class AppConfig {

	@PostConstruct
	public void init() {
		WebDriverManager.phantomjs().setup();
	}

	@Bean
	public WebDriver webDriver() {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
		desiredCapabilities.setJavascriptEnabled(true);
		WebDriver driver = new PhantomJSDriver(desiredCapabilities);
		return driver;
	}
}
