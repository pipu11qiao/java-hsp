package designPattern.create.abstractFactory;

import java.io.IOException;
import java.nio.file.Path;

public class FastWordDocument implements WordDocument {
    @Override
    public void save(Path path) throws IOException {
        System.out.println("FastHtmlDocument save");
    }
}
