package StorageService;

import Base.Person;
import java.time.LocalDateTime;

/**
 * This class represents a storage in self-storage service.
 * @author Tharadon Saenmart 
 * @version 1.0
 * @since Nov 10, 2020
 */
public class Storage {
    private static int storageId;
    private int id;
    private double lengthM;
    private double widthM;
    private Person owner;
    private LocalDateTime timeCreated;

    /***
     * Create a new Storage object with the given 
     * owner, storage's length(m), storage's width(m)
     * PS.The owner need to be Person object.
     * @param owner
     * @param lengthM
     * @param widthM
     */
    public Storage(Person owner, double lengthM, double widthM) {
        this.id = storageId++;
        this.lengthM = lengthM;
        this.widthM = widthM;
        this.owner = owner;
        this.timeCreated = LocalDateTime.now();
    }
    /***
     * Get an ID of storage
     * @return ID of storage
     */
    public int getId() {
        return id;
    }
    /***
     * Get storage owner
     * @return Storage owner
     */
    public Person getOwner() {
        return owner;
    }
    /***
     * Get an area of storage
     * @return An area of storage
     */
    public double getArea() {
        return (widthM * lengthM);
    }
    /***
     * Get a storage type
     * @return A type of storage
     */
    public StorageType getType() {
        double area = getArea();
        StorageType type = null;
        if (area > 10) {
            type = StorageType.LARGE;
        } else if (area >= 5) {
            type = StorageType.MEDIUM;
        } else {
            type = StorageType.SMALL;
        }
        return type;
    }
    /**
     * 
     * @return the time when this Storage object is created
     */
    public LocalDateTime getTimeCreated() {
        return timeCreated;
    }
    
    public static StorageType calculateType(double area) {
        StorageType type = null;
        if (area > 10) {
            type = StorageType.LARGE;
        } else if (area >= 5) {
            type = StorageType.MEDIUM;
        } else {
            type = StorageType.SMALL;
        }
        return type;
    }
    
    /***
     * 
     * @return All Storage object's data as string
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Storage{id=").append(id);
        sb.append(", lengthM=").append(lengthM);
        sb.append(", widthM=").append(widthM);
        sb.append(", area(m2)=").append(getArea());
        sb.append(", type=").append(getType());
        sb.append(", owner=").append(owner);
        sb.append('}');
        return sb.toString();
    }   
}
