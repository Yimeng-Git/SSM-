package config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.EnumSet;


public class Config extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 过滤器
     *
     * @param servletContext
     * @throws ServletException
     */
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //触发父类onStartup
        super.onStartup(servletContext);
        //创建字符集过滤器对象
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        //设置使用的字符集
        characterEncodingFilter.setEncoding("UTF-8");
        //添加到容器（不是IOC容器，而是ServletMappings）
        FilterRegistration.Dynamic registration = servletContext.addFilter("characterEncodingFilter", characterEncodingFilter);
        //添加映射
        registration.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD,
                DispatcherType.INCLUDE), false, "/*");
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        /*AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(SpringConfigContext.class);*/
        return new Class[]{SpringConfigContext.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        /*AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
        ac.register(SpringMvcConfig.class);*/
        return new Class[]{SpringMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
