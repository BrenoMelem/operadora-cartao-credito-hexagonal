package com.melem.operadoracartaocredito.application.service;

import com.melem.operadoracartaocredito.application.domain.CartaoDomain;
import com.melem.operadoracartaocredito.application.domain.ClienteDomain;
import com.melem.operadoracartaocredito.porters.out.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final GeraDadosCartaoService geraDadosCartaoService;

    public ClienteDomain solicitarCartao (ClienteDomain cliente){
        if (clienteRepository.buscarPorEmail(cliente.getEmail())){
            throw new IllegalArgumentException("Usuário já possui um cartão");
        }
        CartaoDomain cartao = geraDadosCartaoService.gerarParaCliente(cliente);
        cliente.setCartao(cartao);
        return clienteRepository.salvar(cliente);
    }

    public ClienteDomain buscarPorCpf (String cpf){
        return clienteRepository.buscarUsuarioPorCpf(cpf).orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
    }
}
