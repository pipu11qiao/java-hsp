package designPattern.create.abstractFactory;

import java.io.IOException;
import java.nio.file.Path;

public class FastHtmlDocument implements HtmlDocument {
    @Override
    public String toHtml() {
        return "";
    }

    @Override
    public void save(Path path) throws IOException {
        System.out.println("FastHtmlDocument save");
    }
}
