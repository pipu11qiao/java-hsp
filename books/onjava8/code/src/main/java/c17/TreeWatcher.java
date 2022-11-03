package c17;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.nio.file.StandardWatchEventKinds.ENTRY_DELETE;

public class TreeWatcher {

    static Path test = Paths.get("src/main/java/c17/test");
    static void watchDir(Path dir) {
        try {
            WatchService watcher =
                    FileSystems.getDefault().newWatchService();
            dir.register(watcher, ENTRY_DELETE);
            Executors.newSingleThreadScheduledExecutor().submit(() -> {
                try {
                    WatchKey key = watcher.take();
                    for (WatchEvent evt : key.pollEvents()) {
                        System.out.println("evt.context(): " + evt.context() +
                                "\nevt.count(): " + evt.count() +
                                "\nevt.kind(): " + evt.kind()
                        );
                        System.exit(0);
                    }
                } catch (InterruptedException e) {
                    return;
                }
            });
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    public static void main(String[] args) throws  Exception{
        Directories.refreshTestDir();
        Directories.populateTestDir();
        Files.walk(test)
                .filter(Files::isDirectory)
                .forEach(TreeWatcher::watchDir);
        PathWatcher.delTxtFiles();
    }
}
