package com.sgtech.learncppbasic;

public class DataHolder {
    String Id_Name;
    String Id_Url;

    public String getId_Name() {
        return Id_Name;
    }

    public void setId_Name(String id_Name) {
        Id_Name = id_Name;
    }

    public String getId_Url() {
        return Id_Url;
    }

    public void setId_Url(String id_Url) {
        Id_Url = id_Url;
    }

    public DataHolder(String id_Name, String id_Url) {
        Id_Name = id_Name;
        Id_Url = id_Url;
    }
}
