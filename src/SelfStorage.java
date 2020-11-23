import Base.Person;
import StorageService.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class SelfStorage {
    public static void main(String[] args) {
        StorageService storageService = new StorageService("SIT-Storage", 5, 100);
        Person p1 = new Person("Tharadon", " Saenmart");
        Person p2 = new Person("Tawan", "Tawan Muadmuenwai");
        Person p3 = new Person("Chinnawat", "Kaewnongsang");
        LocalDateTime rentTime = LocalDateTime.of(2020, Month.SEPTEMBER, 23, 10, 51);
        Storage myStorage = storageService.rentStorage(p1, 1.0, 1.0, rentTime);
        Storage myStorage2 = storageService.rentStorage(p2, 2.0, 2.0);
        Storage myStorage3 = storageService.rentStorage(p3, 3.0, 3.0);
        Storage myStorage4 = storageService.rentStorage(p1, 4.0, 4.0);
        storageService.unrentStorage(myStorage4);
        System.out.println(storageService);
        System.out.println("=======================");
        storageService.printInvoice(myStorage);
   }
}
