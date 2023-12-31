package lab_6b;

import java.io.BufferedInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream{

	public LowerCaseInputStream(BufferedInputStream in) {
//		super(bufferedInputStream);
		super(in);
	}

	/*
	 * We should override the read method from FilterInputStream t 
	 * o take a byte and convert each byte (that represents a character) 
	 * to lowercase if it is an uppercase character.
	 */
	public int read() throws IOException {
		int c = super.read();
		return (c == -1 ? c : Character.toLowerCase((char) c));
	}

	public int read(byte[] b, int offset, int len) throws IOException {
		int res = super.read(b, offset, len);
		for (int i = offset; i < offset + res; i ++) {
			b[i] = (byte) Character.toLowerCase((char) b[i]);
		}

		return res;
	}
}
