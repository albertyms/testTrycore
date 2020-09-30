package com.trycore.test.entity;

import com.trycore.test.request.PlanetRequest;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "planet", schema="public")
public class Planet {

    @GenericGenerator(
            name = "planetGenerator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "planet_sequence"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
            }
    )

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "planetGenerator")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "count_view")
    private int countView;

    public Planet() {
    }

    public Planet(PlanetRequest request) {
        this.name = request.getName();
    }


    public Planet(String name, int countView) {
        this.name = name;
        this.countView = countView;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountView() {
        return countView;
    }

    public void setCountView(int countView) {
        this.countView = countView;
    }
}
