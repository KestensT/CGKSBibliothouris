package be.cegeka.bibliothouris.domain.users;

public class RegisteredUser extends User{
    private String functie;

    public RegisteredUser(long id, String screenName) {
        super(id, screenName);
    }


    @Override
    public String checkFunctie() {
        return this.functie;
    }


}
