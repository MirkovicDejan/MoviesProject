package com.moviesproject.moviesproject;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.repository.UserRepository;
import com.moviesproject.moviesproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@AutoConfigureTestDatabase
@ActiveProfiles("qa")
@TestPropertySource(locations = "classpath:application-qa.properties")
public class JUnitTestForUser {
    
    private final UserService userService;
    private final UserRepository userRepository;
    @Autowired
    public JUnitTestForUser(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Test
    public void createUser() {
        User testUser = new User("Dejo", "Dejan", "Mirkovic", "000", "dejo@dejo", "n.n.b.b", "sifra");
        userService.saveUser(testUser);
    }

    @Test
    public void findUserByUserName(){
        User u = userRepository.findByUserName("K 1");
        System.out.println(u.getUserName());
    }

    @Test
    public void delete(){
        userService.deleteUser(5);
    }

}
