package se.lexicon.dao;

import org.springframework.stereotype.Component;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentDaoListImpl implements StudentDao {

    List<Student> studentInformation;

    public StudentDaoListImpl() {
        studentInformation = new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("Student is null");
        studentInformation.add(student);
        return student;
    }

    @Override
    public Student update(Student toUpdate) {
        if (toUpdate == null) throw new IllegalArgumentException("Student is null");
        Student originalData = studentInformation.stream()
                .filter(student1 -> student1.getId() == toUpdate.getId()).findFirst().orElse(null);
       int index = studentInformation.indexOf(originalData);
       studentInformation.set(index,toUpdate);
        return originalData;
    }

    @Override
    public Student find(int id) throws DataNotFoundException {
        if (id == 0) throw new IllegalArgumentException("Id is null");
        return studentInformation.stream()
                .filter(student -> student.getId() == id).findFirst()
                .orElseThrow(() -> new DataNotFoundException(" Data Not Found", "Student"));

    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(studentInformation);
    }

    @Override
    public void delete(int id) throws DataNotFoundException {
        Student deleteId = find(id);
        if (deleteId != null) studentInformation.remove(id);

    }

    public void clearData() {
        studentInformation.clear();
    }
}
