package be.cegeka.bibliothouris.domain.users;

public abstract class User {

    private final long id;
    private final String screenName;
    private String functie;

    public User(long id, String screenName) {
        this.id = id;
        this.screenName = screenName;
    }

    public User(long id, String name, String functie) {
        this.id = id;
        this.screenName = name;
        this.functie = functie;
    }

    public long getId() {
        return id;
    }

    public String getScreenName() {
        return screenName;
    }

    public String getFunctie() {
        return functie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        return screenName != null ? screenName.equals(user.screenName) : user.screenName == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (screenName != null ? screenName.hashCode() : 0);
        return result;
    }

    public String checkFunctie() {
        return this.functie;
    }
}
