package com.poly.server.repository;

import com.poly.server.entity.Product;
import com.poly.server.response.ProductResponse;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("""
            SELECT new com.poly.server.response.ProductResponse(
                p.id,p.name,p.price,p.category.categoryCode,p.category.categoryName
            )
            FROM Product p JOIN Category c
            ON p.category.id = c.id
            """)
    List<ProductResponse> hienThiDanhSachSanPham();

    @Query("""
             SELECT new com.poly.server.response.ProductResponse(
                            p.id,p.name,p.price,p.category.categoryCode,p.category.categoryName
                        )
                        FROM Product p JOIN Category c
                        ON p.category.id = c.id
                        WHERE p.id = ?1
            """)
    ProductResponse detailProduct(Integer id);

    @Query("""
            SELECT new com.poly.server.response.ProductResponse(
                p.id,p.name,p.price,p.category.categoryCode,p.category.categoryName
            )
            FROM Product p JOIN Category c
            ON p.category.id = c.id
            """)
    Page<ProductResponse> phanTrang(Pageable pageable);

    // Rieng khi custom add/update/delete
    @Transactional
    @Modifying
    @Query("""
            DELETE FROM Product p WHERE p.code = ?1
            """)
    void removeByCode(String code);

}
