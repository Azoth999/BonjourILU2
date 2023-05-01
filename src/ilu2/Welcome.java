package ilu2;

public class Welcome {
	
	
	public String welcome(String input) {
		StringBuilder reponse = new StringBuilder("Hello, ");
		if (input == null || input.trim().isEmpty()) {
			return casNull(reponse).toString();
		}
		if (input.split(",").length==2) {
			return casDouble(input.split(","),reponse).toString();
		}
		if (input.equals(input.toUpperCase()))
			return casUpperCase(input,reponse);
		return casBase(input,reponse);
	}

	private String casNull(StringBuilder reponse) {
		reponse.append("my friend");
		return reponse.toString();
	}

	private String casUpperCase(String input, StringBuilder reponse) {
		reponse.append(input);
		reponse.append("!");
		return reponse.toString().toUpperCase();
	}

	private String casBase(String input, StringBuilder reponse) {
		reponse.append(input.substring(0, 1).toUpperCase());
		reponse.append(input.substring(1));
		return reponse.toString();
	}
	
	private String casDouble(String[] input, StringBuilder reponse) {
		casBase(input[0], reponse);
		reponse.append(", ");
		casBase(input[1], reponse);
		return reponse.toString();
	}
}
