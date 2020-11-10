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
     * @param firstname
     * @return this 
     */
    public Person setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    /***
     * TODO: set person lastname and return chaining method
     * @param lastname
     * @return this 
     */
    public Person setLastname(String lastname) {
        this.lastname = lastname;
        return this;
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
