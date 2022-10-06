package com.example.VetApp.controller;

import com.example.VetApp.entity.Owner;
import com.example.VetApp.entity.Pet;
import com.example.VetApp.entity.User;
import com.example.VetApp.service.AuthenticationService;
import com.example.VetApp.service.OwnerService;
import com.example.VetApp.service.PetService;
import com.example.VetApp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PetController {

    @Autowired
    private PetService service;

    @Autowired
    private OwnerService ownerService;

    @Autowired
    public PetController(PetService service, OwnerService ownerService) {
        this.service = service;
        this.ownerService = ownerService;
    }


    @RequestMapping("/pet")
    public String home(Pet pet, Model model, String keyword) {
        if(keyword!=null) {
            List<Pet> pet_list = service.getByKeyword(keyword);
            model.addAttribute("pet_list", pet_list);
        }else {
            List<Pet> pet_list = service.getAllPet();
            model.addAttribute("pet_list", pet_list);}
        return "pet";
    }

    @GetMapping("/add_pet")
    public String add_pet(Model model) {
        model.addAttribute("pet", new Pet());
        return "add_pet";
    }

    @RequestMapping(value = "/save-pet", method = RequestMethod.POST)
    public String savePet(@ModelAttribute("pet") Pet pet) {
        service.save(pet);
        return "redirect:/pet";
    }
    /*@RequestMapping("/p_edit/{id}")
    public ModelAndView showEditPetPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("add_pet");
        Pet pet=service.get((int) id);
        mav.addObject("pet", pet);
        return mav;
    }*/
    @RequestMapping(value = "/p_edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditPetPage(@PathVariable(name = "id") long id){
        ModelAndView mav=new ModelAndView("add_pet");
        Pet pet=service.get((int) id);
        mav.addObject("pet",pet);
        return mav;
    }

    @RequestMapping("/p_delete/{id}")
    public String delete_pet(@PathVariable(name = "id") int id, RedirectAttributes attributes) {
        service.delete(id);
        attributes.addFlashAttribute("success","The pet has deleted !");
        return "pet";
    }
}
