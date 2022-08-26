package org.ms.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("msresource")
public class MSResourceController {

    @GetMapping
    public String getResource(){
        return "Resource server says Hi!!!";
    }
}
