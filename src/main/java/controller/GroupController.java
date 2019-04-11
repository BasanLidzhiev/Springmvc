package controller;

import entity.SGroup;
import exceptions.SGroupException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import service.interfaces.ISGroupService;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Controller
@RequestMapping("/sgroup")
public class GroupController {
    @Autowired
    ISGroupService service;

    public void setService(ISGroupService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String get(Model model){
        List<SGroup> list = service.get();
        if (list == null){
            model.addAttribute("success", false);
            model.addAttribute("message", "Ñïèñîê êàòåãîðèé ïóñò");
            return "/sgroup/index";
        }
        model.addAttribute("sgroups", list);
        model.addAttribute("success", true);
        return "/sgroup/index";
    }

    @GetMapping("/add")
    public String view(Model model){
        model.addAttribute("sgroup", new SGroup());
        model.addAttribute("action", "insert");
        return "/sgroup/add";
    }

    @GetMapping("/edit/{id}")
    public String view(@PathVariable int id, Model model){

        SGroup sGroup = service.get(id);
        if (sGroup != null){
            model.addAttribute("success", true);
            model.addAttribute("action", "/sgroup/update");
            model.addAttribute("sgroup", sGroup);
            return "/sgroup/add";
        }
        model.addAttribute("success", false);
        model.addAttribute("message", "Êàòåãîðèÿ íå íàéäåíà");
        return "/sgroup/add";

    }

    @PostMapping(value = "/update")
    public RedirectView update(@ModelAttribute(value = "sGroup") SGroup sGroup, RedirectAttributes attributes){
        try {
            service.update(sGroup);
        } catch (SGroupException ex) {
            attributes.addFlashAttribute("success", false);
            attributes.addFlashAttribute("message", ex.getMessage());

        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/sgroup/");
    }

    @PostMapping(value = "/insert")
    public String insert(@ModelAttribute(value = "sgroup") SGroup sGroup, Model model){
        List<SGroup> list = null;
        try {
            service.insert(sGroup);
            list = service.get();
            if (list == null){
                model.addAttribute("success", false);
                model.addAttribute("message", "Ñïèñîê êàòåãîðèé ïóñò");
                return "/sgroup/index";
            }

        } catch (SGroupException ex) {
            Logger.getLogger(GroupController.class.getName()).log(Level.SEVERE, null, ex);
        }
        model.addAttribute("sgroups", list);
        model.addAttribute("success", true);
        return "/sgroup/index";
    }

    @GetMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable int id, RedirectAttributes attributes){
        try {
            service.delete(id);
        } catch (SGroupException ex) {
            attributes.addFlashAttribute("success", false);
            attributes.addFlashAttribute("message", ex.getMessage());

        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/sgroup/");
    }

}
