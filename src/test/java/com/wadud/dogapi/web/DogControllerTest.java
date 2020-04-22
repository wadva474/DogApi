package com.wadud.dogapi.web;

import com.wadud.dogapi.service.DogServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(DogController.class)
class DogControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    DogServiceImpl dogService;

    @Test
    void getAllDogs() throws Exception {
        mockMvc.perform(get("/dogs/")
                .with(user("Admin").password("password").roles("USER")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogs();
    }

    @Test
    void getDogBreeds() throws Exception {
        mockMvc.perform(get("/dogs/breed/")
                .with(user("Admin").password("password").roles("USER")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogBreed();
    }

    @Test
    void getBreedByID() throws Exception {
        mockMvc.perform(get("/1/breed/")
                .with(user("Admin").password("password").roles("USER")))
                .andExpect(status().isOk());

        verify(dogService, times(1)).retrieveDogBreedById((long) 1);
    }

    @Test
    void getDogNames() throws Exception {
        mockMvc.perform(get("/dogs/name/")
                .with(user("Admin").password("password").roles("USER")))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[]"));

        verify(dogService, times(1)).retrieveDogNames();
    }
}