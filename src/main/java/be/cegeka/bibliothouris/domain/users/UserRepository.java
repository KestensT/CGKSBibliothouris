package be.cegeka.bibliothouris.domain.users;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class UserRepository {

    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public List<Member> getAllMembers() {
        List<Member> memberlist = new ArrayList<>();
        for (User u : getAllUsers()) {
            if (u.getClass() == Member.class) {
                memberlist.add((Member) u);
            }
        }
        return memberlist;
    }

    public void addUser(User user) {
        users.add(user);
    }


    public void addMember(Member member) {
        users.add(member);
    }

}
