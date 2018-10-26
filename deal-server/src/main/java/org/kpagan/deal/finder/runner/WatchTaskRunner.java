package org.kpagan.deal.finder.runner;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.kpagan.deal.finder.domain.Watch;
import org.kpagan.deal.finder.domain.WatchRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class WatchTaskRunner implements TaskRunner {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WatchTaskRunner.class);

	@Autowired
	private WebDriver driver;

	@Autowired
	private WatchRepository watchRepository;
	private static final Pattern NUMBERS = Pattern.compile("(\\d+(?:\\.\\d+)?)");

	@Override
	public void run() {
		List<Watch> watches = watchRepository.findAll();
		
		for (Watch watch : watches) {
			LOGGER.debug("Rule: {}", watch.getName());
			LOGGER.debug("Looking for deal in {}", watch.getUrl());
			String baseUrl = watch.getUrl();
			driver.get(baseUrl);
			try {
				WebElement element = driver.findElement(getExpression(watch));
				String text = element.getText();
				Matcher matcher = NUMBERS.matcher(text);
				while (matcher.find()) {
					String group = matcher.group();
					try {
						Double value = Double.parseDouble(group);
						if (value <= watch.getThreshold()) {
							LOGGER.info("Found a true DEAL: {}", watch.getUrl());
						}
						LOGGER.info("Value: {}, thresshold is: {}", value, watch.getThreshold());
					} catch (NumberFormatException nfe) {
						LOGGER.warn("Could not parse the value {} as a valid number", group, nfe);
					}
				}
			} catch (NoSuchElementException e) {
				LOGGER.warn(
						"Could not find matching element in {} with expression {}({}). Invalid configuration or page changed maybe?",
						watch.getUrl(), watch.getType(), watch.getExpression(), e);
			}
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
