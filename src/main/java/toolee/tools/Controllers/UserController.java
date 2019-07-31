package toolee.tools.Controllers;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import org.hibernate.annotations.GeneratorType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.view.RedirectView;
import toolee.tools.Enums.Category;
import toolee.tools.Enums.Status;
import toolee.tools.Models.AppUser;
import toolee.tools.Models.Tool;
import toolee.tools.Repositories.ToolRepository;
import toolee.tools.Repositories.UserRepository;
import java.security.Principal;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ToolRepository toolRepository;

    @Autowired
    PasswordEncoder passwordEncoder;



    @GetMapping("/profile")
    public String getProfile(@RequestParam (required = false, defaultValue = "")String error, Model m, Principal principal){
        AppUser user = userRepository.findByUsername(principal.getName());
        Status[] statuses = Status.values();
        Category[] categories = Category.values();
        m.addAttribute("status", statuses);
        m.addAttribute("categories", categories);
        m.addAttribute("principal", user);
        return "profile";
    }

    @GetMapping("/discover")
    public String getToolsForprincipalCity(Model m, Principal p){
        AppUser loggedInUser = userRepository.findByUsername(p.getName());
        String userCity = loggedInUser.getCity();
        List<AppUser> usersInCity = userRepository.findByCity(userCity);
        List<Tool> toolsInCity = new ArrayList<>();

        for(AppUser user: usersInCity){
            for(Tool tool: user.getTools()){
                toolsInCity.add(tool);
            }
        }

        m.addAttribute("toolsInCity", toolsInCity);
        m.addAttribute("principal", p);

        return "discover";
    }
    /*
    Testing to implement ajax feature: search based on categories
     */
    @GetMapping("/diss")
    public String testing(Model m, Principal p){
        AppUser loggedInUser = userRepository.findByUsername(p.getName());
        List<AppUser> usersInCity = userRepository.findByCity(loggedInUser.getCity());
        List<Tool> toolsInCity = new ArrayList<>();

        for(AppUser user: usersInCity){
            if(!user.getUsername().equals(loggedInUser.getUsername())){
                for(Tool tool: user.getTools()){
                    toolsInCity.add(tool);
                }
            }
        }

        m.addAttribute("toolsInCity", toolsInCity);
        m.addAttribute("principle", loggedInUser);
        /*
        Add following for ajax search feature
         */
        Category[] categories = Category.values();
        m.addAttribute("categories",categories);
        return "dis";
    }

    @GetMapping("/contact/seller/{toolId}/")
    public String contactToolSeller(@PathVariable long sellerId, @PathVariable long toolId, Principal p, Model m){
        AppUser loggedInUser = userRepository.findByUsername(p.getName());
        Tool selectedTool = toolRepository.findById(toolId).get();
        m.addAttribute("tool",selectedTool);
        m.addAttribute("principle",loggedInUser);
        return "contactSeller";
    }



    @PostMapping("/contact/seller/{toolId}")
    public String contactToolSeller(@PathVariable Long toolId, @RequestParam String message, Model m, Principal p){
        Tool tool = toolRepository.findById(toolId).get();
        AppUser seller = tool.getAppUser();
        AppUser buyer = userRepository.findByUsername(p.getName());
        configureMessage(seller, buyer, tool, message);

        return "redirect:/discover";
    }

    //********************************************************************* Helper Functions ******************************************************************

    //SNS function to help me send messages to a person once a task has been assigned
    public static void configureMessage(AppUser seller, AppUser buyer, Tool tool, String message) {
        AmazonSNSClient snsClient = new AmazonSNSClient();
        message = "Hello " +  seller.getUsername() + ", " + buyer.getUsername() + " is making an inquiry about your " + tool.getName()
                + " with ID: " + tool.getId() + ". Please contact them at their phone number " + buyer.getPhoneNumber() + " or email address "
                + buyer.getEmail() + " to further discuss this product.";
        Map<String, MessageAttributeValue> smsAttributes =
                new HashMap<>();
        //<set SMS attributes>
        sendSMSMessage(snsClient, message, seller.getPhoneNumber(), smsAttributes);
    }

    public static void sendSMSMessage(AmazonSNSClient snsClient, String message,
                                      String phoneNumber, Map<String, MessageAttributeValue> smsAttributes) {
        PublishResult result = snsClient.publish(new PublishRequest()
                .withMessage(message)
                .withPhoneNumber(phoneNumber)
                .withMessageAttributes(smsAttributes));
        System.out.println(result); // Prints the message ID.
    }
}
