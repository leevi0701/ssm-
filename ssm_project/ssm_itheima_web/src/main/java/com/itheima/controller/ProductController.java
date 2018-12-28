package com.itheima.controller;

import com.github.pagehelper.PageInfo;
import com.itheima.domain.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/findAll")
    public String findAll(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                          @RequestParam(required = false,defaultValue = "4") Integer pageSize,
                          Product product,Model model) throws Exception {

        List<Product> productList = productService.findAll(pageNum,pageSize,product);
        PageInfo pageInfo = new PageInfo(productList);
        model.addAttribute("pageInfo", pageInfo);
        return "product-list";
    }

    @RequestMapping("/save")
    public String save(Product product) throws Exception {

        productService.save(product);

        return "redirect:/product/findAll";
    }

    @RequestMapping("/delete")
    public String delete(HttpServletRequest request) throws Exception {

        String[] ids = request.getParameterValues("ids");
        productService.delete(ids);
        return "redirect:/product/findAll";
    }

    @RequestMapping("/open")
    public String open(HttpServletRequest request) throws Exception {

        String[] ids = request.getParameterValues("ids");

        for (String id : ids) {

            openById(id);
        }

        return "redirect:/product/findAll";
    }

    public void openById(String id) throws Exception {

        productService.openById(id);
    }

    @RequestMapping("/close")
    public String close(HttpServletRequest request) throws Exception {

        String[] ids = request.getParameterValues("ids");

        for (String id : ids) {

            closeById(id);
        }

        return "redirect:/product/findAll";
    }

    public void closeById(String id) throws Exception {

        productService.closeById(id);
    }

    /*@RequestMapping("/findById")
    public ModelAndView findById(String id) throws Exception {
        Product product = productService.findById(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("product",product);
        mv.setViewName("product-update");
        return mv;
    }*/

    @RequestMapping("/findById")
    public String findById(String id,Model model) throws Exception {

        Product product = productService.findById(id);
        model.addAttribute("product",product);
        return "product-update";
    }

    @RequestMapping("/update")
    public String update(Product product) throws Exception {
        productService.update(product);
        return "redirect:/product/findAll";
    }

}
