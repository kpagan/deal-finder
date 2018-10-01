package org.kpagan.deal.finder.shutdown;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * @author paganelis
 *
 */
@Component
public class GracefulShutdown {
	
	private static final Logger log = LoggerFactory.getLogger(GracefulShutdown.class);
	
	@Autowired
	private WebDriver driver;

	private void handleContextEvent(ApplicationContextEvent event) {
		log.info("Shutting down context {}", event);
		if (driver != null) {
			driver.close();
		}
	}
	
	@EventListener
    public void handleContextStopped(ContextStoppedEvent event) {
		log.info("Application context is stopping!!!");
        handleContextEvent(event);
    }

    @EventListener
    public void handleContextClosed (ContextClosedEvent event) {
    	log.info("Application context is closing!!!");
        handleContextEvent(event);
    }

}
