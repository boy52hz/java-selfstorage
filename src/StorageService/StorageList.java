package StorageService;

public class StorageList {
    private static int count;
    private Storage[] storageList;
    
    public StorageList(int size) {
        this.storageList = new Storage[size];
    }
    /***
     * TODO: Add storage object
     * @param storage 
     */
    public void add(Storage storage) {
        storageList[count++] = storage;
    }
    
    /***
     * TODO: use id loop all valid storage and return Storage Object
     * @param id
     * @return Storage 
     */
    public Storage find(int id) {
        for (int i = 0; i < count; i++) {
            if (storageList[i].getId() == id) return storageList[i];
        }
        return null;
    }
    
    /***
     * TODO: use Storage Object loop all valid storage and return index of Storage in array
     * @param storage
     * @return index
     */
    public int findIndex(Storage storage) {
        for (int i = 0; i < count; i++) {
            if (storageList[i].equals(storage)) return i;
        }
        return -1;
    }
    
    /***
     * TODO: check if our storage is full
     * @return
     */
    public boolean isFull() {
        if (count < storageList.length) return false;
        return true;
    }
}
