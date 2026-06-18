package com.melem.operadoracartaocredito.ports.out;

import com.melem.operadoracartaocredito.application.domain.ClienteDomain;

import java.util.Optional;

public interface IClienteRepository {
    ClienteDomain salvar(ClienteDomain clienteDomain);

    boolean buscarPorEmail(String email);

    Optional<ClienteDomain> buscarUsuarioPorCpf(String cpf);
}
