import repository.repositoryImpl.SGroupRepository;
import repository.repositoryImpl.StudentRepository;

public class App {

    public static void main(String[] args) {
        StudentRepository repository = new StudentRepository();
        System.out.println(repository.get());
    }
}
