package me.vukas.hibernate.domen;

/**
 * Created by default on 08/07/17.
 */
public enum Enumeracija {
    JEDAN(15),
    DVA(44);

    int id;

    Enumeracija(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Enumeracija fromId(int id){
        for(Enumeracija e : Enumeracija.values()){
            if(e.getId() == id){
                return e;
            }
        }
        return JEDAN;
    }
}
