package toolee.tools.Controllers;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;

import org.springframework.test.context.TestPropertySource;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.containsString;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application.properties")
public class HomeControllerTest {
    @Autowired
    HomeController homeController;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;
    @Before
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    public static RequestPostProcessor testUser(){
        return user("wosunkwo").password("wosunkwo").roles("ADMIN");
    }

    @WithMockUser
    @Test
    public void testLogin() throws Exception{
        mockMvc.perform(get("/login").with(testUser())).andExpect(content().string(containsString("Discover")));


    }
    @WithMockUser
    @Test
    public void testhome() throws Exception{
        mockMvc.perform(get("/home").with(testUser())).andExpect(content().string(containsString("Hello, wosunkwo")));

    }

}