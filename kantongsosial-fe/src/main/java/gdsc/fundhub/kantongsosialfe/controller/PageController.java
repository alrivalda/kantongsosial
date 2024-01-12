package gdsc.fundhub.kantongsosialfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import gdsc.fundhub.kantongsosialfe.dto.request.LoginDTO;
import gdsc.fundhub.kantongsosialfe.restservice.UserRestService;
import gdsc.fundhub.kantongsosialfe.security.jwt.JwtUtils;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import gdsc.fundhub.kantongsosialfe.security.jwt.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@Controller
public class PageController {
    
    @Autowired
    UserRestService userRestService;

    
    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/")
    public String landingPage(Model model) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        var username = auth.getPrincipal().toString();
        var login = false;
        if(username == "anonymousUser") {
            model.addAttribute("login", login);
            System.out.println("Not Loigin");
            return "home.html";
        } else  {
            login = true;
            model.addAttribute("login", login);
            model.addAttribute("username", username);
            System.out.println(username);
            return "home.html";
        }
        
    }

    @GetMapping("/login")
    public String login (Model model) {
        var loginDTO = new LoginDTO();
        model.addAttribute("loginDTO", loginDTO);
        System.out.println("a");
        return "login.html";
    }

    @PostMapping("/login")
    public ModelAndView postLogin(@Valid @ModelAttribute LoginDTO loginDTO,  HttpServletRequest request) {
        //TODO: process POST request
        System.out.println("ini");
        var response = userRestService.Login(loginDTO);
        String username = jwtUtils.getUserNameFromJwtToken(response.getToken());
        Authentication authentication = new UsernamePasswordAuthenticationToken(username, "User", null);
        SecurityContext securityContext = SecurityContextHolder.getContext();
        securityContext.setAuthentication(authentication);
        HttpSession httpSession = request.getSession(true);
        httpSession.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY, securityContext);
        httpSession.setAttribute("token", response.getToken());
        System.out.println(username);
        return new ModelAndView("redirect:/");
    }
    

    @GetMapping("/register")
    public String register(Model model) {
        return "register.html";
    }
}