package be.cegeka.bibliothouris.domain.users;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.junit.Assert.*;

public class MemberTest {
    @Test
    public void createUserTBoneWillReturnCreatedUserFirstNameTbone() throws Exception {
        Member member = new Member("789-45551","Kestens", "Thibault", "Interleuvenlaan",
        "16A", "3001","Leuven");

        String expected = "Thibault";
        Assertions.assertThat(member.getFirstName()).isEqualTo(expected);
    }

    @Test
    public void createUserTBoneWillReturnCreatedUserTbone() throws Exception {
        Member member = new Member("789-45551","Kestens", "Thibault", "Interleuvenlaan",
        "16A", "3001","Leuven");

        String expected = "[789-45551] Kestens Thibault, Interleuvenlaan 16A, 3001 Leuven";
        Assertions.assertThat(member.getDetails()).isEqualTo(expected);
    }


}