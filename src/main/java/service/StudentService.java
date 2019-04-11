package service;

import entity.Student;
import exceptions.StudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import repository.repositoryImpl.StudentRepository;
import service.interfaces.IStudentService;

import java.util.List;

@Component
@RequestScope
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository repository;

    @Override
    public void insert(Student student) throws StudentException {
        if (!repository.insert(student))
            throw new StudentException("Student don't insert");
    }

    @Override
    public void update(Student student) throws StudentException {
        if (!repository.update(student))
            throw new StudentException("Student don't update");
    }

    @Override
    public void delete(int id) throws StudentException {
        if (!repository.delete(id))
            throw new StudentException("Student don't delete");
    }

    @Override
    public List<Student> get() {
        return repository.get();
    }

    @Override
    public Student get(int id) {
        return repository.get(id);
    }

}