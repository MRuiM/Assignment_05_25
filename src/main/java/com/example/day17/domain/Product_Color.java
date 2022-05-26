package com.example.day17.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "product_color")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product_Color {

    public Product_Color(Product pro, Color col) {
        this.pro = pro;
        this.col = col;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "p_id")
    private Product pro;
    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "c_id")
    private Color col;

    @Override
    public String toString() {
        return "Product_Color{" +
                "id='" + id + '\'' +
                ", " + col +
                ", " + pro +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product_Color that = (Product_Color) o;
        return Objects.equals(id, that.id) && Objects.equals(pro, that.pro) && Objects.equals(col, that.col);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pro, col);
    }

}