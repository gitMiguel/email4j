/**
 * The MIT License (MIT)
 *
 * Original work Copyright (c) 2016 Juan Desimoni
 * Modified work Copyright (c) 2017 yx91490
 * Modified work Copyright (c) 2017 Jonathan Hult
 * Modified work Copyright (c) 2020 Miika Jukka
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package desi.juan.email.api;

import javax.mail.internet.ContentType;
import java.nio.charset.Charset;

import static java.lang.String.format;

/**
 * Internal class which stores data for either an {@link EmailBody} or an
 * {@link EmailAttachment} with a specific charset and format.
 */
class EmailData {

    /**
     * Format of data. Example: "text/html" or "text/plain".
     */
    private final String format;

    /**
     * The charset the data.
     */
    private final Charset charset;

    /**
     * The content of either the data.
     */
    private Object content;

    /**
     * Creates a new instance of EmailBody.
     *
     * @param content
     * @param contentType
     * @see #EmailData(Object, ContentType)
     */
    EmailData(final Object content, final String contentType) {
        this(content, EmailTools.toContentType(contentType));
    }

    /**
     * Creates a new instance of EmailBody.
     *
     * @param content
     * @param contentType
     * @see #EmailData(Object, Charset, String)
     */
    private EmailData(final Object content, final ContentType contentType) {
        this(content, EmailTools.getCharset(contentType), EmailTools.getFormat(contentType));
    }

    /**
     * Creates a new instance of EmailBody.
     *
     * @param content
     * @param charset
     * @param emailFormat
     */
    EmailData(final Object content, final Charset charset, final String emailFormat) {
        if (content == null || emailFormat == null) {
            throw new IllegalArgumentException("No param can be null");
        }
        this.content = content;
        this.charset = charset;
        this.format = emailFormat.toLowerCase();
    }

    /**
     * @return format of data. Example: "text/html" or "text/plain".
     */
    public String getFormat() {
        return format;
    }

    /**
     * @return the charset of the data.
     */
    public Charset getCharset() {
        return charset;
    }

    /**
     * @return the content type of the data, includes email format and charset
     */
    public String getContentType() {
        if (charset == null) {
            return format;
        } else {
            return format("%s; charset=%s", format, charset);
        }
    }

    /**
     * @return the content the data.
     */
    public Object getContent() {
        return content;
    }
}
