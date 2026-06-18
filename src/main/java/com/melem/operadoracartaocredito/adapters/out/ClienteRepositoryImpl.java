package com.melem.operadoracartaocredito.adapters.out;

import com.melem.operadoracartaocredito.adapters.mapper.ClienteMapper;
import com.melem.operadoracartaocredito.adapters.out.repositories.ClienteJpaRepository;
import com.melem.operadoracartaocredito.application.domain.ClienteDomain;
import com.melem.operadoracartaocredito.ports.out.IClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;
//Temos que fazer a Implentação da interface chame o Cliente JpaREPOSITORY
//Algo mais generico sem muita responsabilidade
@Component // anotação para que o Spring consiga identificar essa classe como um componente e possa injetá-la onde for necessário.
@RequiredArgsConstructor
public class ClienteRepositoryImpl implements IClienteRepository {
    private final ClienteMapper clienteMapper;
    private final ClienteJpaRepository clienteJpaRepository;

    @Override
    public ClienteDomain salvar(ClienteDomain clienteDomain) {
        return clienteMapper.paraDomain(clienteJpaRepository.save(clienteMapper.paraEntity(clienteDomain)));
    }

    @Override
    public boolean buscarPorEmail(String email) {
        return clienteJpaRepository.existsByEmail(email);
    }

    @Override
    public Optional<ClienteDomain> buscarUsuarioPorCpf(String cpf) {
        return clienteJpaRepository.findByCpf(cpf).map(clienteMapper::paraDomain); // CONTINUA LEVANDO  OPTIONAL PRA DENTRO DA REGRA DE NEGOCIO,
    }
}
