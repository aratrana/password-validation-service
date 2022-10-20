package com.pass.validators.i18n;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesMessageResolver extends AbstractI18nMessageResolver {
    public static final String DEFAULT_MESSAGE_PATH = "passwordResource.properties";

    private final Properties messageProperties;

    public PropertiesMessageResolver() {
        this(getDefaultProperties());
    }

    @Override
    protected String getMessage(final String key) {
        return messageProperties.getProperty(key);
    }


    public PropertiesMessageResolver(final Properties properties) {
        if (properties == null) {
            throw new IllegalArgumentException("Properties cannot be null.");
        }
        messageProperties = properties;
    }

    public static Properties getDefaultProperties() {
        final Properties props = new Properties();
        InputStream in = null;
        try {
            in = PropertiesMessageResolver.class.getResourceAsStream(
                    DEFAULT_MESSAGE_PATH);
            props.load(in);
        } catch (Exception e) {
            throw new IllegalStateException(
                    "Error loading default message properties.",
                    e);
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return props;
    }


}
