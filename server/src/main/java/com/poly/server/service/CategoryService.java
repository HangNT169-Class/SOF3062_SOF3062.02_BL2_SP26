package com.poly.server.service;

import com.poly.server.entity.Category;
import com.poly.server.repository.CategoryRepository;
import com.poly.server.request.CategoryRequest;
import com.poly.server.response.CategoryResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    // hien thi du lieu => findAll()
    // List<Category>: co
    // List<CategoryResponse>: can
    // MAPPING: Category => CategoryResponse
    // 2 cach:
    // C1: Xu ly service => convertToResponse
    // C2: Xu ly repository

    // xu ly bang service
    public List<CategoryResponse> getAll() {
        List<CategoryResponse> listResponse = new ArrayList<>();
        // Code
        List<Category> listCate = categoryRepository.findAll();
        for (Category c : listCate) {
            // them du lieu listResponse
            listResponse.add(convertToResponse(c));
        }
        return listResponse;
    }

    // xu ly bang repo
    public List<CategoryResponse> getAll1() {
        return categoryRepository.hienThiDanhSachCate();
    }

    public CategoryResponse detail(Integer id) {
        return categoryRepository.detailCate(id);
    }

    public void removeCate(Integer id) {
        categoryRepository.deleteById(id);
    }

    public void addCate(CategoryRequest req) {
        Category cate = new Category();
        // SE COPY DUOC CAC THUOC TINH CO TEN TRUNG NHAU REQ => ENTIY
        BeanUtils.copyProperties(req, cate);
        categoryRepository.save(cate);
    }

    public Page<CategoryResponse> phanTrangCate(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return categoryRepository.phanTrang(pageable);
    }

    private CategoryResponse convertToResponse(Category c) {
        CategoryResponse response = new CategoryResponse();
        // code => convert
        response.setCode(c.getCategoryCode());
        response.setName(c.getCategoryName());
        return response;
    }
}
