package designPattern.create.abstractFactory;


import java.io.IOException;
import java.nio.file.Paths;

public class Client {
    public static void main(String[] args) throws IOException {
        AbstractFactory factory = new FastFactory();
        HtmlDocument html = factory.createHtml("#hello\nhello,world!");
        html.save(Paths.get(".", "fast.html"));
        WordDocument word = factory.createWord("#hello\nhello,world!");
        word.save(Paths.get(".", "fast.word"));
    }

}
