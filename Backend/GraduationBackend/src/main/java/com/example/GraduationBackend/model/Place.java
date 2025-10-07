package com.example.GraduationBackend.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity(name = "places")
public class Place {

    @Id
    @Column(name = "place_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer placeId;

    @Column(name = "place_name")
    private String placeName;

    @Column(name = "place_address")
    private String address;

    @Column(name = "place_city")
    private String city;

    @Column(name = "place_state")
    private String state;

    @Column(name = "place_country")
    private String country;

    @Column(name = "place_phone")
    private String phone;

    @Column(name = "place_description")
    private String description;

    @Column(name = "place_capacity")
    private Integer capacity ;

    @Column(name = "place_reviews")
    private Integer reviews ;

    @Column(name = "is_certified")
    private Boolean certified ;         // by default false admin is responsible for this

    @OneToMany(mappedBy = "place" , cascade = CascadeType.ALL ,orphanRemoval = true)
    private List<PlaceCategory> placeCategories;

   @OneToMany(mappedBy = "place", cascade = CascadeType.ALL, fetch = FetchType.EAGER ,orphanRemoval = true)
   private List<Image> images;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "owner_id")
   private User owner ;

   @OneToMany(mappedBy = "place" , cascade = CascadeType.ALL ,orphanRemoval = true)
   private List<Event> events;


}
