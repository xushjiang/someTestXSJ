package test.testExtents;

public class TheMammals extends TheAnimal {

	private String MAMMALS_FILD = "viviparity";

	public void getMammalsFild() throws Exception {

		this.getFild();
		this.getAnimalFild();
		System.err.println(MAMMALS_FILD);
	}

	@Override
	public void getFild() throws Exception {

		System.err.println("=====");
	}

}
