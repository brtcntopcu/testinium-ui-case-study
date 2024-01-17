package data;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class TXTFile {

    public void write(String text) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream("product info.txt"), StandardCharsets.UTF_8))) {
            writer.write(text);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
