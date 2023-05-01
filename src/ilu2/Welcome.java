package ilu2;

import java.util.ArrayList;

public class Welcome {
	
	
	public String welcome(String input) {
		StringBuilder reponse = new StringBuilder("Hello, ");
		if (input == null || input.trim().isEmpty()) {
			return casNull(reponse);
		}
		if (input.split(",").length>=2) {
			return casMultiple(input.split(","),reponse);
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
	
	private String casMultiple(String[] input, StringBuilder reponse) {
		ArrayList<String> majuscules = new ArrayList<String>();
		ArrayList<String> minuscules = new ArrayList<String>();
		for (int i = 0; i < input.length; i++) {
			if (!input[i].equals(input[i].toUpperCase())) {
				minuscules.add(input[i].trim());
			}
		}
		for (int i = 0; i < input.length; i++) {
			if (input[i].equals(input[i].toUpperCase())) {
				majuscules.add(input[i].trim());
			}
		}
		partieMinuscule(minuscules, reponse);
		partieMajuscule(majuscules, reponse);
		return reponse.toString();
	}
	
	private String partieMinuscule(ArrayList<String> minuscules, StringBuilder reponse) {
		for (int i = 0; i < minuscules.size()-1; i++) {
			casBase(minuscules.get(i), reponse);
			reponse.append(", ");
		}
		reponse.deleteCharAt(reponse.length()-2);
		reponse.append("and ");
		casBase(minuscules.get(minuscules.size()-1), reponse);
		return reponse.toString();
	}
	
	private String partieMajuscule(ArrayList<String> majuscules, StringBuilder reponse) {
		if (majuscules.isEmpty()) {
			return reponse.toString();
		}
		reponse.append(". AND HELLO, ");
		for (int i = 0; i < majuscules.size()-1; i++) {
			reponse.append(majuscules.get(i).toUpperCase());
			reponse.append(", ");
		}
		reponse.deleteCharAt(reponse.length()-2);
		reponse.append("AND ");
		reponse.append(majuscules.get(majuscules.size()-1).toUpperCase());
		reponse.append("!");
		return reponse.toString();
	}
}
