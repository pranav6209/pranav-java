package com.livecode.utill;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ISO8583CodecTest {

	
	@Test
	public void testDecode() {

		String input = "0100e016411111111111111112250000001000";
		ISO8583Codec iso8585Codec = new ISO8583Codec();

		iso8585Codec.decode(input);
		


	}

}
