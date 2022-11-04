package c19.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {
    @SuppressWarnings("unchecked")
    public static final List<Class<? extends Pet>> ALL_TYPES = List.of(Pet.class, Dog.class, Cat.class, Rodent.class, Mutt.class, Cymric.class, EgyptianMau.class, Hamster.class, Manx.class, Mouse.class, Pug.class, Rat.class);
    private static final List<Class<? extends Pet>> TYPES = ALL_TYPES.subList(ALL_TYPES.indexOf(Mutt.class),
            ALL_TYPES.size()
    );

    @Override
    public List<Class<? extends Pet>> types() {
        return TYPES;
    }

    public static void main(String[] args) {
        System.out.println(TYPES);
    }
}
