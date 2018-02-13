public class ReverseString {

	public static String linReverse(String input) {
		String retStr = "";

		for (int i = 0; i < input.length(); i++) {
			retStr += input.substring(input.length() - i - 1, input.length() - i);
		}
		return retStr;
	}

	public static String logReverse(String input) {
		if (input.length() <= 1) {
			return input;
		} else {
			String firstHalf = "";
			String secondHalf = "";
			
			for (int i = 0; i < input.length() - 1; i++) {
				if (i <  input.length() / 2) 
					firstHalf += input.substring(i, i + 1);
				else
					secondHalf += input.substring(i, i + 1);
			}
			
		}
	}

	public static void main (String[] args) {
		System.out.println("stressed");
		System.out.println("=======LINEAR REVERSAL======");
		System.out.println(linReverse("stressed"));
		
		
	}
}
