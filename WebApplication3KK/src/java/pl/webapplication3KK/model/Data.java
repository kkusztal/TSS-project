package pl.webapplication3KK.model;

/**
 *
 * @author kasia
 */
public class Data {
    private int id;
    private String lastName;
    private String firstName;
    private String city;

    public Data(int id, String lastName, String firstName, String city) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
