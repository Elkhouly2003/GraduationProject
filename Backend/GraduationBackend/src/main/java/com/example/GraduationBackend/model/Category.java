package com.example.GraduationBackend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique=true , nullable=false ,name = "catgegory_name")
    private String eventType;

    @OneToMany(mappedBy = "category" ,cascade = CascadeType.ALL)
    private List<PlaceCategory> placeCategories;

}
