package toolee.tools.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import toolee.tools.Config.S3Client;
import toolee.tools.Enums.Category;
import toolee.tools.Enums.Status;

import toolee.tools.Models.AppUser;
import toolee.tools.Models.Tool;
import toolee.tools.Repositories.ToolRepository;
import toolee.tools.Repositories.UserRepository;

import java.io.IOException;
import java.security.Principal;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ToolController {
    @Autowired
    ToolRepository toolRepository;
    @Autowired
    UserRepository userRepository;

    private S3Client s3Client;

    @Autowired
    ToolController(S3Client s3Client){this.s3Client = s3Client;}

    @CrossOrigin
    @PostMapping("/tool/add")
    public RedirectView addTool(@RequestParam String name, @RequestPart(value = "file")MultipartFile file, @RequestParam String price,

                                @RequestParam String status, @RequestParam String description, @RequestParam String category, Principal p) throws IOException {
        String imageUrl = this.s3Client.uploadFile(file);
        AppUser user = userRepository.findByUsername(p.getName());
        category = getEnumName(category);
        Tool newTool = new Tool(name, imageUrl, Double.parseDouble(price), Status.valueOf(status), description, Category.valueOf(category),user);

        userRepository.save(user);
        toolRepository.save(newTool);

        return new RedirectView("/profile");
    }

    @CrossOrigin
    @GetMapping("/tool/{id}/edit")
    public String editAccount(@PathVariable long id, Model m, Principal p){
        //get the information for the selected account
        List<String> accountType = new ArrayList<>();
        Tool tool = toolRepository.findById(id).get();
        AppUser user = userRepository.findByUsername(p.getName());
        Status[] statuses = Status.values();
        Category[] categories = Category.values();
        m.addAttribute("status", statuses);
        m.addAttribute("categories", categories);
        m.addAttribute("principal", user);
        m.addAttribute("editTool", tool);
        //TO DO: need to create categories and cities
        return "editTool";
    }

    @PostMapping("/tool/{id}/edit")
    public RedirectView editAccount(@RequestParam Long id, @RequestParam String name, @RequestPart(value = "file")MultipartFile file, @RequestParam String price,

    @RequestParam String status, @RequestParam String description, @RequestParam String category, Principal p, Model m) throws IOException {
        String imageUrl;
        AppUser user = userRepository.findByUsername(p.getName());
        Tool editTool = toolRepository.findById(id).get();

        if(!file.isEmpty()){
            imageUrl = this.s3Client.uploadFile(file);
            editTool.setImageUrl(imageUrl);
        }
        editTool.setName(name);
        editTool.setPrice(Double.parseDouble(price));
        editTool.setStatus(Status.valueOf(status));
        category = getEnumName(category);
        editTool.setCategory(Category.valueOf(category));
        editTool.setDescription(description);
        toolRepository.save(editTool);

        String message = "Successfully edited the tool: "+ name;
        Status[] statuses = Status.values();
        Category[] categories = Category.values();
        m.addAttribute("status", statuses);
        m.addAttribute("categories", categories);
        m.addAttribute("principal", user);
        m.addAttribute("message",message);

        return new RedirectView("/profile");

    }

    @GetMapping("/tool/{id}/delete")
    public String deleteTool(@PathVariable long id, Model m, Principal p){
        //get the information for the selected account
        List<String> accountType = new ArrayList<>();
        Tool tool = toolRepository.findById(id).get();
        AppUser user = userRepository.findByUsername(p.getName());
        m.addAttribute("principal", user);
        m.addAttribute("delTool", tool);
        return "deleteTool";
    }
    @PostMapping("/tool/{id}/delete")
    public RedirectView deleteTool(@RequestParam long id, Model m, Principal p,Integer temp){

        // to display information of selected account to be deleted
        Tool tool = toolRepository.findById(id).get();
        AppUser user = userRepository.findByUsername(p.getName());
        String message = "Successfully deleted the tool: "+ tool.getName();
        toolRepository.delete(tool);

        Status[] statuses = Status.values();
        Category[] categories = Category.values();
        m.addAttribute("status", statuses);
        m.addAttribute("categories", categories);
        m.addAttribute("principal",user);
        m.addAttribute("message",message);

        return new RedirectView("/profile");
    }


    //Helper method to change string back to enum:
    public String getEnumName(String userInput){
        if (userInput.equals("Home Improvement")) {
            return "HomeImprovement";
        }
        if (userInput.equals("Hand Tools")) {
            return "HandTools";
        }
        if (userInput.equals("Power Tools")) {
            return "PowerTools";
        }
        if (userInput.equals("Hardware")) {
            return "Hardware";
        }
        if (userInput.equals("Accessories")) {
            return "Accessories";
        }
        if (userInput.equals("Floor and Surface")) {
            return "FloorAndSurfaceCare";
        }
        if (userInput.equals("Measuring and Marking")) {
            return "MeasuringAndMarking";
        }
        if (userInput.equals("Plumbing")) {
            return "Plumbing";
        }
        if (userInput.equals("Lawn and Garden")) {
            return "LawnAndGarden";
        }
        if (userInput.equals("Miscellaneous")) {
            return "Miscellaneous";
        }
        else return null;
    }

}
