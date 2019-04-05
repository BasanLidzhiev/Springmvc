package controller;

import entity.Student;
import exceptions.StudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import service.interfaces.ISGroupService;
import service.interfaces.IStudentService;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {

    @Autowired
    IStudentService service;

    @Autowired
    ISGroupService sGroupService;

    public void setsGroupService(ISGroupService sGroupService) {
        this.sGroupService = sGroupService;
    }

    public void setService(IStudentService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String students(Model model){
        List<Student> list = service.get();
        if (list == null){
            model.addAttribute("success", false);
            model.addAttribute("message", "Ñïèñîê ôèëüìîâ ïóñò");
            return "/student/index";
        }
        model.addAttribute("students", list);
        model.addAttribute("success", true);
        return "/student/index";
    }

    @GetMapping("/add")
    public String view(Model model){
        model.addAttribute("student", new Student());
        model.addAttribute("sgroups", sGroupService.get());
        model.addAttribute("action", "insert");
        return "/student/add";
    }

    @GetMapping("/edit/{id}")
    public String view(@PathVariable int id, Model model){

        Student student = service.get(id);
        if (student != null){
            model.addAttribute("success", true);
            model.addAttribute("action", "/student/update");
            model.addAttribute("student", student);
            model.addAttribute("sgroups", sGroupService.get());
            return "/student/add";
        }
        model.addAttribute("success", false);
        model.addAttribute("message", "Ôèëüì íå íàéäåí");
        return "/student/index";
    }

    @PostMapping(value = "/update")
    public RedirectView update(@ModelAttribute(value = "student") Student student, RedirectAttributes attributes){
        try {
            service.update(student);
        } catch (StudentException ex) {
            attributes.addFlashAttribute("success", false);
            attributes.addFlashAttribute("message", ex.getMessage());

        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/student/");
    }

    @PostMapping(value = "/insert")
    public RedirectView insert(@ModelAttribute(value = "student") Student student, BindingResult result, RedirectAttributes attributes){
        if (result.hasErrors()){
            System.out.println(result.toString());
        }
        try {
            service.insert(student);
        } catch (StudentException ex) {
            attributes.addFlashAttribute("success", false);
            attributes.addFlashAttribute("message", ex.getMessage());

        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/student/");
    }

    @GetMapping(value = "/delete/{id}")
    public RedirectView delete(@PathVariable int id, RedirectAttributes attributes){
        try {
            service.delete(id);
        } catch (StudentException ex) {
            attributes.addFlashAttribute("success", false);
            attributes.addFlashAttribute("message", ex.getMessage());

        }
        attributes.addFlashAttribute("success", true);
        return new RedirectView("/student/");
    }
}