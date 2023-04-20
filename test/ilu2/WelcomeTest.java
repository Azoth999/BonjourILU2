package ilu2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class WelcomeTest {

	@Test
	void ex_1() {
		assertEquals(Welcome.welcome("bob"), "Hello, Bob");
	}

	@Test
	void ex_2() {
		assertEquals("Hello, my friend", Welcome.welcome(null));
		assertEquals("Hello, my friend", Welcome.welcome("  "));
	}

}
