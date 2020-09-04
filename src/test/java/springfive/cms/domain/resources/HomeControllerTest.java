package springfive.cms.domain.resources;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import springfive.cms.domain.utilities.NewsAppException;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(HomeController.class)
class HomeControllerTest {


    @Autowired
    private MockMvc mvc;

    @Test
    void hello() throws Exception{
        RequestBuilder request = MockMvcRequestBuilders.get("/hello");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Hello, World", result.getResponse().getContentAsString());

    }

    @Test
    void helloParam() throws Exception{

        RequestBuilder request = MockMvcRequestBuilders.get("/hello?name=Shraddha");
        MvcResult result = mvc.perform(request).andReturn();
        String expected = "Hello, Shraddha";
        assertEquals(expected, result.getResponse().getContentAsString());
    }


    @Test
    void tddParam() throws Exception{

        RequestBuilder request = MockMvcRequestBuilders.get("/trash");

        MvcResult result = mvc.perform(request).andReturn();

        String expected = "This is a trash api";
        assertEquals(expected, result.getResponse().getContentAsString());
    }



    void assthrow() throws Exception{

        RequestBuilder request = MockMvcRequestBuilders.get("/api/category/33");
        MvcResult result = mvc.perform(request).andReturn();
        assertThrows

                        (Exception.class, () -> mvc.perform(request).andReturn());
    }


}