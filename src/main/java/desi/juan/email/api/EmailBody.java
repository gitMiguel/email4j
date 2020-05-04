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

import java.nio.charset.Charset;

import static desi.juan.email.api.EmailConstants.DEFAULT_CONTENT_TYPE;

/**
 * Represents and enables the construction of the content of an email.
 *
 * @see EmailData
 */
public class EmailBody extends EmailData {

	/**
	 * @return the body content of the {@link Email} as a {@link String} value.
	 */
	@Override
	public String getContent() {
		return (String) super.getContent();
	}

	/**
	 * @param content
	 * @param charset
	 * @param format
	 */
	public EmailBody(final String content, final Charset charset, final String format) {
		super(content, charset, format);
	}

	/**
	 * @param content
	 * @param contentType
	 */
	public EmailBody(final String content, final String contentType) {
		super(content, contentType);
	}

	/**
	 * Body with DEFAULT_CONTENT_TYPE.
	 *
	 * @see #EmailBody(String, String)
	 */
	public EmailBody(final String content) {
		super(content, DEFAULT_CONTENT_TYPE);
	}

	/**
	 * Empty body with DEFAULT_CONTENT_TYPE.
	 *
	 * @see #EmailBody(String)
	 */
	public EmailBody() {
		this("");
	}
}
