package Base;

public class Person {
    private String firstname;
    private String lastname;
    
    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
    
    public String getFirstname() {
        return firstname;
    }
    
    public String getLastname() {
        return lastname;
    }
    /***
     * TODO: set person firstname and return chaining method
     * @return this 
     */
    public Person setFirstname() {
        return null;
    }
    /***
     * TODO: set person lastname and return chaining method
     * @return this 
     */
    public Person setLastname() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{firstname=").append(firstname);
        sb.append(", lastname=").append(lastname);
        sb.append('}');
        return sb.toString();
    }
}
