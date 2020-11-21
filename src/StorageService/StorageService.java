package StorageService;

import Base.Person;

public class StorageService {
    private String name;
    private StorageList storages;
    
    public StorageService(String name, int storageLot) {
        this.name = name;
        this.storages = new StorageList(storageLot);
    }
    /***
     * TODO: Customer will require storage type that he/she need
     * 1.check if customer can afford this
     * 
     * @param customer
     * @param storageType
     * @return Storage
     */
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("StorageService{name=").append(name);
        sb.append(", storages=").append(storages);
        sb.append('}');
        return sb.toString();
    }
}
