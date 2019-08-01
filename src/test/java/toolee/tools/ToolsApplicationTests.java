package toolee.tools;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import toolee.tools.Enums.Category;
import toolee.tools.Enums.Status;
import toolee.tools.Models.AppUser;
import toolee.tools.Models.Tool;

import static org.junit.Assert.assertEquals;
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

		Tool tool = new Tool();
		tool.setName("name");
		String result = tool.getName();

		assertEquals("name", result);
	}

	@Test
	public void getImageUrl() {
		AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
		Tool tool = new Tool("hammer","hammer.jpg",8.99, Status.Rented ,"nice and handy", Category.HandTools,appUser);
		assertTrue(tool.getImageUrl().equals("hammer.jpg"));
	}

	@Test
	public void setImageUrl() {
		Tool tool = new Tool();
		tool.setImageUrl("name");
		String result = tool.getImageUrl();

		assertEquals("name", result);

	}

	@Test
	public void getPrice() {
		AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
		Tool tool = new Tool("hammer","hammer.jpg",10.99, Status.Rented ,"nice and handy", Category.HandTools,appUser);
		assertTrue(tool.getPrice()==10.99);
	}

	@Test
	public void setPrice() {
		Tool tool = new Tool();
		tool.setPrice(10.99);
		double result = tool.getPrice();

		assertEquals(10.99, result,0);

	}

	@Test
	public void getStatus() {
		AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
		Tool tool = new Tool("hammer","hammer.jpg",8.99, Status.Rented ,"nice and handy", Category.HandTools,appUser);
		assertTrue(tool.getStatus()==Status.Rented);
	}

	@Test
	public void setStatus() {
		Tool tool = new Tool();
		tool.setStatus(Status.Rented);
		Status result = tool.getStatus();

		assertEquals(Status.Rented, result);
	}

	@Test
	public void getDescription() {
		AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
		Tool tool = new Tool("hammer","hammer.jpg",8.99, Status.Rented ,"nice and handy", Category.HandTools,appUser);
		assertTrue(tool.getDescription().equals("nice and handy"));
	}

	@Test
	public void setDescription() {
		Tool tool = new Tool();
		tool.setDescription("name");
		String result = tool.getDescription();

		assertEquals("name", result);
	}
	@Test
	public void getCategory() {
		AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
		Tool tool = new Tool("hammer","hammer.jpg",8.99, Status.Rented ,"nice and handy", Category.HandTools,appUser);
		assertTrue(tool.getCategory() == Category.HandTools);
	}

	@Test
	public void setCategory() {
		Tool tool = new Tool();
		tool.setCategory(Category.HandTools);
		Category result = tool.getCategory();

		assertEquals(Category.HandTools, result);
	}

	@Test
	public void getAppUser() {
		AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
		Tool tool = new Tool("hammer","hammer.jpg",8.99, Status.Rented ,"nice and handy", Category.HandTools,appUser);
		assertTrue(tool.getAppUser()== appUser);
	}
}

