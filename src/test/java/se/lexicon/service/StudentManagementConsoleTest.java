package se.lexicon.service;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.config.ComponentScanConfig;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentScanConfig.class)
public class StudentManagementConsoleTest {

}
