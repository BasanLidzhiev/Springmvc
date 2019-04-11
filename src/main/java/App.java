import entity.Student;
import repository.repositoryImpl.SGroupRepository;
import repository.repositoryImpl.StudentRepository;

public class App {

    public static void main(String[] args) {

        StudentRepository repository = new StudentRepository();
        Student student = repository.get(3);
        SGroupRepository repository1 = new SGroupRepository();


        student.setName("NeBasan");
        student.setBirthday("UpBirthday");
        student.setSGroup(repository1.get(1));
        repository.update(student);
    }
}
