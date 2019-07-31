package toolee.tools.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import toolee.tools.Models.AppUser;
import toolee.tools.Repositories.UserRepository;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@Controller
public class HomeController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

     public String[] cities = {"Seattle", "Spokane","Tacoma", "Vancouver","Bellevue", "Kent", "Everett", "Renton", "Federal Way", "Kirkland",
           "Auburn", "Shoreline"};


    @GetMapping("/login")
    public String getLoginPage(Model m) {
        m.addAttribute("cities", cities);
        return "login";
    }

    @PostMapping(value = "/login")
    public RedirectView loginUsers(@RequestParam String username, String password, Model m, Principal principal) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(null, new ArrayList<>());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        m.addAttribute("principal", principal);
        return new RedirectView("profile");
    }

//     Testing main page on main route, modify as needed
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {
        return "home";
    }

    @GetMapping("/register")
    public String showRegistrationPage(Model m, Principal p, @RequestParam(required = false, defaultValue = "")String error){
        m.addAttribute("principal", p);
        m.addAttribute("cities", cities);
        m.addAttribute("error", "potato");
        return "register";
    }

    @PostMapping("/register")
    public String addNewUser(Model m, Principal p, String username, String password, String city, String phoneNumber, String email){
        if(!checkUserName(username)){
            AppUser newUser = new AppUser(username, passwordEncoder.encode(password), city, phoneNumber, email);
            userRepository.save(newUser);
            Authentication authentication = new UsernamePasswordAuthenticationToken(newUser, null, new ArrayList<>());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            List<AppUser> users = (List) userRepository.findAll();
            return "redirect:/discover";
        }else{
            m.addAttribute("error", "notUnique");
            m.addAttribute("principal", p);
            return "register";
        }
    }

    @GetMapping("/aboutus")
    public String aboutUsHandler(){
        return "aboutUs";
    }


    //**************************************** Helper Functions **************************************

    public boolean checkUserName(String username){
        Iterable<AppUser> allUsers =  userRepository.findAll();
        List<String> allUsername = new ArrayList<>();

        for(AppUser appUser : allUsers){
            allUsername.add(appUser.getUsername());
        }

        if(allUsername.contains(username)){
            return true;
        }else{
            return false;
        }
    }

}
