package com.melem.operadoracartaocredito.porters.out;

import com.melem.operadoracartaocredito.application.domain.ClienteDomain;

import java.util.Optional;

public interface ClienteRepository {
    ClienteDomain salvar(ClienteDomain clienteDomain);

    boolean buscarPorEmail(String email);

    Optional<ClienteDomain> buscarUsuarioPorCpf(String cpf);
}
