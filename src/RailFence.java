import java.util.ArrayList;

public class RailFence {
	public String encrypt(String planText, int row) {
		planText = planText.toLowerCase();
		String cipherText = "";

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < planText.length(); j++) {
				if (j % row == i) {
					cipherText += planText.charAt(j);
				}
			}
		}
		return cipherText;
	}

	public String decrypt(String cipherText, int row) {
		String planText = "";
		int length = cipherText.length();

		ArrayList<String> eachCipher = new ArrayList<>();
		for (int i = 0; i < length; i++) {
			eachCipher.add(String.valueOf(cipherText.charAt(i)));
		}

		String rest = "";
		int numCol = length / row;
		int numRest = length % row;
		if (numRest != 0) {
			for (int i = numCol; numRest > 0; i += numCol) {
				rest += eachCipher.get(i);
				eachCipher.remove(i);
				numRest--;
			}
		}
		
		for (int i = numCol; i > 0 ; i--) {
			for (int j = 0; j < eachCipher.size() ; j++) {
				if(j % i == 0){
					planText += eachCipher.get(j);
					eachCipher.add(j, "0");
					eachCipher.remove(j + 1);
				}
			}
			for (int j = 0; j < eachCipher.size(); j++) {
				if(eachCipher.get(j).equals("0")){
					eachCipher.remove(j);
				}
			}
			
		}
		
		return planText + rest;
	}

	public static void main(String[] args) {
		RailFence r = new RailFence();
		System.out.println(r.encrypt("originalsource", 4));
		System.out.println(r.decrypt("oiscrnoeiauglr", 4));
		
		ArrayList<String> test = new ArrayList<>();
		test.add("a");
		test.add("b");
		test.add("c");
		test.add( 1, "0");
		System.out.println(test.toString());
	}
}
