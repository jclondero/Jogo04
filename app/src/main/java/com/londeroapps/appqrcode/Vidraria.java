package com.londeroapps.appqrcode;

import java.util.HashMap;
import java.util.Map;

public class Vidraria {

    private String codHash;
    private String nameVidraria;
    private String descVidraria;

    public Vidraria(String codHash, String nameVidraria, String descVidraria){
        setCodHash(codHash);
        setNameVidraria(nameVidraria);
        setDescVidraria(descVidraria);
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

    public String getDescVidraria() {
        return descVidraria;
    }

    public void setDescVidraria(String descVidraria) {
        this.descVidraria = descVidraria;
    }
}
