package com.melem.operadoracartaocredito.adapters.mapper;

import com.melem.operadoracartaocredito.adapters.in.dto.request.ClienteRequestDTO;
import com.melem.operadoracartaocredito.adapters.in.dto.response.ClienteResponseDTO;
import com.melem.operadoracartaocredito.adapters.out.entities.ClienteEntity;
import com.melem.operadoracartaocredito.application.domain.CartaoDomain;
import com.melem.operadoracartaocredito.application.domain.ClienteDomain;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//TEMOS QUE FAZER A CONVERSÃO DE CLIENTE DOMAIN PARA ENTITY PARA JOGARMOS NO CLIENTE REPOSITORY IMPL, QUE É O QUE ESTÁ JOGANDO PARA PORTS OUT
@Mapper(componentModel = "spring")
public interface ClienteMapper {
    ClienteEntity paraEntity(ClienteDomain clienteDomain);

    ClienteDomain paraDomain(ClienteEntity clienteEntity);

    @Mapping(target = "cartao", expression = "java(toCartaoDomain(cliente))")
    ClienteDomain toDomain(ClienteRequestDTO cliente);

    ClienteResponseDTO toResponse(ClienteDomain cliente);

    @Mapping(source = "dataVencimentoFatura", target = "dataVencimentoFatura")
    CartaoDomain toCartaoDomain(ClienteRequestDTO clienteRequestDTO);

}
