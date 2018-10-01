package org.kpagan.deal.finder;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpagan.deal.finder.domain.ExpressionType;
import org.kpagan.deal.finder.domain.Watch;
import org.kpagan.deal.finder.domain.WatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IntegrationTest {

    @Autowired
    private WatchRepository repo;
    
    @Test
    public void persistWatch() throws Exception {
    	Watch watch = new Watch();
    	watch.setName("Babylino 5+");
    	watch.setUrl("https://www.e-fresh.gr/el/panes-babylino-no-5-13-27-kg-68-tem");
    	watch.setType(ExpressionType.CLASS_NAME);
    	watch.setExpression("price_per_kg_prdpage");
    	watch.setThreshold(0.39);
    	repo.save(watch);
    }
}
