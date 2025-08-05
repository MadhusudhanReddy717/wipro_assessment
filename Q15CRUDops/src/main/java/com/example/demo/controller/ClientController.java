package com.example.demo.controller;

import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;
    public ClientController(ClientService service) { this.service = service; }

    @GetMapping
    public String listClients(Model model) {
        model.addAttribute("clients", service.getAllClients());
        return "clients";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("client", new Client());
        return "client_form";
    }

    @PostMapping("/save")
    public String saveClient(@Valid @ModelAttribute("client") Client client, BindingResult br) {
        if (br.hasErrors()) return "client_form";
        service.saveClient(client);
        return "redirect:/clients";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Client c = service.getClient(id);
        model.addAttribute("client", c);
        return "client_form";
    }

    @GetMapping("/delete/{id}")
    public String deleteClient(@PathVariable Long id) {
        service.deleteClient(id);
        return "redirect:/clients";
    }
}
