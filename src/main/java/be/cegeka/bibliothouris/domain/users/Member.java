package be.cegeka.bibliothouris.domain.users;

public class Member {

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




    //    @Override
//    public void userDetails(long id, String name) {
//


}

