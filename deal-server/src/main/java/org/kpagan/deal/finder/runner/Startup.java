package org.kpagan.deal.finder.runner;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Startup implements ApplicationRunner {

	private static final Logger LOGGER = LoggerFactory.getLogger(Startup.class);

	@Autowired
	private List<TaskRunner> runners;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		for (TaskRunner runner : runners) {
			try {
				runner.run();
			} catch (Throwable e) {
				LOGGER.error("Error while running runner {}", runner.getClass().getName(), e);
			}
		}
	}

}
