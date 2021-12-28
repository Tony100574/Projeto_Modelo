package com.example.projetoAntonio.core.sqlconnection;

public enum SqlCredentials {
    USER (""),
    PSWD (""),
    URI ("jdbc:mysql://");

    private final String s;

    SqlCredentials(String s){
        this.s = s;
    }

    public String getValue(){
        return this.s;
    }
}
