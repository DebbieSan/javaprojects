public class FullName {

    /**
     * instance variable for names and titles - selected titles will be Mr., Ms.,
     * and Miss
     */

    private String firstName;
    private String middleName;
    private String lastName;

    private String title;

    /** Constructor for the class */

    public FullName(String firstName, String middleName, String lastName, String title) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.title = title;

    }

    /** Getter and Setter for the Names and titles */

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName() {
        this.firstName = firstName;

    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName() {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName() {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTittle() {
        this.title = title;
    }

    @Override
    public String toString() {
        return firstName + " " + middleName + " " + lastName + "\n";

    }

}