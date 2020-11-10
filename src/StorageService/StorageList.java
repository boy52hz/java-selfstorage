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
        
    }
    
    /***
     * TODO: use id loop all valid storage and return Storage Object
     * @param id
     * @return Storage 
     */
    public Storage find(int id) {
        return null;
    }
    
    /***
     * TODO: use Storage Object loop all valid storage and return index of Storage in array
     * @param storage
     * @return index
     */
    public int findIndex(Storage storage) {
        return 0;
    }
    
    /***
     * TODO: check if our storage is full
     * @return
     */
    public boolean isFull() {
        return true;
    }
}
