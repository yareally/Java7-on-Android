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

public class _BufferedOutputStream implements java.lang.AutoCloseable, Flushable
{
    private BufferedOutputStream bos;

    /**
     * Constructs a new {@code BufferedOutputStream}, providing {@code out} with a buffer
     * of 8192 bytes.
     *
     * @param os the {@code OutputStream} the buffer writes to.
     */
    public _BufferedOutputStream(OutputStream os)
    {
        bos = new BufferedOutputStream(os);
    }

    /**
     * Constructs a new {@code BufferedOutputStream}, providing {@code out} with {@code size} bytes
     * of buffer.
     *
     * @param os the {@code OutputStream} the buffer writes to.
     * @param size the size of buffer in bytes.
     * @throws IllegalArgumentException if {@code size <= 0}.
     */
    public _BufferedOutputStream(OutputStream os, int size)
    {
        bos = new BufferedOutputStream(os, size);
    }

    public void write(int oneByte) throws IOException
    {
        bos.write(oneByte);
    }

    /**
     * Equivalent to {@code write(buffer, 0, buffer.length)}.
     */
    public void write(byte[] buffer) throws IOException
    {
        bos.write(buffer, 0, buffer.length);
    }

    /**
     * Writes {@code count} bytes from the byte array {@code buffer} starting at
     * position {@code offset} to this stream.
     *
     * @param buffer the buffer to be written.
     * @param offset the start position in {@code buffer} from where to get bytes.
     * @param count the number of bytes from {@code buffer} to write to this
     * stream.
     * @throws java.io.IOException if an error occurs while writing to this stream.
     * @throws IndexOutOfBoundsException if {@code offset < 0} or {@code count < 0}, or if
     * {@code offset + count} is bigger than the length of
     * {@code buffer}.
     */
    public void write(byte[] buffer, int offset, int count) throws IOException
    {
        bos.write(buffer, offset, count);
    }

    /**
     * Flushes this stream. Implementations of this method should ensure that
     * any buffered data is written out. This implementation does nothing.
     *
     * @throws java.io.IOException if an error occurs while flushing this stream.
     */
    @Override
    public void flush() throws IOException
    {
        bos.flush();
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
     * @throws java.io.IOException if this resource cannot be closed
     */
    @Override
    public void close() throws IOException
    {
        Log.d("_BufferedOutputStream", "Buffered outstream closed");
        bos.close();
    }
}