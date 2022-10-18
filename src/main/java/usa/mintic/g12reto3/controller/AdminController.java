package usa.mintic.g12reto3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import usa.mintic.g12reto3.entities.Admin;
import usa.mintic.g12reto3.entities.Client;
import usa.mintic.g12reto3.servicie.AdminService;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")

public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll() {
        return adminService.getAll();
    }

    @PostMapping("/save")
    public Admin save(@RequestBody Admin c) {
        return adminService.save(c);
    }


}
