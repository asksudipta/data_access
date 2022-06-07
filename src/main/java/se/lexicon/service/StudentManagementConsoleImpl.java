package se.lexicon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.dao.StudentDao;
import se.lexicon.exception.DataNotFoundException;
import se.lexicon.model.Student;
import se.lexicon.util.UserInputService;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentManagementConsoleImpl implements StudentManagement {

    UserInputService userInputService;
    StudentDao studentDao;

    @Autowired
    public StudentManagementConsoleImpl(UserInputService userInputService, StudentDao studentDao) {
        this.userInputService = userInputService;
        this.studentDao = studentDao;
    }

    @Override
    public Student create() {
        System.out.println("Enter Student Name");
        String name = userInputService.getString();
        Student student = new Student(name);
        Student saveData = studentDao.save(student);
        return saveData;
    }

    @Override
    public Student save(Student student) {
        if (student == null) throw new IllegalArgumentException("Student is Null");
        return studentDao.save(student);
    }

    @Override
    public Student find(int id) {

        try {
            if (id >= 0) throw new IllegalArgumentException("Not valid Id");
            return studentDao.find(id);
        } catch (DataNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Student remove(int id){
        Student deleteId = find(id);
        if (deleteId != null) throw new IllegalArgumentException("Id is not valid");
        return remove(deleteId.getId());

    }

    @Override
    public List<Student> findAll() {
        // how to access the student list?
        return studentDao.findAll();
    }

    @Override
    public Student edit(Student student) {

        return null;
    }
}
