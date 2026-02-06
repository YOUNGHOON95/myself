package com.one.study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.MediaType;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class CodeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("회원 ID 조회")
    void selectCodeById() throws Exception {

        // given
        String paramCd = "3";

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/select/id/" + paramCd)
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON)));

        // then
        MvcResult mvcResult = resultActions
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        System.out.println("mvcResult :: " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("회원 name 조회")
    void selectCodeByName() throws Exception {

        // given
        String paramCd = "테스";

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/select/name/" + paramCd)
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON)));

        // then
        MvcResult mvcResult = resultActions
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        System.out.println("mvcResult :: " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("회원 전체 조회")
    void selectCode() throws Exception {

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/api/user/select")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON)));

        // then
        MvcResult mvcResult = resultActions
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        System.out.println("mvcResult :: " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("등록")
    void insertCode() throws Exception {

        // given
        String requestBody = """
        {
            "name": "테스트 이름",
            "password": "qwe123!@#$",
            "title": "제목란 제목 입력",
            "email": "qwe123@naver.com",
            "contact": "내용 입력란"
        }
        """;

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post("/api/user")
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(requestBody));


        // then
        MvcResult mvcResult = resultActions
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        System.out.println("mvcResult :: " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("업데이트")
    void updateCode() throws Exception {

        // given
        String requestBody = """
        {
            "name": "테스트이름"
        }
        """;

        String paramCd = "3";


        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.put("/api/user/update/" + paramCd)
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON))
                        .content(requestBody));

        // then
        MvcResult mvcResult = resultActions
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        System.out.println("mvcResult :: " + mvcResult.getResponse().getContentAsString());
    }

    @Test
    @DisplayName("삭제")
    void deleteCode() throws Exception {

        // given
        String paramCd = "4";

        // when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.delete("/api/user/delete/" + paramCd)
                        .contentType(String.valueOf(MediaType.APPLICATION_JSON)));

        // then
        MvcResult mvcResult = resultActions
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        System.out.println("mvcResult :: " + mvcResult.getResponse().getContentAsString());
    }


}
