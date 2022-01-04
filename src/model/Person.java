package model;

public class Person {
    private String firstName;
    private String lastName;

    //Constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //Getter for firstName
    public String getFirstName() {
        return firstName;
    }

    //Getter for lastName
    public String getLastName() {
        return lastName;
    }

    //Setter for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //Setter for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
