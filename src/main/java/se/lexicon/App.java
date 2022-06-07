package se.lexicon;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;

public class App {
    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        StudentDao studentDao = context.getBean(StudentDao.class);
        studentDao.save(new Student(1, "test"));
        System.out.println(studentDao.findAll());


        AnnotationConfigApplicationContext context1 =
                new AnnotationConfigApplicationContext(ComponentScanConfig.class);

        UserInputService userInputService = context.getBean(UserInputService.class);



    }
}
