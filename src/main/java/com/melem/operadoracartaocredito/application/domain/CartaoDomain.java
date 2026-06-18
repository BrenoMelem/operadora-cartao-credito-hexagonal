package com.melem.operadoracartaocredito.application.domain;

import java.time.LocalDate;
//Por conta de Utilizarmos a Hexagonal, não utilizaremos anotações do Lombok, iremos gerar os construtores e getters e setters.

public class CartaoDomain {


    private Long id;
    private String numero;
    private LocalDate dataExpiracao;
    private String cvv;
    private double limite;
    private double availableLimit;
    private LocalDate ultimaAlteracaoLimite;
    private Integer dataVencimentoFatura;
    private ClienteDomain cliente;

    public CartaoDomain() {
    }

    public CartaoDomain(ClienteDomain cliente, Integer dataVencimentoFatura, LocalDate ultimaAlteracaoLimite, double availableLimit, double limite, String cvv, LocalDate dataExpiracao, String numero, Long id) {
        this.cliente = cliente;
        this.dataVencimentoFatura = dataVencimentoFatura;
        this.ultimaAlteracaoLimite = ultimaAlteracaoLimite;
        this.availableLimit = availableLimit;
        this.limite = limite;
        this.cvv = cvv;
        this.dataExpiracao = dataExpiracao;
        this.numero = numero;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public LocalDate getDataExpiracao() {
        return dataExpiracao;
    }

    public void setDataExpiracao(LocalDate dataExpiracao) {
        this.dataExpiracao = dataExpiracao;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    public double getAvailableLimit() {
        return availableLimit;
    }

    public void setAvailableLimit(double availableLimit) {
        this.availableLimit = availableLimit;
    }

    public LocalDate getUltimaAlteracaoLimite() {
        return ultimaAlteracaoLimite;
    }

    public void setUltimaAlteracaoLimite(LocalDate ultimaAlteracaoLimite) {
        this.ultimaAlteracaoLimite = ultimaAlteracaoLimite;
    }

    public Integer getDataVencimentoFatura() {
        return dataVencimentoFatura;
    }

    public void setDataVencimentoFatura(Integer dataVencimentoFatura) {
        this.dataVencimentoFatura = dataVencimentoFatura;
    }

    public ClienteDomain getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDomain cliente) {
        this.cliente = cliente;
    }
    public CartaoDomain(String numeroCartao, LocalDate dataExpiracao, String cvv, double limiteCredito, ClienteDomain cliente, LocalDate ultimaAlteracaoLimite, Integer dataVencimentoFatura) {
        this.numero = numero;
        this.dataExpiracao = dataExpiracao;
        this.cvv = cvv;
        this.limite = limite;
        this.availableLimit = limite; // cartão novo: limite disponível = limite total
        this.cliente = cliente;
        this.ultimaAlteracaoLimite = ultimaAlteracaoLimite;
        this.dataVencimentoFatura = dataVencimentoFatura;
    }

}
