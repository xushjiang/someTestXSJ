package operation.model.factoryModel;

import org.springframework.context.annotation.Bean;

/**
 * 工厂，根据需要创建不同的实例
 * 
 * @author xushjiang
 *
 */
public class AnimalFactory {

	@Bean(name = "animalName")
	public static Animal getAnimalName(String name) {

		if (name.equals("cat")) {
			return new AnimalImpl2();
		} else if (name.equals("dog")) {
			return new AnimalImpl();
		} else {
			return new AnimalImpl3();
		}
	}
}
