public class Test {
	public static void main(String[] args) {
		String foo = "abcdefghijklmnopqrstuvwxyz";
		String[] test = {"a","b","c","d"};
		for (String i : test) {
			System.out.println(test[i]);
		}
		for(String i: String foo) {
			System.out.println(i);
		}
	}
}
