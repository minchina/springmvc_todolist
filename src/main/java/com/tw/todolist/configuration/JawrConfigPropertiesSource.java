package com.tw.todolist.configuration;

import net.jawr.web.resource.bundle.factory.util.PropsFilePropertiesSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

import static java.lang.String.format;
import static net.jawr.web.util.StringUtils.isNotEmpty;


public class JawrConfigPropertiesSource extends PropsFilePropertiesSource {

    private static final String JAWR_DEBUG_PROPERTY = "jawr.debug.on";
    private static final Logger LOGGER = LoggerFactory.getLogger(JawrConfigPropertiesSource.class);


    @Override
    protected Properties doReadConfig() {

        Properties properties = super.doReadConfig();
        String localOverride = System.getProperty(JAWR_DEBUG_PROPERTY);
        if(isNotEmpty(localOverride)) {
            LOGGER.warn(format("Overriding JAWR debug mode=%s", localOverride));
            properties.setProperty(JAWR_DEBUG_PROPERTY, localOverride);
        }
        return super.doReadConfig();
    }
}
