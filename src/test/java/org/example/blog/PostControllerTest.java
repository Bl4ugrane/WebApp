package org.example.blog;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers.authenticated;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;




@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@WithUserDetails("admin")
public class PostControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void postListTest() throws Exception {
        this.mockMvc.perform(get("/posts"))
                .andDo(print())
                        .andExpect(authenticated())
                .andExpect(xpath("//div[@class='col-md-8']/div").nodeCount(3));

    }

    @Test
    public void postSearchTest() throws Exception {
        this.mockMvc.perform(get("/posts").param("title","Getting Started"))
                .andDo(print())
                        .andExpect(authenticated())
                .andExpect(xpath("//div[@class='col-md-8']/div").nodeCount(1));

    }

    @Test
    public void pagePostViewTest() throws Exception {
        this.mockMvc.perform(get("/posts/13"))
                .andDo(print())
                      .andExpect(authenticated())
                .andExpect(content().string(containsString("Getting Started")))
                      .andExpect(content().string(containsString("Редактировать")));

    }

    @Test
    public void pagePostEditTest() throws Exception {
        this.mockMvc.perform(get("/posts/edit/13"))
                .andDo(print())
                        .andExpect(authenticated())
                .andExpect(content().string(containsString("Getting Started")))
                        .andExpect(content().string(containsString("Изменить")))
                .andExpect(content().string(containsString("Удалить")));

    }
}
