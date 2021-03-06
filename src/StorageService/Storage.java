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
    private double area;
    private StorageType type;
    private Person owner;
    private LocalDateTime timeRented;
    private LocalDateTime timeUnrented;

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
        this.area = calculateArea(lengthM, widthM);
        this.type = calculateType(area);
        this.owner = owner;
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
        return area;
    }
    
    /***
     * Get a storage type
     * @return A type of storage
     */
    public StorageType getType() {
        return type;
    }
    
    /**
     * 
     * @return the time when this Storage rented
     */
    public LocalDateTime getTimeRented() {
        return timeRented;
    }
    
    /***
     * 
     * @return the time when this Storage unrented 
     */
    public LocalDateTime getTimeUnrented() {
        return timeUnrented;
    }
    
    /***
     * Stamp rented time
     */
    public void stampTimeRented() {
        timeRented = LocalDateTime.now();
    }
    
    /***
     * Stamp unrented time
     */
    public void stampTimeUnrented() {
        timeUnrented = LocalDateTime.now();
    }
    
    /***
     * To set storage's rent time stamp
     * @param timeRented 
     */
    public void stampTimeRented(LocalDateTime timeRented) {
        this.timeRented = timeRented;
    }
    
    /***
     * To set storage's unrent time stamp
     * @param timeUnrented 
     */
    public void stampTimeUnrented(LocalDateTime timeUnrented) {
        this.timeUnrented = timeUnrented;
    }
    
    /**
     * Calculates and returns the StorageType of the given area
     * @param area the area of the storage
     * @return the StorageType of the given area
     */
    private static StorageType calculateType(double area) {
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
     * Calculates and returns the area of the given width and length
     * without concerning about unit
     * @param length 
     * @param width
     * @return the area of the given length and width
     */
    private static double calculateArea(double length, double width) {
        return length * width;
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
        sb.append(", area(m2)=").append(area);
        sb.append(", type=").append(type);
        sb.append(", owner=").append(owner);
        sb.append(", timeRented=").append(timeRented);
        sb.append('}');
        return sb.toString();
    }   
}
