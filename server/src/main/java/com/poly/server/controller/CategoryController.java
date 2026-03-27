package com.poly.server.controller;

import com.poly.server.request.CategoryRequest;
import com.poly.server.response.CategoryResponse;
import com.poly.server.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/category-management")
@CrossOrigin(origins = "*") // Cho FE duoc quyen truy cap cac duong dan trong controller nay
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryResponse> hienThiCategorys() {
        return categoryService.getAll1();
    }

    // C1: Path variable
    @GetMapping("detail/{id}")
    public CategoryResponse detailCategory(@PathVariable("id") Integer id) {
        return categoryService.detail(id);
    }

    // C2: Request param
    @GetMapping("detail1")
    public CategoryResponse detailCategory1(@RequestParam("id") Integer id) {
        return categoryService.detail(id);
    }

    @DeleteMapping("delete")
    public void remove(@RequestParam("id1") Integer id){
        categoryService.removeCate(id);
    }

    // page Size: so luong phan tu tren 1 trang
    // pageNo: so trang => 0
    // gia tri nao co dinh => defaultValue
    @GetMapping("paging")
    public List<CategoryResponse>phanTrang(@RequestParam("pageNo1") Integer pageNo,
                                           @RequestParam(value = "pageSize1", defaultValue = "5") Integer pageSize){
        return categoryService.phanTrangCate(pageNo,pageSize).getContent();
    }

    @PostMapping("add")
    public void addCate(@RequestBody CategoryRequest req){
        categoryService.addCate(req);
    }

}
