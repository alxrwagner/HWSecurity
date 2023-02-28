package skypro.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;

import javax.sql.DataSource;

@EnableWebSecurity
// Ответственный за хранение данных пользователей
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    public SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // Переопределение метода, который принимает AuthenticationManagerBuilder
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource);
    }

    // Переопределение метода, который принимает HttpSecurity
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").hasAnyRole("EMPLOYEE", "IT", "SECURITY", "DIRECTOR") // Для перехода по любым ссылкам разрешаем все роли
                .antMatchers("/servers_room").hasAnyRole("IT", "SECURITY", "DIRECTOR") // По остальным url переход разоешаем только отдельным ролям
                .antMatchers("/security_room").hasAnyRole("SECURITY", "DIRECTOR")
                .antMatchers("/director_room").hasAnyRole("DIRECTOR")
                .and().formLogin().permitAll(); // Все пользователь должны проходить полную проверку
    }
}
