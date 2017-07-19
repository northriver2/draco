package com.netstatx.draco.core.telemetry.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

/**
 * @author wangle<thisiswangle@gmail.com>
 */
@Configuration
public class WebConfig {
    @Bean
    @Primary
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"))
                .disable(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES)
                .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
                .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
                .setSerializationInclusion(JsonInclude.Include.NON_NULL)
                .setTimeZone(TimeZone.getTimeZone("GMT+8"));
    }
}
