package annotation;


import java.lang.reflect.Field;

class Person {

    @Range(min = 1, max = 20)
    public String name;

    @Range(max = 10)
    public String city;

    public Person(String name, String city) {
        this.name = name;
        this.city = city;

    }

    public Person() {
        this("", "");
    }

}

public class RangeDemo {

    public void check(Person person) throws IllegalAccessException {
        for (Field field : person.getClass().getFields()) {
            Range range = field.getAnnotation(Range.class);
            if (range != null) {
                Object value = field.get(person);

                if (value instanceof String) {
                    String s = (String) value;
                    if (s.length() < range.min() || s.length() > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }

            }
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        Person p1 = new Person("tom","shanghai");
        RangeDemo rd = new RangeDemo();
        rd.check(p1);
    }
}
