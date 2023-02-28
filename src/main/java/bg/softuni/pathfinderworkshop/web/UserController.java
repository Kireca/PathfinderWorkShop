package bg.softuni.pathfinderworkshop.web;

import bg.softuni.pathfinderworkshop.models.binding.UserLoginDTO;
import bg.softuni.pathfinderworkshop.models.binding.UserRegisterDTO;
import bg.softuni.pathfinderworkshop.models.service.UserServiceDTO;
import bg.softuni.pathfinderworkshop.models.view.UserViewModel;
import bg.softuni.pathfinderworkshop.repositories.UserRepository;
import bg.softuni.pathfinderworkshop.services.UserService;
import bg.softuni.pathfinderworkshop.utils.CurrentUser;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserController {


    private final UserService userService;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;

    public UserController(UserService userService, ModelMapper modelMapper,
                          UserRepository userRepository) {
        this.userService = userService;
        this.modelMapper = modelMapper;
        this.userRepository = userRepository;
    }

    @ModelAttribute
    public UserRegisterDTO userRegisterDTO() {
        return new UserRegisterDTO();
    }

    @ModelAttribute
    public UserLoginDTO userLoginDTO() {
        return new UserLoginDTO();
    }

    @GetMapping("/register")
    public String register(Model model) {
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid UserRegisterDTO userRegisterDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors() || !userRegisterDTO.getPassword().equals(userRegisterDTO.getConfirmPassword())) {

            redirectAttributes.addFlashAttribute("userRegisterDTO", userRegisterDTO);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRegisterDTO", bindingResult);

            return "redirect:/users/register";
        }

        boolean isNameExists = userRepository.findByUsername(userRegisterDTO.getUsername()).isPresent();


        if (isNameExists) {
            //TODO... redirect with message
        }

        userService.registerUser(modelMapper
                .map(userRegisterDTO, UserServiceDTO.class));


        return "redirect:/users/login";
    }


    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("isNotExists", false);
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid UserLoginDTO userLoginDTO, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userLoginDTO", userLoginDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult,userLoginDTO", bindingResult);

            return "redirect:/users/login";
        }

        UserServiceDTO user = userService
                .findUserByUsernameAndPassword(userLoginDTO.getUsername(), userLoginDTO.getPassword());

        if (user == null) {

            redirectAttributes
                    .addFlashAttribute("doNotExists", true)
                    .addFlashAttribute("userLoginDTO", userLoginDTO)
                    .addFlashAttribute("org.springframework.validation.BindingResult,userLoginDTO", bindingResult);

            return "redirect:/users/login";

        }

        userService.loginUser(user.getId(), user.getUsername());

        return "redirect:/";

    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @GetMapping("/profile/{id}")
    private String profile(@PathVariable Long id, Model model) {
        model.addAttribute("user", modelMapper
                .map(userService.findById(id), UserViewModel.class));

        return "profile";
    }


}
