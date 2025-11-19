package org.carpenoctemcloud.configuration;

import org.carpenoctemcloud.request_logging.RequestLogInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configures the interceptors of the application.
 */
@Configuration
public class InterceptorConfiguration implements WebMvcConfigurer {
    private final RequestLogInterceptor requestLogInterceptor;

    /**
     * Creates a new InterceptorConfiguration.
     *
     * @param requestLogInterceptor The interceptor used for collecting request statistics.
     */
    public InterceptorConfiguration(RequestLogInterceptor requestLogInterceptor) {
        this.requestLogInterceptor = requestLogInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestLogInterceptor);
    }
}
