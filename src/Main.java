import Base.Person;
import StorageService.*;

public class Main {
    public static void main(String[] args) {
        StorageService storageService = new StorageService("SIT-Storage", 10);
        Person p1 = new Person("Tharadon", "Saenmart");
        Storage myStorage = storageService.rentStorage(p1, 1.0, 1.0);
        Storage myStorage2 = storageService.rentStorage(p1, 3.0, 3.0);
        storageService.unrentStorage(myStorage2);
        myStorage2 = storageService.rentStorage(p1, 9.0, 9.0);
        storageService.rentStorage(p1, 7.0, 7.0);
        storageService.rentStorage(p1, 7.0, 7.0);
        storageService.unrentStorage(myStorage2);
        System.out.println(storageService);
    }
}
