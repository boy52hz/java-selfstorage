package StorageService;

public class StorageList {
    private static int count;
    private Storage[] storageList;
    
    public StorageList(int size) {
        this.storageList = new Storage[size];
    }

    public void add(Storage storage) {
        storageList[count++] = storage;
    }
    
    public Storage find(int id) {
        for (int i = 0; i < count; i++) {
            if (storageList[i].getId() == id) return storageList[i];
        }
        return null;
    }
    
    public int findIndex(Storage storage) {
        for (int i = 0; i < count; i++) {
            if (storageList[i].equals(storage)) return i;
        }
        return -1;
    }
    
    public boolean isFull() {
        return (count >= storageList.length);
    }
}
