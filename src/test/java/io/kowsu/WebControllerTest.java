package io.kowsu;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.kowsu.controller.WebController;
import io.kowsu.model.Request;
import io.kowsu.service.IWebService;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.net.URI;
import java.util.UUID;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.anyString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(WebController.class)
public class WebControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ApplicationContext context;

    @MockBean
    private IWebService webService;

    @Test
    @SneakyThrows
    public void greetTest() {
        mockMvc.perform(MockMvcRequestBuilders.get("/greet")).andExpect(status().isOk())
                .andExpect(content().string(containsString("Hello")));
    }

    @Test
    @SneakyThrows
    public void postRequestTest() {
        Request request = new Request();
        request.setHost("localhost");
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .post(new URI("/postRequest"))
                                .content(mapper.writeValueAsString(request))
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().string(containsString("localhost")));
    }


    @Test
    @SneakyThrows
    public void putRequestTest() {
        Request request = new Request();
        request.setHost("localhost");
        ObjectMapper mapper = new ObjectMapper();

        mockMvc.perform(
                        MockMvcRequestBuilders
                                .put(new URI("/putRequest"))
                                .content(mapper.writeValueAsBytes(request))
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().string(containsString("localhost")));
    }


    @Test
    @SneakyThrows
    public void deleteRequestTest() {
        String requestId = UUID.randomUUID().toString();
        mockMvc.perform(
                        MockMvcRequestBuilders
                                .delete("/deleteRequest/{id}", requestId)
                                .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(content().string(containsString(requestId)));
    }

    @Test
    @SneakyThrows
    public void getResourceWithRequestParamsTest() {
        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get(new URI("/getReqParam"))
                                .param("param", "value")
                ).andExpect(status().isOk())
                .andExpect(content().string(containsString("value")));
    }

    @Test
    @SneakyThrows
    public void getStockPriceTest() {
        Mockito.when(webService.stockPrice(anyString())).thenReturn(3f);
        mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get(new URI("/stockPrice"))
                                .param("stock", "TCL")
                ).andExpect(status().isOk())
                .andExpect(content().string(containsString("3")));
    }


}
