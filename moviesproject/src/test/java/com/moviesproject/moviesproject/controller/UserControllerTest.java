package com.moviesproject.moviesproject.controller;


import com.moviesproject.moviesproject.JsonUtil.JsonUtil;
import com.moviesproject.moviesproject.dto.DTOUser;
import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.web.bind.annotation.RestController;
import javax.persistence.*;
import java.util.*;

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

        given(userService.saveUser(DTOUser.getInstanceDtoUser().entityUserToDTO(user))).willReturn(user);

        mockMvc.perform(post("/save-user").contentType(MediaType.APPLICATION_JSON)
                .content(JsonUtil.toJson(user)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect((ResultMatcher) jsonPath("$.userName", is(user.getUserName())));
    }

    @Test
    void all() {
		System.out.println("test");
    }

    @Test
    void one() {
		System.out.println("test");
    }

    @Test
    void delete() {
		System.out.println("test");
    }

    @Test
    void update() {
		System.out.println("test");
    }
}