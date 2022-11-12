package c12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import c19.pets.*;

public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.list(7);
        System.out.println("1: " + pets);
        Hamster h = new Hamster();
        pets.add(h);
        System.out.println("2: " + pets);
        System.out.println("3: " + pets.contains(h));
        pets.remove(h);
        Pet p = pets.get(2);
        System.out.println("4: " + p + " " + pets.indexOf(p));
        Pet cymric = new Cymric();
        System.out.println("5: " + pets.indexOf(cymric));
        System.out.println("6: " + pets.remove(cymric));
        List<Pet> copy  = new ArrayList<>(pets);

        copy.retainAll(pets);
    }

}