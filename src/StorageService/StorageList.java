package StorageService;

/**
 * This class is used to represent a list of storages in StorageService
 * 
 * @author Tawan Muadmuenwai
 * @version 1.0
 * @since 1.0
 */
public class StorageList {
    private static int count;
    private Storage[] storageList;
    
    /**
     * Creates a new StorageList with the given initial size
     * @param size Initial size of the list
     */
    public StorageList(int size) {
        this.storageList = new Storage[size];
    }

    /**
     * Adds the given Storage object to the list.
     * @param storage a Storage object to be added
     * @return true if the list is not full, false otherwise
     */
    public boolean add(Storage storage) {
        storageList[count++] = storage;
        return true;
    }
    
    /**
     * Removes the Storage at the given index by rearranging
     * the list to replace the given index
     * and set the last item to be null
     * @param index Index of the Storage to be removed
     * @return true if the Storage at the given index is removed, false otherwise
     */
    public boolean removeAt(int index) {
        for (int i = index; i < count; i++) {
            int nextIndex = (i + 1);
            if (nextIndex < storageList.length) {
                storageList[i] = storageList[nextIndex]; 
            } else {
                storageList[i] = null;
            }
        }
        count--;
        return true;
    }
    
    /**
     * Finds and return Storage object with the given id
     * @param id The id of the Storage object
     * @return Storage object with the given id
     */
    public Storage find(int id) {
        Storage storage = null;
        for (int i = 0; i < count; i++) {
            if (storageList[i].getId() == id) {
                storage = storageList[i];
            }
        }
        return storage;
    }
    
    /**
     * Finds and returns index of the given Storage object
     * @param storage a Storage object
     * @return the index of the given Storage object in the list
     */
    public int findIndex(Storage storage) {
        int index = -1;
        for (int i = 0; i < count; i++) {
            if (storageList[i].equals(storage)) {
                index = i;
            }
        }
        return index;
    }
    
    /**
     * Checks if the list is full or not
     * @return true if the list is full, false otherwise.
     */
    public boolean isFull() {
        return (count >= storageList.length);
    }

    /**
     * Checks the number of available storages in the list
     * @return the number of available storages in the list
     */
    public int getAvaliable() {
        return (storageList.length - count);
    }

    /**
     * Checks the number of owned storages in the list
     * @return the number of owned storages in the list
     */
    public int getOwnedStorage() {
        return count;
    }

    /**
     * 
     * @return a string of all Storage objects in the list with their data,
     * each object separated by a newline
     */
    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i < storageList.length; i++) {
            str += "\n" + storageList[i];
        }
        return "StorageList{" + "storageList=" + str + '}';
    }
}
