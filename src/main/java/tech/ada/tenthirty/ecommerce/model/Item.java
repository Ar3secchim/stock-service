package tech.ada.tenthirty.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
  
    @Column(nullable = false)
    private String sku;
  
    @Column(nullable = false)
    private String name;
  
    @Column(nullable = false)
    private String description;
  
    @Column(nullable = false, name = "quantity_stock")
    private int quantityStock;
  
    @Column(nullable = false)
    private Double price;

}
