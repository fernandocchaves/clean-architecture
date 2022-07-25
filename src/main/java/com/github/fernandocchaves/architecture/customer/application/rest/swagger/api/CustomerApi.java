package com.github.fernandocchaves.architecture.customer.application.rest.swagger.api;

import com.github.fernandocchaves.architecture.customer.application.rest.dto.request.CreateCustomerRequest;
import com.github.fernandocchaves.architecture.customer.application.rest.dto.request.UpdateCustomerRequest;
import com.github.fernandocchaves.architecture.customer.application.rest.dto.response.CustomerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;

@Tag(name = "Customers Api")
public interface CustomerApi {
    @Operation(summary = "Cria um customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "customer criado."),
            @ApiResponse(responseCode = "400", description = "Dados inválidos"),
            @ApiResponse(responseCode = "422", description = "Entidade não processada"),
            @ApiResponse(responseCode = "404", description = "Recurso não encontrado")
    })
    CustomerResponse create(@Valid CreateCustomerRequest customerRequest) throws IOException, InterruptedException;

    @Operation(summary = "Busca um customer por  id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK."),
            @ApiResponse(responseCode = "404", description = "Dados não encontrados."),
            @ApiResponse(responseCode = "422", description = "Entidade não processada.")
    })
    CustomerResponse findById(Long id);

    @Operation(summary = "Busca todos os customers por paginação")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK."),
            @ApiResponse(responseCode = "404", description = "Dados não encontrados."),
            @ApiResponse(responseCode = "422", description = "Entidade não processada.")
    })
    Page<CustomerResponse> findAll(
            @PageableDefault(sort = "id", direction = Sort.Direction.DESC) @ParameterObject Pageable pageable);

    @Operation(summary = "Atualiza o customer")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "202", description = "Requisição recebida com sucesso."),
            @ApiResponse(responseCode = "422", description = "Dados Inválidos.")
    })
    CustomerResponse update(Long id, @Valid UpdateCustomerRequest request);

    @Operation(summary = "Delete um customer por  id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Sem conteúdo"),
            @ApiResponse(responseCode = "404", description = "Dados não encontrados."),
            @ApiResponse(responseCode = "422", description = "Entidade não processada.")
    })
    void delete(Long id);
}
