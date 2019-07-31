package toolee.tools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import toolee.tools.Enums.Category;

@SpringBootApplication
public class ToolsApplication {

	public static void main(String[] args) {

		SpringApplication.run(ToolsApplication.class, args);
		System.out.println("http://localhost:5000/login");
		for (Category categories : Category.values()) {
			System.out.println(categories.getCategoryName());
		}
	}



}
