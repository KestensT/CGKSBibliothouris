package be.cegeka.bibliothouris.domain.users;

public interface RegisteredUser {

    void userDetails(long id, String name);
    boolean userIsLibrarian(boolean isLibrarian);
    boolean userIsAdmin(boolean isAdmin);




}
