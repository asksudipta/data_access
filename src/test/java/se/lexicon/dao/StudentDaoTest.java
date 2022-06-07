package se.lexicon.dao;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import se.lexicon.config.ComponentScanConfig;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Student;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ComponentScanConfig.class)
public class StudentDaoTest {
    @Autowired
    StudentDao testObject;


    @BeforeEach
    public void setUp() {
        testObject.save(new Student("Sudipta"));
    }

    @Test
    @DisplayName("The Student record saved successfully")
    void save() {
    }
}
