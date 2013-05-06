/*
Copyright (c) 2012 Wes Lanning, http://codingcreation.com

Permission is hereby granted, free of charge, to any person obtaining
a copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

http://www.opensource.org/licenses/mit-license.php
*/

package cc.io;

import android.util.Log;

import java.io.*;
import java.nio.channels.FileChannel;

public class _FileInputStream extends InputStream implements AutoCloseable
{
    private FileInputStream fis;

    /**
     * Equivalent to {@code new FileInputStream(new File(path))}.
     */
    public _FileInputStream(String path) throws IOException
    {
        fis = new java.io.FileInputStream(path);
    }

    /**
     * Constructs a new {@code _FileInputStream} that reads from {@code fd}.
     *
     * @param fd the FileDescriptor from which this stream reads.
     * @throws NullPointerException if {@code fd} is {@code null}.
     */
    public _FileInputStream(FileDescriptor fd)
    {
        fis = new java.io.FileInputStream(fd);
    }

    /**
     * Constructs a new {@code FileInputStream} that reads from {@code file}.
     *
     * @param file the file from which this stream reads.
     * @throws java.io.FileNotFoundException if {@code file} does not exist.
     */
    public _FileInputStream(File file) throws FileNotFoundException
    {
        fis = new java.io.FileInputStream(file);
    }

    public int read() throws IOException
    {
        return fis.read();
    }

    /**
     * Returns a read-only {@link FileChannel} that shares its position with
     * this stream.
     */
    public FileChannel getChannel()
    {
        return fis.getChannel();
    }

    /**
     * Returns the underlying file descriptor.
     */
    public final FileDescriptor getFD() throws IOException
    {
        return fis.getFD();
    }

    /**
     * Reads at most {@code length} bytes from this stream and stores them in
     * the byte array {@code b} starting at {@code offset}.
     *
     * @param buffer the byte array in which to store the bytes read.
     * @param byteOffset the initial position in {@code buffer} to store the bytes read
     * from this stream.
     * @param byteCount the maximum number of bytes to store in {@code b}.
     * @return the number of bytes actually read or -1 if the end of the stream
     *         has been reached.
     *
     * @throws IndexOutOfBoundsException if {@code offset < 0} or {@code length < 0}, or if
     * {@code offset + length} is greater than the length of
     * {@code b}.
     * @throws IOException if the stream is closed or another IOException occurs.
     */
    @Override
    public int read(byte[] buffer, int byteOffset, int byteCount) throws IOException
    {
        return fis.read(buffer, byteOffset, byteCount);
    }

    /**
     * Skips at most {@code n} bytes in this stream. This method does nothing and returns
     * 0 if {@code n} is negative, but some subclasses may throw.
     *
     * <p>Note the "at most" in the description of this method: this method may choose to skip
     * fewer bytes than requested. Callers should <i>always</i> check the return value.
     *
     * <p>This default implementation reads bytes into a temporary
     * buffer. Concrete subclasses should provide their own implementation.
     *
     * @param byteCount the number of bytes to skip.
     * @return the number of bytes actually skipped.
     *
     * @throws IOException if this stream is closed or another IOException occurs.
     */
    @Override
    public long skip(long byteCount) throws IOException
    {
        return fis.skip(byteCount);
    }

    /**
     * Indicates whether this stream supports the {@code mark()} and
     * {@code reset()} methods. The default implementation returns {@code false}.
     *
     * @return always {@code false}.
     *
     * @see #mark(int)
     * @see #reset()
     */
    @Override
    public boolean markSupported()
    {
        return fis.markSupported();
    }

    /**
     * Returns an estimated number of bytes that can be read or skipped without blocking for more
     * input.
     *
     * <p>Note that this method provides such a weak guarantee that it is not very useful in
     * practice.
     *
     * <p>Firstly, the guarantee is "without blocking for more input" rather than "without
     * blocking": a read may still block waiting for I/O to complete&nbsp;&mdash; the guarantee is
     * merely that it won't have to wait indefinitely for data to be written. The result of this
     * method should not be used as a license to do I/O on a thread that shouldn't be blocked.
     *
     * <p>Secondly, the result is a
     * conservative estimate and may be significantly smaller than the actual number of bytes
     * available. In particular, an implementation that always returns 0 would be correct.
     * In general, callers should only use this method if they'd be satisfied with
     * treating the result as a boolean yes or no answer to the question "is there definitely
     * data ready?".
     *
     * <p>Thirdly, the fact that a given number of bytes is "available" does not guarantee that a
     * read or skip will actually read or skip that many bytes: they may read or skip fewer.
     *
     * <p>It is particularly important to realize that you <i>must not</i> use this method to
     * size a container and assume that you can read the entirety of the stream without needing
     * to resize the container. Such callers should probably write everything they read to a
     * {@link ByteArrayOutputStream} and convert that to a byte array. Alternatively, if you're
     * reading from a file, {@link File#length} returns the current length of the file (though
     * assuming the file's length can't change may be incorrect, reading a file is inherently
     * racy).
     *
     * <p>The default implementation of this method in {@code InputStream} always returns 0.
     * Subclasses should override this method if they are able to indicate the number of bytes
     * available.
     *
     * @return the estimated number of bytes available
     *
     * @throws IOException if this stream is closed or an error occurs
     */
    @Override
    public int available() throws IOException
    {
        return fis.available();
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
        Log.d("_FileInputStream", "instream closed");
        fis.close();
    }
}