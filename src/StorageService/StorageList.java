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
        for (int i = index; i < count; i++) {
            storageList[i] = storageList[i+1];
        }
        count--;
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
    /***
     * TODO: get avaliable storages
     * @return avaliable storages
     */
    public int getAvaliable() {
        return 0;
    }
    /***
     * TODO: get owned storages
     * @return get owned storage
     */
    public int getOwnedStorage() {
        return 0;
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
