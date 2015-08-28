package org.tw.todo.integrationTests;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Properties;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class LoadPropertiesTest {

    @Autowired
    private Properties regionProperties;

    @Test
    public void shouldGetRateSuccessOfProperties() {
        String rate = regionProperties.getProperty("rate");
        assertThat(Double.valueOf(rate), is(0.15));
    }
}
