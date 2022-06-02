package se.lexicon.dao;

import org.springframework.stereotype.Component;
import se.lexicon.dao.StudentDao;
import se.lexicon.model.Student;

import java.util.ArrayList;
import java.util.List;


@Component
public class StudentDaoListImpl implements StudentDao {

    List<Student> studentInformation;

    public StudentDaoListImpl() {
        studentInformation=new ArrayList<>();
    }

    @Override
    public Student save(Student student) {
        if(student==null) throw new  IllegalArgumentException("Student is null");
        studentInformation.add(student);
        return student;
    }

    @Override
    public Student find(int id) {
        if(id==0)throw new IllegalArgumentException("Id is null");
        return studentInformation.stream().filter(student -> student.getId()==id).findFirst().orElse(null);

    }

    @Override
    public List<Student> findAll() {
        return studentInformation;
    }

    @Override
    public void delete(int id) {
     Student deleteId=find(id);
     if(deleteId!=null)studentInformation.remove(id);

    }
}
