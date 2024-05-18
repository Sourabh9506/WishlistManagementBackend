package com.productWishlist.Model.dto;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {
    @NotEmpty
    private String name;
    @NotNull
    private Double price;

    public @NotEmpty String getName() {
        return name;
    }

    public void setName(@NotEmpty String name) {
        this.name = name;
    }

    public @NotNull Double getPrice() {
        return price;
    }

    public void setPrice(@NotNull Double price) {
        this.price = price;
    }
}
