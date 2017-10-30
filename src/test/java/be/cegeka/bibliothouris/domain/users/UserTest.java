package be.cegeka.bibliothouris.domain.users;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class UserTest {

    private RegisteredUser user;

    @Before
    public void setup() {
        user = new RegisteredUser(10, "Seppe");
    }

    @Test
    public void equals_SameObject_IsTrue() throws Exception {
        assertThat(user).isEqualTo(user);
    }

    @Test
    public void equals_ObjectWithSameIdAndName_IsTrue() throws Exception {
        assertThat(user).isEqualTo(new RegisteredUser(10, "Seppe"));
    }

    @Test
    public void equals_NullObject_IsFalse() throws Exception {
        assertThat(user).isNotEqualTo(null);
    }

    @Test
    public void equals_OtherClass_IsFalse() throws Exception {
        assertThat(user).isNotEqualTo(new Object());
    }

    @Test
    public void equals_ObjectWithOtherId_IsFalse() throws Exception {
        assertThat(user).isNotEqualTo(new RegisteredUser(9, "Seppe"));
    }

    @Test
    public void equals_ObjectWithOtherName_IsFalse() throws Exception {
        assertThat(user).isNotEqualTo(new RegisteredUser(10, "Other"));
    }

    @Test
    public void equals_ObjectWithNullName_IsFalse() throws Exception {
        assertThat(user).isNotEqualTo(new RegisteredUser(10, null));
    }

    @Test
    public void equals_ObjectWithBothNullName_IsTrue() throws Exception {
        assertThat(new RegisteredUser(10, null)).isEqualTo(new RegisteredUser(10, null));
    }

    @Test
    public void equals_ObjectWithNoNullName_IsFalse() throws Exception {
        assertThat(new RegisteredUser(10, null)).isNotEqualTo(new RegisteredUser(10, "Seppe"));
    }
//    @Test
//    public void checkIfRegisteredUserHasFunctionRegisteredUser() throws Exception {
//        User tbone = new RegisteredUser(1, "tbone");
//
//        assertThat(tbone.checkFunctie()).isEqualTo("registered user");
//    }
//
//    @Test
//    public void checkIfMemberHasFunctionMember() throws Exception {
//        User tbone2 = new Member(2, "tbone", "member", "1234", "kestie", "louvain");
//        assertThat(tbone2.checkFunctie()).isEqualTo("member");
//    }
//
//
//    @Test
//    public void checkIfFunctionOfRegisteredIsDifferentFromMember() throws Exception {
//        User tbone = new RegisteredUser(1, "tbone");
//        User tbone2 = new Member(2, "tbone", "member", "1234", "kestie", "louvain");
//        assertThat(tbone.checkFunctie()).isNotEqualTo(tbone2.checkFunctie());
//    }
}