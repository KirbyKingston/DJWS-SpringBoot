package distjavaws;

import org.springframework.context.annotation.Configuration;
import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @author Mitch
 */
@Configuration
public class WelcomePage implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/Index.xhtml");
        registry.setOrder(HIGHEST_PRECEDENCE);
    }

}
