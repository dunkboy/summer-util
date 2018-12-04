package org.poor.framework.utils.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix = "threadpool")
public class ThreadPoolProperties
{
    private Integer corePoolSize;
    private Integer keepAliveSeconds;
    private Integer maxPoolSize;
    private Integer queueCapacity;
}
