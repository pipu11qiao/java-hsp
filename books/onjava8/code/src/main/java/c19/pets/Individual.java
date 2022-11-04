package c19.pets;

public class Individual {
    static int cnt = 0;
    public String id;

    public String name;

    public Individual() {
        setId("id_" + cnt++);
    }

    public Individual(String name) {
        this();
        setName(name);
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
