package c19.pets;

public class PetCount4 {
    public static void main(String[] args) {
        TypeCounter counter = new TypeCounter(Pet.class);
        Pets.stream()
                .limit(20)
                .peek(counter::count)
                .forEach(p -> System.out.println(p.getClass().getSimpleName() + " "));
        System.out.println("n" + counter);
    }
}
