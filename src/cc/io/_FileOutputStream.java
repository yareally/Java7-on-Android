package cc.io;

import android.util.Log;

import java.io.*;
import java.nio.channels.FileChannel;

public class _FileOutputStream implements AutoCloseable, Flushable
{
    private FileOutputStream fos;

    /**
     * Constructs a new {@code FileOutputStream} that writes to {@code path}. The file will be
     * truncated if it exists, and created if it doesn't exist.
     *
     * @throws java.io.FileNotFoundException if file cannot be opened for writing.
     */
    public _FileOutputStream(String path) throws FileNotFoundException
    {
        fos = new java.io.FileOutputStream(path);
    }

    /**
     * Constructs a new {@code FileOutputStream} that writes to {@code file}. The file will be
     * truncated if it exists, and created if it doesn't exist.
     *
     * @throws FileNotFoundException if file cannot be opened for writing.
     */
    public _FileOutputStream(File file) throws FileNotFoundException
    {
        fos = new java.io.FileOutputStream(file);
    }

    /**
     * Constructs a new {@code FileOutputStream} that writes to {@code fd}.
     *
     * @throws NullPointerException if {@code fd} is null.
     */
    public _FileOutputStream(FileDescriptor fd)
    {
        fos = new java.io.FileOutputStream(fd);
    }

    /**
     * Constructs a new {@code FileOutputStream} that writes to {@code file}.
     * If {@code append} is true and the file already exists, it will be appended to; otherwise
     * it will be truncated. The file will be created if it does not exist.
     *
     * @throws FileNotFoundException if the file cannot be opened for writing.
     */
    public _FileOutputStream(File file, boolean append) throws FileNotFoundException
    {
        fos = new java.io.FileOutputStream(file, append);
    }

    /**
     * Constructs a new {@code FileOutputStream} that writes to {@code file}.
     * If {@code append} is true and the file already exists, it will be appended to; otherwise
     * it will be truncated. The file will be created if it does not exist.
     *
     * @throws FileNotFoundException if the file cannot be opened for writing.
     */
    public _FileOutputStream(String path, boolean append) throws FileNotFoundException
    {
        fos = new java.io.FileOutputStream(path, append);
    }

    /**
     * Returns a write-only {@link FileChannel} that shares its position with
     * this stream.
     */
    public FileChannel getChannel()
    {
        return fos.getChannel();
    }

    /**
     * Returns the underlying file descriptor.
     */
    public final FileDescriptor getFD() throws IOException
    {
        return fos.getFD();
    }

    public void write(int oneByte) throws IOException
    {
        fos.write(oneByte);
    }

    /**
     * Equivalent to {@code write(buffer, 0, buffer.length)}.
     */
    public void write(byte[] buffer) throws IOException
    {
        fos.write(buffer, 0, buffer.length);
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting at
     * position {@code offset} to this stream.
     *
     * @param buffer the buffer to be written.
     * @param offset the start position in {@code buffer} from where to get bytes.
     * @param count the number of bytes from {@code buffer} to write to this
     * stream.
     * @throws IOException if an error occurs while writing to this stream.
     * @throws IndexOutOfBoundsException if {@code offset < 0} or {@code count < 0}, or if
     * {@code offset + count} is bigger than the length of
     * {@code buffer}.
     */
    public void write(byte[] buffer, int offset, int count) throws IOException
    {
        fos.write(buffer, offset, count);
    }

    /**
     * Flushes this stream. Implementations of this method should ensure that
     * any buffered data is written out. This implementation does nothing.
     *
     * @throws IOException if an error occurs while flushing this stream.
     */
    @Override
    public void flush() throws IOException
    {
        fos.flush();
    }

    /**
     * Closes this resource, relinquishing any underlying resources.
     * This method is invoked automatically on objects managed by the
     * {@code try}-with-resources statement.
     *
     * <p>While this interface method is declared to throw {@code
     * Exception}, implementers are <em>strongly</em> encouraged to
     * declare concrete implementations of the {@code close} method to
     * throw more specific exceptions, or to throw no exception at all
     * if the close operation cannot fail.
     *
     * <p><em>Implementers of this interface are also strongly advised
     * to not have the {@code close} method throw {@link
     * InterruptedException}.</em>
     *
     * This exception interacts with a thread's interrupted status,
     * and runtime misbehavior is likely to occur if an {@code
     * InterruptedException} is .
     *
     * More generally, if it would cause problems for an
     * exception to be suppressed, the {@code AutoCloseable.close}
     * method should not throw it.
     *
     * <p>Note that unlike the {@link java.io.Closeable#close close}
     * method of {@link java.io.Closeable}, this {@code close} method
     * is <em>not</em> required to be idempotent.  In other words,
     * calling this {@code close} method more than once may have some
     * visible side effect, unlike {@code Closeable.close} which is
     * required to have no effect if called more than once.
     *
     * However, implementers of this interface are strongly encouraged
     * to make their {@code close} methods idempotent.
     *
     * @throws IOException if this resource cannot be closed
     */
    @Override
    public void close() throws IOException
    {
        Log.d("_FileOutputStream", "outstream closed");
        fos.close();
    }
}