package cn.ideacs.application.woodeasy;

import cn.ideacs.application.woodeasy.config.WoodEasyMvcConfig;
import cn.ideacs.application.woodeasy.config.WoodEasyRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * @author yang
 * @date 17-12-19
 */
public class WoodEasyInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WoodEasyRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WoodEasyMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 设置上传文件的大小
     * @param registration
     */
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("/home/ubuntu/file", 2097152,4194304,0)
        );
    }
}
