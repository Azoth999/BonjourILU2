package ilu2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WelcomeTest {
	Welcome bonjour;
	@BeforeEach
	void initialisation() {
		bonjour = new Welcome();
	}
	
	@Test
	void ex_1() {
		assertEquals(bonjour.welcome("bob"), "Hello, Bob");
	}

	@Test
	void ex_2() {
		assertEquals("Hello, my friend", bonjour.welcome(null));
		assertEquals("Hello, my friend", bonjour.welcome("  "));
	}

	@Test
	void ex_3() {
		assertEquals("HELLO, JERRY!", bonjour.welcome("JERRY"));
	}

	@Test
	void ex_4() {
		assertEquals("Hello, Amy, Bob", bonjour.welcome("amy,bob"));
	}
	
	@Test
	void ex_5() {
		assertEquals("Hello, Amy, Bob, Francis", bonjour.welcome("amy,bob,francis"));
	}

}
