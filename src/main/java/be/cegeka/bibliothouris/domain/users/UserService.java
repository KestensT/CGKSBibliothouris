package be.cegeka.bibliothouris.domain.users;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Named
public class UserService {

    @Inject
    private UserRepository userRepository;
    @Inject
    private Memberfactory memberfactory;

    private final AtomicLong counter = new AtomicLong();

    public void addUser(String name) {
        userRepository.addUser(new RegisteredUser(counter.incrementAndGet(), name));
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public void addMember(String screenName, String inss, String lastName, String firstName, String streetName, String streetNumber, String postalCode, String cityName) {
        userRepository.addMember(memberfactory.createNewMember((counter.incrementAndGet()), screenName, inss, lastName, firstName, streetName, streetNumber, postalCode, cityName));



    }
}
