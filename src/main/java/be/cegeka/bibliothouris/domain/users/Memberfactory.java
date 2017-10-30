package be.cegeka.bibliothouris.domain.users;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class Memberfactory {
    @Inject
    private UserRepository userRepository;

    public Member createNewMember(long id,
                                  String screenName,
                                  String inss,
                                  String lastName,
                                  String firstName,
                                  String streetName,
                                  String streetNumber,
                                  String postalCode,
                                  String cityName) {

        if (inss != null || lastName != null || cityName != null) {
            if (checkINSSTrueCreatesNewMember(inss)) {
                return new Member(id,screenName,inss,lastName,firstName,streetName,streetNumber,postalCode,cityName);
            }
        }
        throw new IllegalArgumentException("it's a fail whale");
    }


    public boolean checkINSSTrueCreatesNewMember(String inss) {

        for (Member member : userRepository.getAllMembers()) {
            if (member.getInss().equals(inss)) {
                return false;
            } }
        return true;

    }
}