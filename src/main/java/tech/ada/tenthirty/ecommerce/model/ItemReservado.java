package tech.ada.tenthirty.ecommerce.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@Entity
@Table(name = "item_reservado")
public class ItemReservado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String sku;

    private BigDecimal price;

    private Integer quantityStock;

    private String compraId;

    public Integer getQuantidadeReservada() {
        return Objects.isNull(quantityStock)?0:quantityStock;
    }
}
