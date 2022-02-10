package com.moviesproject.moviesproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.moviesproject.moviesproject.JsonUtil.JsonUtil;
import com.moviesproject.moviesproject.model.Role;
import com.moviesproject.moviesproject.service.RoleService;
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
class RoleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RoleService roleService;

    @Test
    void create() throws Exception {
        mockMvc.perform(post("/save-role")
                .contentType(MediaType.APPLICATION_JSON).content(JsonUtil.toJson(getRole())))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(getRole().getName())));
    }

    @Test
    void all() throws Exception {

        mockMvc.perform(get("/get-all-role").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$",hasSize(5)))
                .andExpect(jsonPath("$[0].name",is("TEST")));
    }

    @Test
    void update() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mockMvc.perform(put("/update-role?id="+getRoleUpdate().getRoleId()).content(mapper.writeValueAsString(getRoleUpdate())).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("name", is(getRoleUpdate().getName())));

    }

   @Test
    void one() throws Exception {
        mockMvc.perform(get("/find-one-role"+"?id="+1).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name",is("TEST")));

    }

    @Test
    void deleteTest() throws Exception {
        mockMvc.perform(delete("/delete-role?id="+5).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    private Role getRole(){
        Role role = new Role();
        role.setName("SUPER_ROLA");
        return role;
    }

    private Role getRoleUpdate(){
       Role role = new Role();
       role.setRoleId(4);
       role.setName("UPDATE");
       return role;
    }
}