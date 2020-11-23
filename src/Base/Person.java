package Base;
/***
* This is class about person.
* @author Chinnawat Kaewnongsang
* @version 1.0
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
    * Get first name of person
    * @return person's first name
    */
    public String getFirstname() {
        return firstname;
    }
    /***
    * Get last name of person
    * @return person's last name
    */
    public String getLastname() {
        return lastname;
    }
    /***
    * Get full name of person
    * Full name mean first name + last name
    * @return person's full name
    */
    public String getFullname() {
        return firstname + " " + lastname;
    }
    /***
    * Set first name of person
    * @return Person
    */
    public Person setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }
    /***
    * Set last name of person
    * @return Person
    */
    public Person setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }
    /***
    * @return Person object data as string format
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
