package com.melem.operadoracartaocredito.adapters.in.controller;


import com.melem.operadoracartaocredito.adapters.in.IClienteService;
import com.melem.operadoracartaocredito.adapters.in.dto.request.ClienteRequestDTO;
import com.melem.operadoracartaocredito.adapters.in.dto.response.ClienteResponseDTO;
import com.melem.operadoracartaocredito.adapters.mapper.ClienteMapper;
import com.melem.operadoracartaocredito.application.domain.ClienteDomain;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cliente")
public class ClienteController {

    private final IClienteService clienteServicePort;
    private final ClienteMapper mapper;

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> solicitaCartao(@RequestBody ClienteRequestDTO clienteRequestDTO) {
        mapper.toResponse(clienteServicePort.solicitarCartao(mapper.toDomain(clienteRequestDTO)));
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<ClienteResponseDTO> buscaClientePorCpf(@RequestParam String cpf) {
        ClienteDomain cliente = clienteServicePort.buscarPorCpf(cpf);
        return ResponseEntity.ok(mapper.toResponse(cliente));
    }
}