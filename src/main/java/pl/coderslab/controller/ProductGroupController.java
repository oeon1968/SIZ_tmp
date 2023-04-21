package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.ProductGroup;
import pl.coderslab.service.ProductGroupService;

@Controller
@RequestMapping(value = "/product_group")
@RequiredArgsConstructor
public class ProductGroupController {
    private final ProductGroupService productGroupService;

    @RequestMapping(method = RequestMethod.GET)
    public String productGroupList(Model model) {
        model.addAttribute("List", productGroupService.getProductGroupList());
        return "/dictionary/productGroupList";
    }

    @RequestMapping(value = "/del/{id}", method = RequestMethod.GET)
    public String productGroupDel(@PathVariable int id) {
        productGroupService.delete(productGroupService.getProductGroup(id));
        return "redirect:/product_group";
    }

    @GetMapping(value = "/upd/{id}")
    public String productGroupForm(@PathVariable int id, Model model) {
        model.addAttribute(productGroupService.getProductGroup(id));
        return "/dictionary/productGroupForm";
    }

    @PostMapping(value = "/upd/{id}")
    public String productGroupUpd(ProductGroup productGroup) {
        productGroupService.update(productGroup);
        return "redirect:/product_group";
    }

    @GetMapping(value = "/ins")
    public String productGroupNew(Model model) {
        model.addAttribute("productGroup", new ProductGroup());
        return "/dictionary/productGroupForm";
    }

    @PostMapping(value = "/ins")
    public String productGroupIns(ProductGroup productGroup) {
        productGroupService.insert(productGroup);
        return "redirect:/product_group";
    }
}
