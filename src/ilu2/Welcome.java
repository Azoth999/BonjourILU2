package ilu2;

public class Welcome {

	public static String welcome(String input) {
		StringBuilder reponse = new StringBuilder("Hello, ");
		if (input == null || input.trim().isEmpty()) {
			reponse.append("my friend");
			return reponse.toString();
		}
		reponse.append(input.substring(0, 1).toUpperCase());
		reponse.append(input.substring(1));
		return reponse.toString();
	}

}
