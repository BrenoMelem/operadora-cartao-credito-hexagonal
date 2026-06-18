package com.melem.operadoracartaocredito.adapters.in;

import com.melem.operadoracartaocredito.application.domain.ClienteDomain;

public interface IClienteService {

    ClienteDomain solicitarCartao(ClienteDomain cliente);
    ClienteDomain buscarPorCpf (String cpf);
}
