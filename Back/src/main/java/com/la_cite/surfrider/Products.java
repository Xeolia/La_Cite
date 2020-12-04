package com.la_cite.surfrider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "products")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Products {

    @Id
    @GeneratedValue
    private int id;
    private String creator;
    private String cremeSolaire;
    private String cremeHydratante;
    private String parfum;
    private String cigarette;
    private String boisson;
    private String nourriture;
    private String autres;

    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getCremeSolaire() {
        return cremeSolaire;
    }

    public void setCremeSolaire(String cremeSolaire) {
        this.cremeSolaire = cremeSolaire;
    }

    public String getCremeHydratante() {
        return cremeHydratante;
    }

    public void setCremeHydratante(String cremeHydratante) {
        this.cremeHydratante = cremeHydratante;
    }

    public String getParfum() {
        return parfum;
    }

    public void setParfum(String parfum) {
        this.parfum = parfum;
    }

    public String getCigarette() {
        return cigarette;
    }

    public void setCigarette(String cigarette) {
        this.cigarette = cigarette;
    }

    public String getBoisson() {
        return boisson;
    }

    public void setBoisson(String boisson) {
        this.boisson = boisson;
    }

    public String getNourriture() {
        return nourriture;
    }

    public void setNourriture(String nourriture) {
        this.nourriture = nourriture;
    }

    public String getAutres() {
        return autres;
    }

    public void setAutres(String autres) {
        this.autres = autres;
    }
}