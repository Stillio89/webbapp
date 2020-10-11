package com.stilliodev.webapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "the field cannot be empty")
    @Size(min = 1, max = 20)
    private String brand;
    @NotNull(message = "the field cannot be empty")
    @Size(min = 1, max = 20)
    private String model;
    @NotNull(message = "the field cannot be empty")
    @Size(min = 1, max = 20)
    private String type;
    @NotNull(message = "the field cannot be empty")
    private int size;
    private boolean available = true;

    public Bike() {
    }



    public Bike(@NotNull(message = "the field cannot be empty") @Size final String brand, @NotNull(message = "the field cannot be empty") @Size final String model, @NotNull(message = "the field cannot be empty") @Size final String type, @NotNull(message = "the field cannot be empty") @Size final int size, final boolean available) {
        this.brand = brand;
        this.model = model;
        this.type = type;
        this.size = size;
        this.available = available;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(final boolean available) {
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    void setId(final Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(final String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(final String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(final int size) {
        this.size = size;
    }
}
