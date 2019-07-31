package toolee.tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import toolee.tools.Enums.Category;
import toolee.tools.Enums.Status;
import toolee.tools.Models.AppUser;
import toolee.tools.Models.Tool;

import static org.junit.Assert.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ToolsApplicationTests {


	@Test
	public void getName() {
		AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
		assertTrue(appUser.getUsername().equals("user1"));
	}

	@Test
	public void setName() {
	}
	@Test
	public void getImageUrl() {
		AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
		Tool tool = new Tool("hammer","hammer.jpg",8.99, Status.Rented ,"nice and handy", Category.HandTools,appUser);
		assertTrue(tool.getImageUrl().equals("hammer.jpg"));
	}

	@Test
	public void setImageUrl() {
	}

	@Test
	public void getPrice() {
	}

	@Test
	public void setPrice() {
	}

	@Test
	public void getStatus() {
	}

	@Test
	public void setStatus() {
	}

	@Test
	public void getDescription() {
	}

	@Test
	public void setDescription() {
	}

	@Test
	public void getCategory() {
	}

	@Test
	public void setCategory() {
	}

	@Test
	public void getAppUser() {
	}

	@Test
	public void setAppUser() {
	}
}
