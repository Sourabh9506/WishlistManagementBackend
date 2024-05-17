package com.productWishlist.Model;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @NotEmpty
    private String itemName;

    @NotNull
    private Double itemPrice;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JoinColumn(name="fk_employee_id")
    private Employee employee;

    public Item(String itemName,Double itemPrice,Employee employee){
        this.itemName=itemName;
        this.itemPrice=itemPrice;
        this.employee=employee;
    }

}