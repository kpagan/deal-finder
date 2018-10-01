package org.kpagan.deal.finder.runner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.kpagan.deal.finder.domain.Watch;
import org.kpagan.deal.finder.domain.WatchRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Startup implements ApplicationRunner {

	public static final String PROXY = "webproxy.nrb.be:8080";
	public static final String AUTO_CONFIG_PROXY = "http://webproxynrb.nrb.be/web.pac";

	@Autowired
	private WebDriver driver;

	@Autowired
	private WatchRepository watchRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		try {

			List<Watch> watches = watchRepository.findAll();
			
			for (Watch watch : watches) {
				System.out.println("Rule: " + watch.getName());
				System.out.println("Looking for deal in " + watch.getUrl());
				String baseUrl = watch.getUrl(); //"https://www.e-fresh.gr/el/panes-babylino-no-5-13-27-kg-68-tem";
				driver.get(baseUrl);
				WebElement element = driver.findElement(getExpression(watch));
				String text = element.getText();
				Pattern numbers = Pattern.compile("(\\d+(?:\\.\\d+)?)");
				Matcher matcher = numbers.matcher(text);
				System.out.println(matcher.groupCount());
				while (matcher.find()) {
					String group = matcher.group();
					try {
						Double value = Double.parseDouble(group);
						if (value <= watch.getThreshold()) {
							System.out.println("Found a true DEAL: " + watch.getUrl());
						}
						System.out.println(value);
					} catch (NumberFormatException nfe) {
						nfe.printStackTrace();
					}
				}
				
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
	
	private By getExpression(Watch watch) {
		switch (watch.getType()) {
		case CLASS_NAME:
			return By.className(watch.getExpression());
		case CSS_SELECTOR:
			return By.cssSelector(watch.getExpression());
		case ID:
			return By.id(watch.getExpression());
		case LINK_TEXT:
			return By.linkText(watch.getExpression());
		case NAME:
			return By.name(watch.getExpression());
		case PARTIAL_LINK_TEXT:
			return By.partialLinkText(watch.getExpression());
		case TAG_NAME:
			return By.tagName(watch.getExpression());
		case XPATH:
			return By.xpath(watch.getExpression());
		default:
			throw new IllegalArgumentException("Not suitable expression type: " + watch.getType());
		}
	}

}
