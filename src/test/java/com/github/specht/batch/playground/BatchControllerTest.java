package com.github.specht.batch.playground;

import com.github.specht.batch.playground.batch.JobFactory;
import com.github.specht.batch.playground.controller.BatchController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class BatchControllerTest {

    @Mock
    private JobFactory jobFactory;

    @InjectMocks
    private BatchController batchController;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(batchController).build();
    }

    @Test
    public void whenCallStartJobThenMustReturnCreated() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/batch")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isCreated());

    }

}
