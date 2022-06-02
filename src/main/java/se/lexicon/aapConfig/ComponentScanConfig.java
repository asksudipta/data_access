package se.lexicon.aapConfig;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import se.lexicon.StudentDao;


@Configuration
@ComponentScan(basePackages = "se.lexicon")
public class ComponentScanConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ConfigFileName.class);

        StudentDao studentDao = context.getBean(StudentDao.class);
    }

    private static class ConfigFileName {
    }
}
