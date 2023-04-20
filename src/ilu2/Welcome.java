package ilu2;

public class Welcome {

	public String welcome(String input) {
		StringBuilder reponse = new StringBuilder("Hello, ");
		if (input == null || input.trim().isEmpty())
			reponse = this.casNull(input);
		return reponse.toString();
		if (input.equals(input.toUpperCase()))
			return casUpperCase(input);
		return casBase(input);
	}

	private StringBuilder casNull(String input) {
		reponse.append("my friend");
		return reponse.toString();
	}

	private String casUpperCase(String input) {
		reponse.append(input);
		reponse.append("!");
		return reponse.toString();
	}

	private String casBase(String input) {
		reponse.append(input.substring(0, 1).toUpperCase());
		reponse.append(input.substring(1));
		return reponse.toString();
	}

}
