package com.moviesproject.moviesproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviesproject.moviesproject.service.RoleService;
import com.moviesproject.moviesproject.service.UserRoleService;
import com.moviesproject.moviesproject.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;
@SpringBootTest
@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
class UserRoleControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRoleService userRoleService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Test
    void createUserRole() throws Exception {
        Integer userId = 5;
        Integer roleId = 3;
        mockMvc.perform(post("/create-user-role?roleId="+roleId+"&userId="+userId).contentType(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.role.name",is("ADMIN")))
                .andExpect(jsonPath("$.user.userName",is("U4")));

    }

    @Test
    void findAll() throws Exception {
        mockMvc.perform(get("/find-all-user-role").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(4)))
                .andExpect(jsonPath("$[0].user.userName",is("U")))
                .andExpect(jsonPath("$[0].role.name",is("TEST")));

    }

    @Test
    void findOne() throws Exception {
        mockMvc.perform(get("/find-one-user-role?id="+2).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.user.userName",is("U1")))
                .andExpect(jsonPath("$.role.name",is("USER")));
    }

    @Test
    void deleteTest() throws Exception {
        mockMvc.perform(delete("/delete-user-role?id="+4).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    void update() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(put("/update-user-role?userRoleId="+3+"&"+"roleId="+2+"&"+"userId="+4).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.user.userName",is("U3")));
    }

}