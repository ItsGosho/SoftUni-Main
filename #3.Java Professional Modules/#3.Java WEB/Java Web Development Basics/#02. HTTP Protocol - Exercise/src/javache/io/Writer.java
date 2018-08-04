package javache.io;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public final class Writer {

    public static void writerBytes(byte[] byteData, OutputStream outputStream) throws IOException {
        DataOutputStream buffer = new DataOutputStream(outputStream);
        buffer.write(byteData);
    }
}
