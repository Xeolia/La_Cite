package com.la_cite.surfrider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "frequentation")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Frequentation {

    @Id
    @GeneratedValue
    private int id;
    private String creator;
    private String nbBaigneurs;
    private String nbPratiquantsActivitésNautiques;
    private String nbBateauxPeche;
    private String nbBateauxLoisir;
    private String nbBateauxVoiles;

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

    public String getNbBaigneurs() {
        return nbBaigneurs;
    }

    public void setNbBaigneurs(String nbBaigneurs) {
        this.nbBaigneurs = nbBaigneurs;
    }

    public String getNbPratiquantsActivitésNautiques() {
        return nbPratiquantsActivitésNautiques;
    }

    public void setNbPratiquantsActivitésNautiques(String nbPratiquantsActivitésNautiques) {
        this.nbPratiquantsActivitésNautiques = nbPratiquantsActivitésNautiques;
    }

    public String getNbBateauxPeche() {
        return nbBateauxPeche;
    }

    public void setNbBateauxPeche(String nbBateauxPeche) {
        this.nbBateauxPeche = nbBateauxPeche;
    }

    public String getNbBateauxLoisir() {
        return nbBateauxLoisir;
    }

    public void setNbBateauxLoisir(String nbBateauxLoisir) {
        this.nbBateauxLoisir = nbBateauxLoisir;
    }

    public String getNbBateauxVoiles() {
        return nbBateauxVoiles;
    }

    public void setNbBateauxVoiles(String nbBateauxVoiles) {
        this.nbBateauxVoiles = nbBateauxVoiles;
    }

}
