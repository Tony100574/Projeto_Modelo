package com.example.projetoAntonio.core.model;

public class Conta {

    private final long id;
    private final String titular;
    private final int numero;
    private final int agencia;
    private final double saldo;
    private final int tipo;

    public Conta(long id, String titular, int numero, int agencia, double saldo, int tipo) {
        this.id = id;
        this.titular = titular;
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public long getId() {
        return id;
    }

    public String getTitular() {
        return titular;
    }

    public int getNumero() {
        return numero;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getTipo() {
        return tipo;
    }
}
