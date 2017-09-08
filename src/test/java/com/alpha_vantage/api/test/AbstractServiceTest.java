package com.alpha_vantage.api.test;

import com.alpha_vantage.api.config.AppConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
public abstract  class AbstractServiceTest {
}
