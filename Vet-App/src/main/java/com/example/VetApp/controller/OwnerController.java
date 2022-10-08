package com.example.VetApp.controller;

import com.example.VetApp.entity.Owner;
import com.example.VetApp.entity.Pet;
import com.example.VetApp.service.OwnerService;
import com.example.VetApp.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class OwnerController {

    @Autowired
    private OwnerService service;

    @Autowired
    private PetService petService;

    @Autowired
    public OwnerController(OwnerService service, PetService petService) {
        this.service = service;
        this.petService = petService;
    }

    @RequestMapping("/owner")
    public String ownerHomePage(Owner owner, Model model, String keyword) {
        if (keyword != null) {
            List<Owner> owner_list = service.getByKeyword(keyword);
            model.addAttribute("owner_list", owner_list);
        } else {
            List<Owner> owner_list = service.getAllOwner();
            model.addAttribute("owner_list", owner_list);
        }
        return "owner";
    }

    @GetMapping("/add_owner")
    public String add_owner(Model model) {
        model.addAttribute("owner", new Owner());
        return "add_owner";
    }

    @RequestMapping(value = "/save-Owner", method = RequestMethod.POST)
    public String saveOwner(@ModelAttribute("owner") Owner owner) {
        service.save(owner);
        return "redirect:/owner";
    }

    @RequestMapping(value = "/o_edit/{id}", method = RequestMethod.GET)
    public ModelAndView showEditOwnerPage(@PathVariable(name = "id") long id) {
        ModelAndView mav = new ModelAndView("add_owner");
        Owner owner = service.get((int) id);
        mav.addObject("owner", owner);
        return mav;
    }

    @RequestMapping("/o_delete/{id}")
    public String delete_owner(@PathVariable(name = "id") int id, RedirectAttributes attributes) {
        service.delete(id);
        attributes.addFlashAttribute("success", "The owner has deleted !");
        return "owner";
    }

   @RequestMapping(value = "/detail/{id}",method = RequestMethod.GET)
   public String detail(@PathVariable Long id, Model model){
        Owner owner = service.get(id);
        model.addAttribute("owner",owner);
        List<Pet> pet_list =petService.getByOwnerId(id);
        model.addAttribute("pet_list",pet_list);
        return "detail";
   }
}
