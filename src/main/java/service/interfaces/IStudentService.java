package service.interfaces;

import entity.Student;
import exceptions.StudentException;

import java.util.List;

public interface IStudentService {
    void insert(Student student) throws StudentException;
    void update(Student student) throws StudentException;
    void delete(int id) throws StudentException;
    List<Student> get();
    Student get(int id);

}
