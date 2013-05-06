package cc.io;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Wes Lanning
 * @version 2013-05-05
 */
public class _BufferedInputStream implements AutoCloseable
{
    private BufferedInputStream bis;

    public _BufferedInputStream(InputStream in)
    {
        bis = new BufferedInputStream(in);
    }

    public _BufferedInputStream(InputStream in, int size)
    {
        bis = new BufferedInputStream(in, size);
    }

    /**
     * Reads a single byte from this stream and returns it as an integer in the
     * range from 0 to 255. Returns -1 if the end of the source string has been
     * reached. If the internal buffer does not contain any available bytes then
     * it is filled from the source stream and the first byte is returned.
     *
     * @return the byte read or -1 if the end of the source stream has been
     *         reached.
     * @throws IOException
     *             if this stream is closed or another IOException occurs.
     */
    public synchronized int read() throws IOException
    {
        return bis.read();
    }

    /**
     * Reads at most {@code byteCount} bytes from this stream and stores them in
     * byte array {@code buffer} starting at offset {@code offset}. Returns the
     * number of bytes actually read or -1 if no bytes were read and the end of
     * the stream was encountered. If all the buffered bytes have been used, a
     * mark has not been set and the requested number of bytes is larger than
     * the receiver's buffer size, this implementation bypasses the buffer and
     * simply places the results directly into {@code buffer}.
     *
     * @param buffer
     *            the byte array in which to store the bytes read.
     * @return the number of bytes actually read or -1 if end of stream.
     * @throws IndexOutOfBoundsException
     *             if {@code offset < 0} or {@code byteCount < 0}, or if
     *             {@code offset + byteCount} is greater than the size of
     *             {@code buffer}.
     * @throws IOException
     *             if the stream is already closed or another IOException
     *             occurs.
     */
    public synchronized int read(byte[] buffer, int offset, int byteCount) throws IOException
    {
        return bis.read(buffer, offset, byteCount);
    }

    /**
     * Skips {@code byteCount} bytes in this stream. Subsequent calls to
     * {@code read} will not return these bytes unless {@code reset} is
     * used.
     *
     * @param byteCount
     *            the number of bytes to skip. {@code skip} does nothing and
     *            returns 0 if {@code byteCount} is less than zero.
     * @return the number of bytes actually skipped.
     * @throws IOException
     *             if this stream is closed or another IOException occurs.
     */
    public synchronized long skip(long byteCount) throws IOException
    {
        return bis.skip(byteCount);
    }

    /**
     * Resets this stream to the last marked location.
     *
     * @throws IOException
     *             if this stream is closed, no mark has been set or the mark is
     *             no longer valid because more than {@code readlimit} bytes
     *             have been read since setting the mark.
     * @see #mark(int)
     */
    public synchronized void reset() throws IOException
    {

    }

    /**
     * Returns an estimated number of bytes that can be read or skipped without blocking for more
     * input. This method returns the number of bytes available in the buffer
     * plus those available in the source stream, but see {@link InputStream#available} for
     * important caveats.
     *
     * @return the estimated number of bytes available
     * @throws IOException if this stream is closed or an error occurs
     */
    public synchronized int available() throws IOException
    {
        return bis.available();
    }

    /**
     * Sets a mark position in this stream. The parameter {@code readlimit}
     * indicates how many bytes can be read before a mark is invalidated.
     * Calling {@code reset()} will reposition the stream back to the marked
     * position if {@code readlimit} has not been surpassed. The underlying
     * buffer may be increased in size to allow {@code readlimit} number of
     * bytes to be supported.
     *
     * @param readlimit
     *            the number of bytes that can be read before the mark is
     *            invalidated.
     * @see #reset()
     */
    public synchronized void mark(int readlimit)
    {
        bis.mark(readlimit);
    }

    /**
     * Indicates whether {@code BufferedInputStream} supports the {@code mark()}
     * and {@code reset()} methods.
     *
     * @return {@code true} for BufferedInputStreams.
     *
     * @see #mark(int)
     * @see #reset()
     */
    public boolean markSupported()
    {
        return bis.markSupported();
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
     * @throws Exception if this resource cannot be closed
     */
    @Override
    public void close() throws IOException
    {
        Log.d("_BufferedInputStream", "Buffered instream closed");
        bis.close();
    }
}
