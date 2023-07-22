package com.aumones.tools.communs.unit.controller;

import com.aumones.tools.communs.exemple.data.model.JpaExempleModel;
import com.aumones.tools.communs.exemple.service.JpaExempleService;
import com.aumones.tools.communs.exemple.web.controller.JpaExempleController;
import com.aumones.tools.communs.exemple.web.dto.request.ExempleSearchRequestDto;
import com.aumones.tools.communs.exemple.web.dto.request.JpaExempleCreateRequestDto;
import com.aumones.tools.communs.exemple.web.dto.request.JpaExempleUpdateRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(JpaExempleController.class)
public class JpaExempleControllerUnitTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private JpaExempleService service;

  private List<JpaExempleModel> models;

  @BeforeEach
  public void setup() {
    this.models = Arrays.asList(
        new JpaExempleModel(123L, "John Doe", 40),
        new JpaExempleModel(456L, "Jane Smith", 35)
    );
  }

  @Test
  public void testList() throws Exception {
    // Étape 1 : Préparation des données de test
    when(service.list(any(ExempleSearchRequestDto.class))).thenReturn(models);

    // Étape 2 : Exécution de l'api à tester
    ResultActions result = mockMvc.perform(get("/api/exemple-jpa/list"))
        .andDo(print());

    // Étape 3 : Vérification des résultats
    result.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(2)))
        .andExpect(jsonPath("$[0].id").value(models.get(0).getId()))
        .andExpect(jsonPath("$[0].name").value(models.get(0).getName()))
        .andExpect(jsonPath("$[0].age").value(models.get(0).getAge()))
        .andExpect(jsonPath("$[1].id").value(models.get(1).getId()))
        .andExpect(jsonPath("$[1].name").value(models.get(1).getName()))
        .andExpect(jsonPath("$[1].age").value(models.get(1).getAge()));
  }

  @Test
  public void testListWithFilter() throws Exception {
    // Étape 1 : Préparation des données de test
    ExempleSearchRequestDto searchRequest = new ExempleSearchRequestDto();
    searchRequest.setName(models.get(0).getName());

    MultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
    requestParams.add("name", searchRequest.getName());

    when(service.list(eq(searchRequest))).thenReturn(Collections.singletonList(models.get(0)));

    // Étape 2 : Exécution de l'api à tester
    ResultActions result = mockMvc.perform(get("/api/exemple-jpa/list")
            .queryParams(requestParams))
        .andDo(print());

    // Étape 3 : Vérification des résultats
    result.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].id").value(models.get(0).getId()))
        .andExpect(jsonPath("$[0].name").value(models.get(0).getName()))
        .andExpect(jsonPath("$[0].age").value(models.get(0).getAge()));
  }

  @Test
  public void testCreate() throws Exception {
    // Étape 1 : Préparation des données de test
    JpaExempleCreateRequestDto createRequest = new JpaExempleCreateRequestDto(models.get(0).getName(), models.get(0).getAge());
    when(service.create(createRequest)).thenReturn(models.get(0));

    // Étape 2 : Exécution de l'api à tester
    ObjectMapper objectMapper = new ObjectMapper();
    String requestBody = objectMapper.writeValueAsString(createRequest);

    ResultActions result = mockMvc.perform(post("/api/exemple-jpa/create")
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
        .andDo(print());

    // Étape 3 : Vérification des résultats
    result.andExpect(status().isCreated())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").exists())
        .andExpect(jsonPath("$.name").value(createRequest.getName()))
        .andExpect(jsonPath("$.age").value(createRequest.getAge()));
  }

  @Test
  public void testUpdate() throws Exception {
    // Étape 1 : Préparation des données de test
    JpaExempleUpdateRequestDto updateRequest = new JpaExempleUpdateRequestDto("Peter Jefferson", 25);
    when(service.update(eq(models.get(0).getId()), any(JpaExempleUpdateRequestDto.class))).thenReturn(
        new JpaExempleModel(models.get(0).getId(), updateRequest.getName(), updateRequest.getAge()));

    // Étape 2 : Exécution de l'api à tester
    ObjectMapper objectMapper = new ObjectMapper();
    String requestBody = objectMapper.writeValueAsString(updateRequest);

    ResultActions result = mockMvc.perform(put("/api/exemple-jpa/update/"+models.get(0).getId())
            .contentType(MediaType.APPLICATION_JSON)
            .content(requestBody))
        .andDo(print());

    // Étape 3 : Vérification des résultats
    result.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.id").exists())
        .andExpect(jsonPath("$.id").value(models.get(0).getId()))
        .andExpect(jsonPath("$.name").value(updateRequest.getName()))
        .andExpect(jsonPath("$.age").value(updateRequest.getAge()));
  }
}