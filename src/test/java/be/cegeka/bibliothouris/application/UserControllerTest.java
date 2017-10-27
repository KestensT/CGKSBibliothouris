package be.cegeka.bibliothouris.application;

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
        User user1 = new User(1l, "Seppe");
        User user2 = new User(2l, "Sanne");

        when(userService.getAllUsers()).thenReturn(Arrays.asList(user1, user2));

        assertThat(userController.getUsers()).containsOnly(user1, user2);
    }
}