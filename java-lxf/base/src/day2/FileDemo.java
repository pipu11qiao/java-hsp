package day2;

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        File f = new File("..");
        System.out.println(f.getPath());
        System.out.println(f.getAbsoluteFile());
        System.out.println(f.getCanonicalPath());
        System.out.println(File.separator);
        // isFile isDirectory
        System.out.println(f.isFile());
        System.out.println(f.isDirectory());

        System.out.println(f.canRead());
        System.out.println(f.canWrite());
        System.out.println(f.canExecute());
    }
}
