package com.hemmersbach.springbootempty.hello;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class HelloControllerTest{

    @Autowired private MockMvc mvc;

    @Test
    public void index() throws Exception {
        String strRestResponse = "Angel test. I am here first @RequestMapping";
        mvc.perform(MockMvcRequestBuilders.get("/").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(strRestResponse)));
    }

    @Test
    public void indexA_callRestpointIndenxA_returnStringDefineInThatRestPoint() throws Exception {
        String strRestResponse = "I am in testA";
        mvc.perform(MockMvcRequestBuilders.get("/testA").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(strRestResponse)));
    }

    @Test
    public void indexB_callRestpointIndenxB_returnStringDefineInThatRestPoint() throws Exception {
        String strRestResponse = "I am in testB";
        mvc.perform(MockMvcRequestBuilders.get("/testB").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo(strRestResponse)));
    }
}
