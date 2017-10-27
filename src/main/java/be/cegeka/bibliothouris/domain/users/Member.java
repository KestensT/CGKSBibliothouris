package be.cegeka.bibliothouris.domain.users;

public class Member implements  RegisteredUser{

    private long id;
    private String lastName;
    private String firstName;

    public Member(long id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public long getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public void userDetails(long id, String name) {
        System.out.println(id + "," + name);
    }

    @Override
    public boolean userIsLibrarian(boolean isLibrarian) {
        return false;
    }

    @Override
    public boolean userIsAdmin(boolean isAdmin) {
        return false;
    }


    public String getDetails() {
        return "[" + id + "] " + lastName + " " + firstName ;
    }
}

