package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    CarCategoryRepository carcategoryRepository;

    @Autowired
    CarRepository carRepository;

    @RequestMapping("/")
    public String carList(Model model) {
        model.addAttribute("carcatergories", carcategoryRepository.findAll());
        model.addAttribute("cars", carRepository.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String carForm(Model model) {
        model.addAttribute("carcatergories", new CarCategory());
        model.addAttribute("cars", carRepository.findAll());
        return "carform";
    }

    @PostMapping("/process")
    public String processForm(@Valid CarCategory carcategory, BindingResult result, Model model)
    {
        if (result.hasErrors())
        {
            model.addAttribute("cars", carRepository.findAll());
            return "carcategoryform";
        }
        carcategoryRepository.save(carcategory);
       return "redirect:/";
    }



    @RequestMapping("/addcar")
    public String processCar(Model model) {

        model.addAttribute("car", new Car());
        return "carform";



    }

    @PostMapping("/processcar")
    public String processForm(@Valid Car car, BindingResult result, Model model){
        if (result.hasErrors()){
            return "carform";
        }
        carRepository.save(car);
        return "redirect:/";
    }



    @RequestMapping("/detail/{id}")
    public String showCar(@PathVariable("id") long id, Model model){
        model.addAttribute(carRepository.findById(id).get());
        return "show";
    }

    @RequestMapping("/update/{id}")
    public String updateCar(@PathVariable("id") long id, Model model){
        model.addAttribute("car", carRepository.findById(id).get());
        return "carform";
    }

    @RequestMapping("/delete/{id}")
    public String deleteCar(@PathVariable("id") long id){
        carRepository.deleteById(id);
        return "redirect:/";
    }






}