package toolee.tools.Models;

import org.junit.Test;

import static org.junit.Assert.*;

public class AppUserTest {


    @Test
    public void getUsername() {
        AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
        assertTrue(appUser.getUsername().equals("user1"));

    }

    @Test
    public void setUsername() {


            AppUser appuser = new AppUser();
            appuser.setUsername("name");
            String result = appuser.getUsername();

            assertEquals("name", result);

    }

    @Test
    public void getPassword() {
        AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
        assertTrue(appUser.getPassword().equals("asdfgh"));

    }

    @Test
    public void setPassword() {
        AppUser appuser = new AppUser();
        appuser.setPassword("name");
        String result = appuser.getPassword();

        assertEquals("name", result);

    }

    @Test
    public void getCity() {
        AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
        assertTrue(appUser.getCity().equals("Spanaway"));
    }

    @Test
    public void setCity() {
        AppUser appuser = new AppUser();
        appuser.setCity("Kirkland");
        String result = appuser.getCity();

        assertEquals("Kirkland", result);
    }

    @Test
    public void getPhoneNumber() {
        AppUser appUser = new AppUser("user1", "asdfgh","Spanaway","3607774555","youwish@donttryit");
        assertTrue(appUser.getPhoneNumber().equals("3607774555"));
    }

    @Test
    public void setPhoneNumber() {
        AppUser appuser = new AppUser();
        appuser.setPhoneNumber("218777");
        String result = appuser.getPhoneNumber();

        assertEquals("218777", result);
    }

    @Test
    public void getEmail() {
        AppUser appUser = new AppUser("user1", "asdfgh", "Spanaway", "3607774555", "youwish@donttryit");
        assertTrue(appUser.getEmail().equals("youwish@donttryit"));
    }
    @Test
    public void setEmail() {
        AppUser appuser = new AppUser();
        appuser.setEmail("name@gmail");
        String result = appuser.getEmail();

        assertEquals("name@gmail", result);
    }

}