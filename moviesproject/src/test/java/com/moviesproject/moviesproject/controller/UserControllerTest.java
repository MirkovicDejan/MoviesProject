package com.moviesproject.moviesproject.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviesproject.moviesproject.JsonUtil.JsonUtil;

import com.moviesproject.moviesproject.model.User;
import com.moviesproject.moviesproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.is;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @WithMockUser(username="U3",password = "sifra3", roles = "ADMIN")
    @Test
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

        mockMvc.perform(post("/save-user").contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtil.toJson(user3)))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.userName", is(user3.getUserName())))
                .andExpect(jsonPath("$.firstName",is(user3.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(user3.getLastName())))
                .andExpect(jsonPath("$.adress",is(user3.getAdress())))
                .andExpect(jsonPath("$.phoneNumber", is(user3.getPhoneNumber())))
                .andExpect(jsonPath("$.email", is(user3.getEmail())))
                .andExpect(jsonPath("$.password", is(user3.getPassword())));
    }

    @WithMockUser(username="U3",password = "sifra3", roles = "ADMIN")
    @Test
    void all() throws Exception{

        mockMvc.perform(get("/all-users").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(5)))
                .andExpect(jsonPath("$[0].userName",is(getUser().getUserName())));


    }

    @WithMockUser(username="U3",password = "sifra3", roles = "ADMIN")
    @Test
    void findOne() throws Exception{

        mockMvc.perform(get("/find-one?id="+getUser().getUserId()).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("userName",is(getUser().getUserName())))
                .andExpect(jsonPath("firstName",is(getUser().getFirstName())))
                .andExpect(jsonPath("lastName",is(getUser().getLastName())))
                .andExpect(jsonPath("password",is(getUser().getPassword())))
                .andExpect(jsonPath("phoneNumber",is(getUser().getPhoneNumber())))
                .andExpect(jsonPath("adress",is(getUser().getAdress())))
                .andExpect(jsonPath("email",is(getUser().getEmail())));

    }

    @WithMockUser(username="U3",password = "sifra3", roles = "ADMIN")
    @Test
    void updateTest()throws Exception{
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(put("/update-user?id="+getUpdateuser().getUserId()).content(mapper.writeValueAsString(getUpdateuser())).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("userName",is(getUpdateuser().getUserName())));

    }

    @WithMockUser(username="U3",password = "sifra3", roles = "ADMIN")
    @Test
    void deleteTets()throws Exception{
        User u = getUser();
        mockMvc.perform(delete("/delete-mapping?id="+5).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private User getUser() {
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("U");
        user1.setFirstName("First");
        user1.setLastName("Last");
        user1.setPassword("sifra");
        user1.setPhoneNumber("tel broj");
        user1.setAdress("ulica");
        user1.setEmail("user@");
        return user1;
    }

    private User getUpdateuser(){
        User user2 = new User();
        user2.setUserId(1);
        user2.setUserName("UPDATE");
        user2.setFirstName("UPDATE");
        user2.setLastName("UPDATE");
        user2.setPassword("UPDATE");
        user2.setPhoneNumber("UPDATE");
        user2.setAdress("UPDATE");
        user2.setEmail("UPDATE");
        return user2;
    }
}