package StorageService;
/**
 *<h1>Self-Storage Service</h1>
 * @author 
 * @version 1.0
 * @since 2020-11-10
 */
import Base.Person;

public class StorageService {
    private String name;
    private StorageList storages;
    private ServiceCalculation serviceCalculation;
    
    public StorageService(String name, int storageLot) {
        this.name = name;
        this.storages = new StorageList(storageLot);
    }

    public Storage rentStorage(Person customer, double lengthM, double widthM) {
        if (storages.isFull()) {
            return null;
        }
        Storage storage = new Storage(customer, lengthM, widthM);
        storages.add(storage);
        return storage;
    }
    
    public boolean unrentStorage(Storage storage) {
        int storageIndex = storages.findIndex(storage);
        if (storageIndex == -1) {
            return false;
        }
        storages.removeAt(storageIndex);
        return true;
    }
    
    public int getAvaliable() {
        return storages.getAvaliable();
    }
    
    public int getOwnedStorage() {
        return storages.getOwnedStorage();
    }
    
    public boolean isFull() {
        return storages.isFull();
    }
    
    public double getServiceFee(Storage storage){
        double storageArea = storage;
        return serviceCalculation.getServiceFee(storageArea);
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
