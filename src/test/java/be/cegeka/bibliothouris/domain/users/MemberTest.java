package be.cegeka.bibliothouris.domain.users;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {
    @Test
    public void createUserTBoneWillReturnCreatedUserTbone() throws Exception {
        Member member = new Member(1,"kestens", "thibault");

        String expected = "[1] kestens thibault";
        Assertions.assertThat(member.getDetails()).isEqualTo(expected);
    }

//    @Test
//    public void createMember_shouldReturnAdminIsFalse() throws Exception {
//        Member member = new Member(1, "sparrow", "Erwin");
//
//        boolean expected = false;
//    }
}