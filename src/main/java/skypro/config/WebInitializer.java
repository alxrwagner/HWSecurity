package skypro.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // Не используем
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    // Указываем сервлет конфиг класс
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{Config.class};
    }

    // Мапинг для сервлета. Обрабатывает все запросы, поэтому "/"
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
