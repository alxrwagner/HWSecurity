package skypro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerClass {

    @GetMapping("/")
    public String showEmployeeInfo() {
        return "publicRoom";
    }

    @GetMapping("/servers_room")
    public String showItInfo() {
        return "serversRoom";
    }

    @GetMapping("/security_room")

    public String showSecurityInfo() {
        return "securityRoom";
    }

    @GetMapping("/director_room")

    public String showDirectorInfo() {
        return "directorRoom";
    }
}
