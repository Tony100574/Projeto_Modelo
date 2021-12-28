package com.example.projetoAntonio.core.sqlconnection;

import com.example.projetoAntonio.core.model.Conta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;

public final class GetContas {

    private GetContas(){}

    public static ArrayList<Conta> getContas(){

        try (Connection con = DriverManager.getConnection(SqlCredentials.URI.getValue(), SqlCredentials.USER.getValue(), SqlCredentials.PSWD.getValue())) {
            ArrayList<Conta> conta = new ArrayList<>();
            ResultSet usr = con.createStatement().executeQuery("SELECT id, titular, numero, agencia, tipo, saldo FROM contas;");
            while (usr.next()){
                conta.add(new Conta(usr.getLong("id"),
                        usr.getString("titular"),
                        usr.getInt("numero"),
                        usr.getInt("agencia"),
                        usr.getDouble("saldo"),
                        usr.getInt("tipo")));
            }
            return conta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Conta getContaById(long id){
        try (Connection con = DriverManager.getConnection(SqlCredentials.URI.getValue(), SqlCredentials.USER.getValue(), SqlCredentials.PSWD.getValue())) {
            Conta conta;
            ResultSet usr = con.createStatement().executeQuery(String.format("SELECT id, titular, numero, agencia, tipo, saldo FROM contas WHERE id=%s;", id));
            usr.next();
            conta = new Conta(usr.getLong("id"), usr.getString("titular"), usr.getInt("numero"), usr.getInt("agencia"), usr.getDouble("saldo"), usr.getInt("tipo"));
            return conta;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
