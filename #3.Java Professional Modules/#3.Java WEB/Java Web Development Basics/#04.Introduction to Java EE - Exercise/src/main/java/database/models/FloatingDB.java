package database.models;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class FloatingDB {

    private static HashMap<String,Cat> cats=new LinkedHashMap<>();

    public static HashMap<String, Cat> getCats() {
        return cats;
    }

    public static void setCats(HashMap<String, Cat> cats) {
        FloatingDB.cats = cats;
    }
}
