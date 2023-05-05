package ilu2;

import java.util.ArrayList;
import java.util.HashMap;

public class Welcome {
	
	
	public String welcome(String input) {
		StringBuilder reponse = new StringBuilder("Hello, ");
		if (input == null || input.trim().isEmpty())
			return casNull(reponse);
		if (input.split(",").length>=2)
			return casMultiple(input.split(","),reponse);
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
		ArrayList<String> majuscules = new ArrayList<>();
		ArrayList<String> minuscules = new ArrayList<>();
		HashMap<String,Integer> noms = new HashMap<>();
		
		for (int i = 0; i < input.length; i++) {
			if(!noms.containsKey(input[i].trim())) {
				noms.put(input[i].trim(), 1);
				if (!input[i].equals(input[i].toUpperCase())) {
					minuscules.add(input[i].trim());
				}else {
					majuscules.add(input[i].trim());
				}
			}else {
				noms.put(input[i].trim(),noms.get(input[i].trim())+1);
			}
		}
		partieMinuscule(noms, minuscules, reponse);
		partieMajuscule(noms, majuscules, reponse);
		return reponse.toString();
	}
	
	private String partieMinuscule(HashMap<String,Integer> noms, ArrayList<String> minuscules, StringBuilder reponse) {
		if (minuscules.isEmpty()) {
			reponse.delete(0, reponse.length());
			return reponse.toString();
		}
		if(minuscules.size()>1) {
			for (int i = 0; i < minuscules.size()-1; i++) {
				casDoublons(minuscules.get(i), reponse, noms);
				reponse.append(", ");
			}
			reponse.deleteCharAt(reponse.length()-2);
			reponse.append("and ");
			casDoublons(minuscules.get(minuscules.size()-1), reponse, noms);
		}else {
			casDoublons(minuscules.get(0), reponse, noms);
		}
		return reponse.toString();
	}
	
	private String partieMajuscule(HashMap<String,Integer> noms, ArrayList<String> majuscules, StringBuilder reponse) {
		if (majuscules.isEmpty())
			return reponse.toString();
		if (noms.size() == majuscules.size())
			reponse.append("HELLO, ");
		else
			reponse.append(". AND HELLO, ");
		if(majuscules.size()>1) {
			for (int i = 0; i < majuscules.size()-1; i++) {
				casDoublons(majuscules.get(i), reponse, noms);
				reponse.append(", ");}
			reponse.deleteCharAt(reponse.length()-2);
			reponse.append("AND ");
			casDoublons(majuscules.get(majuscules.size()-1), reponse, noms);
			reponse.append("!");
			}else {
				casDoublons(majuscules.get(0), reponse, noms);
				reponse.append("!");
			}
		return reponse.toString();
	}
	
	private String casDoublons(String nom, StringBuilder reponse, HashMap<String,Integer> names) {
		if(names.get(nom)>1) {
			casBase(nom, reponse);
			return reponse.append(" (x"+names.get(nom).toString()+")").toString();
		}
		return casBase(nom, reponse);
	}
}
