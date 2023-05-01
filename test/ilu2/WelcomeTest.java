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
	
	@Test
	void ex_6() {
		assertEquals("Hello, Amy, Francis. AND HELLO, BOB!", bonjour.welcome("amy,BOB,francis"));
	}

	
	//Le "and" qui remplace la dernière virgule rend les tests 4, 5 et 6 obsolètes
	//et il n'y a pas de restriction de cas rendant nécessaire la création d'une nouvelle fonction.
	//Donc il me semble que cette réponse est suffisante dans ce cas là.
	@Test
	void ex_7() {
		assertEquals("Hello, Amy and Francis. AND HELLO, BILLY, ALFRED AND JACK!", bonjour.welcome("amy,BILLY,ALFRED,francis,JACK"));
	}
	
}
