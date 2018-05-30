package test.testGenericity;


public class Main {

	public static Animal<Long> getAnimal() {

		Animal<Long> l = new Animal<>();

		return l;
	}

	public static Animal<Object> getDog() {

		Animal<Object> d = new Dog<>();

		return d;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
