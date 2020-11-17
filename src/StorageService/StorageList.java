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
    
    public boolean removeAt(int index) {
        count--;
        storageList[index] = storageList[count];
        storageList[count] = null;
        return true;
    }
    
    public Storage find(int id) {
        Storage storage = null;
        for (int i = 0; i < count; i++) {
            if (storageList[i].getId() == id) {
                storage = storageList[i];
            }
        }
        return storage;
    }
    
    public int findIndex(Storage storage) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (storageList[i].equals(storage)) {
                index = i;
            }
        }
        return index;
    }
    
    public boolean isFull() {
        return (count >= storageList.length);
    }
    
    public int getOwnedStorage() {
        return count;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < storageList.length; i++) {
            str += "\n" + storageList[i];
        }
        return "StorageList{" + "storageList=" + str + '}';
    }
}
