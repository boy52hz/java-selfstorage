import Base.Person;
import StorageService.*;

public class Main {
    public static void main(String[] args) {
        StorageService ss = new StorageService("SIT-Storage", new StorageList(10));
        Person person = new Person("Tharadon", "Saenmart");
    }
}
