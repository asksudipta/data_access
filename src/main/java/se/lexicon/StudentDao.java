package se.lexicon;

import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDao {
    Student save(Student student);

    Student find(int id);

    List<Student> findAll();

    void delete(int id) throws DataNotFoundException;
}
