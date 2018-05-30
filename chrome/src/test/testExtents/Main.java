package test.testExtents;


public class Main {

	public static void main(String[] args) {

		try {
			TheMammals mammals = new TheMammals();
			mammals.getMammalsFild();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
