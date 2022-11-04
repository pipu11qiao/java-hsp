package c19.pets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForNameCreator extends PetCreator {
    private static List<Class<? extends Pet>> types = new ArrayList<>();

    private static String[] typeNames = {
            "c19.pets.Mutt",
            "c19.pets.Pug",
            "c19.pets.EgyptianMau",
            "c19.pets.Manx",
            "c19.pets.Cymric",
            "c19.pets.Rat",
            "c19.pets.Mouse",
            "c19.pets.Hamster",
    };

    @SuppressWarnings("unchecked")
    private static void loader() {
        try {
            for (String name : typeNames) {
                types.add((Class<? extends Pet>) Class.forName(name));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException();
        }
    }

    static {
        loader();
    }

    @Override
    public List<Class<? extends Pet>> types() {
        return types;
    }

}
