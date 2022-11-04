package c19.pets;

import java.util.LinkedHashMap;
import java.util.stream.Collectors;

import util.Pair;

public class PetCount3 {

    static class Counter extends LinkedHashMap<Class<? extends Pet>, Integer> {
        Counter() {
            super(
                    LiteralPetCreator.ALL_TYPES.stream()
                            .map(lpc -> Pair.make(lpc, 0))
                            .collect(
                                    Collectors.toMap(Pair::key, Pair::value)
                            )
            );
        }

        public void count(Pet pet) {
            entrySet().stream()
                    .filter(pair -> pair.getKey().isInstance(pet))
                    .forEach(pair ->
                            put(pair.getKey(), pair.getValue() + 1)
                    );
        }

        @Override
        public String toString() {
            String result = entrySet().stream()
                    .map(pair -> String.format("%s=%s", pair.getKey().getSimpleName(), pair.getValue()))
                    .collect(Collectors.joining(","));
            return "{" + result + "}";
        }
    }

    public static void main(String[] args) {
        Counter petCount = new Counter();
        Pets.stream()
                .limit(20)
                .peek(petCount::count)
                .forEach(p -> System.out.println(
                        p.getClass().getSimpleName() + " "
                ));
        System.out.println("n" + petCount);
    }

}
