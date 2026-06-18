package com.melem.operadoracartaocredito.application.service;

import com.melem.operadoracartaocredito.adapters.in.IClienteService;
import com.melem.operadoracartaocredito.application.domain.CartaoDomain;
import com.melem.operadoracartaocredito.application.domain.ClienteDomain;
import com.melem.operadoracartaocredito.ports.out.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteServiceImpl implements IClienteService {

    private final IClienteRepository clienteRepository;
    private final GeraDadosCartaoService geraDadosCartaoService;

    @Override
    public ClienteDomain solicitarCartao(ClienteDomain cliente) {
        if (clienteRepository.buscarPorEmail(cliente.getEmail())) {
            throw new IllegalArgumentException("Usuário já possui um cartão");
        }
        CartaoDomain cartao = geraDadosCartaoService.gerarParaCliente(cliente);
        cliente.setCartao(cartao);
        return clienteRepository.salvar(cliente);
    }
    @Override
    public ClienteDomain buscarPorCpf(String cpf) {
        return clienteRepository.buscarUsuarioPorCpf(cpf).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
    }
}
