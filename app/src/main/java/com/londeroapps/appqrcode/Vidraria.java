package com.londeroapps.appqrcode;

import java.util.HashMap;
import java.util.Map;

public class Vidraria {

    private String codHash;
    private String nameVidraria;

    public Vidraria(String codHash, String nameVidraria){
        setCodHash(codHash);
        setNameVidraria(nameVidraria);
    }

    public Vidraria(){

    }

    public String getCodHash() {
        return codHash;
    }

    public void setCodHash(String codHash) {
        this.codHash = codHash;
    }

    public String getNameVidraria() {
        return nameVidraria;
    }

    public void setNameVidraria(String nameVidraria) {
        this.nameVidraria = nameVidraria;
    }
}
