package com.poly.server.repository;

import com.poly.server.entity.Category;
import com.poly.server.response.CategoryResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {

    // truy van bang doi tuong => k phai truy van bang ten bang
    @Query("""
        SELECT new com.poly.server.response.CategoryResponse(c1.categoryCode,c1.categoryName)
        FROM Category c1
        """)
    List<CategoryResponse>hienThiDanhSachCate();

    @Query("""
        SELECT new com.poly.server.response.CategoryResponse(c1.categoryCode,c1.categoryName)
        FROM Category c1
        WHERE c1.id = ?1
        """)
    CategoryResponse detailCate(Integer id);

    @Query("""
        SELECT new com.poly.server.response.CategoryResponse(c1.categoryCode,c1.categoryName)
        FROM Category c1
        """)
    Page<CategoryResponse>phanTrang(Pageable page);

}
