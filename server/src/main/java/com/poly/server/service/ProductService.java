package com.poly.server.service;

import com.poly.server.entity.Category;
import com.poly.server.entity.Product;
import com.poly.server.repository.CategoryRepository;
import com.poly.server.repository.ProductRepository;
import com.poly.server.request.ProductRequest;
import com.poly.server.response.ProductResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    public List<ProductResponse> getAll() {
        return productRepository.hienThiDanhSachSanPham();
    }

    public ProductResponse getOne(Integer id) {
        return productRepository.detailProduct(id);
    }

    public Page<ProductResponse> phanTrangProduct(Integer pageNo, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return productRepository.phanTrang(pageable);
    }

    public void removeProduct(Integer id) {
        productRepository.deleteById(id);
    }

    public void addProduct(ProductRequest req) {
        Product p = new Product();
        BeanUtils.copyProperties(req, p);
        // Xu ly khoa ngoai
        Category cate = categoryRepository.
                findById(req.getCategoryId()).get();
        p.setCategory(cate);
        // Save
        productRepository.save(p);
    }
}
