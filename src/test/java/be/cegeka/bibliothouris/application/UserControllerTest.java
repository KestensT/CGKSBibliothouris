package be.cegeka.bibliothouris.application;

import be.cegeka.bibliothouris.domain.users.RegisteredUser;
import be.cegeka.bibliothouris.domain.users.User;
import be.cegeka.bibliothouris.domain.users.UserRepository;
import be.cegeka.bibliothouris.domain.users.UserService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void addUser_ShouldCallUserService() throws Exception {
        userController.addUser("Tbow");

        verify(userService).addUser("Tbow");
    }

    @Test
    public void getUsers() throws Exception {
        User user1 = new RegisteredUser(1l, "Seppe");
        User user2 = new RegisteredUser(2l, "Sanne");

        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        assertThat(userController.getUsers()).containsOnly(user1, user2);
    }

    @Test
    public void addingMultipleUsersWithALongID_shouldStillWork() throws Exception {
        User user1 = new User(1l, "Mattia");
        User user2 = new User(5l, "Len");
        User user3 = new User(8l, "Erwin");
        User user4 = new User(4845l, "Ralph");
        User user5 = new User(100000000l, "Seppe");
        User user6 = new User(898989565555656l, "Kiki");

        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2, user3, user4, user5, user6));

        assertThat(userController.getUsers()).containsOnly(user1, user2, user3, user4, user5, user6);
    }


}