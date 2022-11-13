package com.demo.ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.ecommerce.model.Producto;

@Repository
public interface IProductoRepository extends JpaRepository<Producto, Integer> {

}
