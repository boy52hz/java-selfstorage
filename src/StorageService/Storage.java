package StorageService;

import Base.Person;

public class Storage {
    private static int storageId;
    private int id;
    private double lengthM;
    private double widthM;
    private Person owner;

    public Storage(Person owner, double lengthM, double widthM) {
        this.id = storageId++;
        this.lengthM = lengthM;
        this.widthM = widthM;
        this.owner = owner;
    }
    
    public int getId() {
        return id;
    }
    
    public Person getOwner() {
        return owner;
    }
    
    public double getArea() {
        return (widthM * lengthM);
    }
    
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
