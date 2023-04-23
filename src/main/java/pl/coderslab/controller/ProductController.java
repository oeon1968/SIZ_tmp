package pl.coderslab.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.model.Product;
import pl.coderslab.model.ProductGroup;
import pl.coderslab.service.ProductService;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping(value = "/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public String productList(Model model) {
        model.addAttribute("products", productService.getProductList());
        return "product/productList";
    }
    //delete
    @GetMapping("/del/{id}")
    public String productDel(@PathVariable Integer id) {
        productService.delete(productService.getProduct(id));
        return "redirect:/product";
    }
    //dodanie list uzupełniających
    @ModelAttribute("productGroups")
    public List<ProductGroup> productGroups() {
        return productService.productGroups();
    }
    //insert
    @GetMapping("/ins")
    public String productNew(Model model) {
        model.addAttribute("product", new Product());
        return "product/productForm";
    }
    @PostMapping("/ins")
    public String productIns(Product product) {
        productService.insert(product);
        return "redirect:/product";
    }
    //update
    @GetMapping("/upd/{id}")
    public String productForm(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.getProduct(id));
        return "product/productForm";
    }
    @PostMapping("/upd/{id}")
    public String productUpd(Product product) {
        productService.update(product);
        return "redirect:/product";
    }

}
