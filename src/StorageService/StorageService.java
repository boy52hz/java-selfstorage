package StorageService;
/**
 *<h1>Self-Storage Service</h1>
 * @author Tharadon Saenmart
 * @version 1.0
 * @since 2020-11-10
 */
import Base.Person;
import java.time.LocalDateTime;

public class StorageService {
    private String name;
    private StorageList storages;
    private ServiceCalculation serviceCalculation;
    
    public StorageService(String name, int storageLot, double serviceRate) {
        this.name = name;
        this.storages = new StorageList(storageLot);
        this.serviceCalculation = new ServiceCalculation(serviceRate);
    }

    public Storage rentStorage(Person customer, double lengthM, double widthM, LocalDateTime stampTimeRented) {
        if (storages.isFull()) {
            return null;
        }
        Storage storage = new Storage(customer, lengthM, widthM);
        storages.add(storage);
        storage.stampTimeRented(stampTimeRented);
        System.out.println("Your service fee: " + serviceCalculation.getServiceFee(storage.getArea()) + "baht / month.");
        return storage;
    }
    
    public Storage rentStorage(Person customer, double lengthM, double widthM) {
        return rentStorage(customer, lengthM, widthM, LocalDateTime.now());
    }
    
    public boolean unrentStorage(Storage storage, LocalDateTime stampTimeUnrented) {
        int storageIndex = storages.findIndex(storage);
        if (storageIndex == -1) {
            return false;
        }
        storages.removeAt(storageIndex);
        storage.stampTimeUnrented(stampTimeUnrented);
        return true;
    }
    
    public boolean unrentStorage(Storage storage) {
        return unrentStorage(storage, LocalDateTime.now());
    }
    
    public int getAvaliable() {
        return storages.getAvaliable();
    }
    
    public int getOwnedStorage() {
        return storages.getOwnedStorage();
    }
    
    public void printInvoice(Storage storage) {
        double invoice = serviceCalculation.getInvoice(storage.getTimeRented(), storage.getArea());
        System.out.println("Invoice: " + invoice + " baht");
    }
    
    public boolean isFull() {
        return storages.isFull();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StorageService{name=").append(name);
        sb.append(", owned=").append(getOwnedStorage());
        sb.append(", avaliable=").append(getAvaliable());
        sb.append(", storages=").append(storages);
        sb.append('}');
        return sb.toString();
    }
}
