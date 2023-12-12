package com.cg.Garment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.Garment.entity.Products;
import com.cg.Garment.enumOf.Category;


@Repository
public interface IProductsRepository extends JpaRepository<Products, Long>{
	
	@Query("select p.stocksAvaliable from Products p WHERE p.productId = :productId")
	public int stocks (@Param("productId") Long  productId );
	
	@Query("select p from Products p where p.productCost > :productCost AND p.category = :category")
	public java.util.List<Products>getProducts (@Param("productCost") int productCost, @Param("category") Category category);
	
}
