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
    
    /**
     * Creates StorageService with the given name, size and service rate
     * @param name the name of this StorageService
     * @param storageLot the number of storages
     * @param serviceRate the rate which will be multiplied by the storage's
     * area upon calculating the fee
     */
    public StorageService(String name, int storageLot, double serviceRate) {
        this.name = name;
        this.storages = new StorageList(storageLot);
        this.serviceCalculation = new ServiceCalculation(serviceRate);
    }

    /**
     * Adds new storage to the storage list with the given owner,
     * length and width of the Storage
     * @param customer the Person object
     * @param lengthM the length of the storage in meter
     * @param widthM the width of the storage in meter
     * @param stampTimeRented storage rented date time
     * @return the Storage object if the storage list
     * is not full, null otherwise
     */
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
    
    /**
     * Removes the given Storage object in the storage list
     * @param storage the Storage object to be removed
     * @param stampTimeUnrented storage unrented date time
     * @return true if the given Storage object is in the storage list,
     * false otherwise
     */
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
    
     /**
     * Checks the number of available storages in the list
     * @return the number of available storages in the list
     */
    public int getAvaliable() {
        return storages.getAvaliable();
    }
    
    /**
     * Checks the number of owned storages in the list
     * @return the number of owned storages in the list
     */
    public int getOwnedStorage() {
        return storages.getOwnedStorage();
    }
    
    /***
     * Print calculated invoice
     * @param storage
     */
    public void printInvoice(Storage storage) {
        double invoice = serviceCalculation.getInvoice(storage.getTimeRented(), storage.getArea());
        System.out.println("Invoice: " + invoice + " baht");
    }
    
    /**
     * Checks if the list is full or not
     * @return true if the list is full, false otherwise.
     */
    public boolean isFull() {
        return storages.isFull();
    }

    /**
     * 
     * @return StorageService's details including name, number of 
     * owned storages, number of available storages and Storage objects
     * in the list with their data
     */
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
