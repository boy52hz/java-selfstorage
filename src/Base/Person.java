package Base;
/***
* This is class about person.
* @author Chinnawat Kaewnongsang
* version 1.0
*/
public class Person {
    private static int nextId;
    private int id;
    private String firstname;
    private String lastname;
    /***
    * Create person using firstname and lastname
    * @param firstname
    * @param lastname
    */
    public Person(String firstname, String lastname) {
        this.id = nextId++;
        this.firstname = firstname.trim();
        this.lastname = lastname.trim();
    }
    /***
    * Get ID of person
    * @return ID of person
    */
    public int getId() {
        return id;
    }
    /***
    * Get firstname of person
    * @return firstname
    */
    public String getFirstname() {
        return firstname;
    }
    /***
    * Get lastname of person
    * @return lastname
    */
    public String getLastname() {
        return lastname;
    }
    /***
    * Get fullname of person
    * Fullname mean firstname + lastname
    * @return firstname + lastname
    */
    public String getFullname() {
        return firstname + " " + lastname;
    }
    /***
    * Set firstname of person
    * @return firstname
    */
    public Person setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    /***
    * Set lastname of person
    * @return lastname
    */
    public Person setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
    /***
    * @return Person firstname and lastname
    */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Person{firstname=").append(firstname);
        sb.append(", lastname=").append(lastname);
        sb.append('}');
        return sb.toString();
    }
}
