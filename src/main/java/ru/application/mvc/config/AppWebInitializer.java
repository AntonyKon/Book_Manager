package ru.application.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static String LOCATION = "/tmp";
    private static final long MAX_FILE_SIZE = 8 * 1024 * 1024 * 25;//25MB
    private static final long MAX_REQUEST_SIZE = 8 * 1024 * 1024 * 30;//30MB
    private static final int FILE_SIZE_THRESHOLD = 0;


    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        // Add some filters in configuration
        servletContext.addFilter("hiddenMethodFilter",
                new HiddenHttpMethodFilter()).addMappingForUrlPatterns(null, true, "/*");
        servletContext.addFilter("UTFFilter",
                new CharacterEncodingFilter("UTF-8", true)).addMappingForUrlPatterns(null,
                true, "/*");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(getMultipartConfigElement());
    }

    private MultipartConfigElement getMultipartConfigElement(){
        return new MultipartConfigElement(LOCATION, MAX_FILE_SIZE, MAX_REQUEST_SIZE, FILE_SIZE_THRESHOLD);
    }
}
