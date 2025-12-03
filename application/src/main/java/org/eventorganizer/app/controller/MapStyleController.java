package org.eventorganizer.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@RestController
@RequestMapping("mapstyle")
public class MapStyleController {

    @GetMapping("libertydark")
    public String getLibertdarkStyle(){
        Path path = Path.of("web/frontend/libertydark.json");
        try {
            return Files.readString(path);
        } catch (IOException e) {
            System.out.println("Could not load libertydark file!");
            throw new RuntimeException(e);
        }
    }
}
