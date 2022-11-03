package c17;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathAnalysis {
    static void say(String id, Object result) {
        System.out.println(id + ": ");
        System.out.println(result);
    }

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("os.name"));
        Path p = Paths.get("src/main/java/c17/PathAnalysis.java").toAbsolutePath();
        say("Exists", Files.exists(p));
        say("Directory", Files.isDirectory(p));
        say("Executable", Files.isExecutable(p));
        say("Readable", Files.isReadable(p));
        say("RegularFile", Files.isRegularFile(p));
        say("Writable", Files.isWritable(p));
        say("notExists", Files.notExists(p));
        say("size", Files.size(p));
        say("FileStore", Files.getFileStore(p));
        say("LastModified", Files.getLastModifiedTime(p));
        say("Owner", Files.getOwner(p));
        say("ContentType", Files.probeContentType(p));
        say("SymbolicLink", Files.isSymbolicLink(p));
        if (Files.isSymbolicLink(p)) {
            say("SymbolicLink", Files.readSymbolicLink(p));
        }
        if (FileSystems.getDefault().supportedFileAttributeViews().contains("posix")) {
            say("PosixFilePermission", Files.getPosixFilePermissions(p));
        }
    }
}
