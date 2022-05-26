package com.example.day17.domain;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name = "colors")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @OneToMany(mappedBy = "col", fetch = FetchType.LAZY , cascade = CascadeType.ALL, orphanRemoval = false)
    private List<Product_Color> product_colors= new ArrayList<>();

    public List<Product_Color> getProduct_colors() {
        return product_colors;
    }

    public void setProduct_color(List<Product_Color> pc) {
        this.product_colors = pc;
    }

    public void addProduct_color(Product_Color pc) {
        this.product_colors.add(pc);
    }

    @Override
    public String toString() {
        return "Color{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return Objects.equals(id, color.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}