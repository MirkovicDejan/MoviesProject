package com.moviesproject.moviesproject.controller;


import com.moviesproject.moviesproject.JsonUtil.JsonUtil;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Test
    void saveUser3() throws Exception {

        User user = new User();
        User user2 = new User();
        user.setUserName("UsernameExample");
        user.setFirstName("FirstnameExample");


        user.setLastName("LastExample");
        user.setPassword("PassExamp");
        user.setPhoneNumber("PhoneExamp");
        user.setAdress("AdressExampp");
        user.setEmail("EmailExam");

        assertThat(user).isNotNull();
        assertThat(user).isNotNull();
        assertThat(user).isNotNull();
        assertThat(user).isExactlyInstanceOf(User.class);

        assertThat(user).isExactlyInstanceOf(User.class);
        assertThat(user).isExactlyInstanceOf(User.class);
        assertThat(user).isExactlyInstanceOf(User.class);
    }

    void saveUser() throws Exception {
        User user3 = new User();
        user3.setUserName("UsernameExample33");
        user3.setFirstName("FirstnameExample444");
        user3.setLastName("LastExample");
        user3.setPassword("PassExamp");
        user3.setPhoneNumber("PhoneExamp");
        user3.setAdress("AdressExampp");
        user3.setEmail("EmailExam@d");
        assertThat(user3).isNotNull();
        assertThat(user3).isExactlyInstanceOf(User.class);

        given(userService.saveUser(DTOUser.getInstanceDtoUser().entityUserToDTO(user))).willReturn(user);

        mockMvc.perform(post("/save-user").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(user3)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.userName", is(user3.getUserName())));


        // This is for source conflict
    }

    @Test
    void all() {
		System.out.println("test");
    }

}