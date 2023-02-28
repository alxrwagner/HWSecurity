package skypro.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@ComponentScan(basePackages = "skypro")
@EnableWebMvc
public class Config {

    @Bean
    // Будет возвращать бин отображения (ранее формировали через applicationContext)
    public ViewResolver getViewResolver(){
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

        // Для простого обращения из контроллера только по имени, создаем префикс (содержит путь к файлу) и суфикс (содержит расширение файла):
        viewResolver.setPrefix("/WEB-INF/view/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Bean
    public DataSource getDataSource(){
        ComboPooledDataSource dataSource = new ComboPooledDataSource();

        try{
            dataSource.setDriverClass("org.postgresql.Driver"); // устанавливаем драйвер
            dataSource.setJdbcUrl("jdbc:postgresql://localhost/postgres"); // устанавливаем url для подключения к БД
            dataSource.setUser("postgres"); // устанавливаем пользователя БД
            dataSource.setPassword("0000"); // устанавливаем пароль БД
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return dataSource;
    }
}
