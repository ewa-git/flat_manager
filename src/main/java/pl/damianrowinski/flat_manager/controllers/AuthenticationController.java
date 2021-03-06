package pl.damianrowinski.flat_manager.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.damianrowinski.flat_manager.model.dtos.UserAddDTO;
import pl.damianrowinski.flat_manager.services.AuthenticationService;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @GetMapping("/register")
    public String getRegistration(Model model) {
        model.addAttribute("userData", new UserAddDTO());
        return "/login/registration";
    }

    @PostMapping("/register")
    public String processRegistration(@ModelAttribute("userData") @Valid UserAddDTO userData, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "/login/registration";
        }
        authenticationService.register(userData);
        return "redirect:/";
    }

    @RequestMapping("/login")
    public String login() {
        return "/login/login";
    }

    @GetMapping("/logout-confirm")
    public String confirmLogout() {
        return "/login/logout-confirmation";
    }

}
