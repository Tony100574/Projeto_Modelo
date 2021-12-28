package com.example.projetoAntonio.port.datatransfer;

import com.example.projetoAntonio.core.model.Conta;
import com.example.projetoAntonio.core.sqlconnection.GetContas;
import com.example.projetoAntonio.port.dto.ContaDto;

import java.util.ArrayList;
import java.util.Objects;

public final class ContaList {

    private ContaList(){}

    public static ArrayList<ContaDto> lista = new ArrayList<>();

    public static ArrayList<ContaDto> getContas(){
        lista = new ArrayList<>();
        for (Conta conta : Objects.requireNonNull(GetContas.getContas())){
            lista.add(new ContaDto(conta.getTitular(), conta.getNumero(), conta.getAgencia(), conta.getSaldo(), conta.getTipo()));
        }
        return lista;
    }

    public static ContaDto getUserById(long id){
        Conta conta = GetContas.getContaById(id);
        assert conta != null;
        return new ContaDto(conta.getTitular(), conta.getNumero(), conta.getAgencia(), conta.getSaldo(), conta.getTipo());
    }

}
