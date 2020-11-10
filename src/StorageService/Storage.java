package StorageService;

import Base.Person;

public class Storage {
    private static int storageId;
    private int id;
    private Person owner;
    private StorageType type;

    public Storage(Person owner, StorageType type) {
        this.id = storageId++;
        this.owner = owner;
        this.type = type;
    }
    
    public int getId() {
        return id;
    }
    
    public Person getOwner() {
        return owner;
    }
    
    public StorageType getType() {
        return type;
    }
}
