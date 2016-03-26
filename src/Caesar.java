
public class Caesar {
	public String encrypt(String planText, int shift) {
		String cipherText = "";

		for (int i = 0; i < planText.length(); i++) {
			char alphabet = planText.charAt(i);

			if (alphabet >= 'A' && alphabet <= 'Z') {
				alphabet += shift;
				if (alphabet > 'Z') {
					alphabet = (char) ((alphabet % 'Z') + ('A' - 1));
				}
				cipherText += String.valueOf(alphabet);
			} else if (alphabet >= 'a' && alphabet <= 'z') {
				alphabet += shift;
				if (alphabet > 'z') {
					alphabet = (char) ((alphabet % 'z') + ('a' - 1));
				}
				cipherText += String.valueOf(alphabet);
			} else {
				cipherText += String.valueOf(alphabet);
			}
		}

		return cipherText;
	}

	public String decrypt(String cipherText, int shift) {
		String planText = "";
		for (int i = 0; i < cipherText.length(); i++) {
			char alphabet = cipherText.charAt(i);

			if (alphabet >= 'A' && alphabet <= 'Z') {
				alphabet -= shift;
				if (alphabet < 'A') {
					alphabet = (char) (alphabet + 26);
				}
				planText += String.valueOf(alphabet);
			} else if (alphabet >= 'a' && alphabet <= 'z') {
				alphabet -= shift;
				if (alphabet < 'a') {
					alphabet = (char) (alphabet + 26);
				}
				planText += String.valueOf(alphabet);
			} else {
				planText += String.valueOf(alphabet);
			}
		}

		return planText;
	}

	public static void main(String[] args) {
		Caesar c = new Caesar();
		System.out.println(c.encrypt("originalsource", 5));
		System.out.println(c.decrypt("[Djfw tk Mtwtw]444446565", 5));

	}
}
