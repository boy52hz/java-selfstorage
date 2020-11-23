import Base.Person;
import StorageService.*;

public class SelfStorage {
    public static void main(String[] args) {
        StorageService storageService = new StorageService("SIT-Storage", 5);
        Person p1 = new Person("Tharadon ", " Saenmart");
        Storage myStorage = storageService.rentStorage(p1, 1.0, 1.0);
        Storage myStorage2 = storageService.rentStorage(p1, 2.0, 2.0);
        Storage myStorage3 = storageService.rentStorage(p1, 3.0, 3.0);
        Storage myStorage4 = storageService.rentStorage(p1, 4.0, 4.0);
        Storage myStorage5 = storageService.rentStorage(p1, 5.0, 5.0);
        storageService.unrentStorage(myStorage4);
        System.out.println(storageService);
   }
}
