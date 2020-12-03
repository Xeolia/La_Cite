package com.la_cite.surfrider;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Feedback {


    @Id
    @GeneratedValue
    private String ville;
    private String spot;
    private String name;
    private String date;
    private String dureeBaignade;
    private String debutBaignade;
    private String finBaignade;



    public void setDureeBaignade(String dureeBaignade) { this.dureeBaignade = dureeBaignade; }

    public String getFinBaignade() { return finBaignade; }

    public void setFinBaignade(String finBaignade) { this.finBaignade = finBaignade;}

    public String getDureeBaignade() {return dureeBaignade;}

    public String getDebutBaignade() {return debutBaignade;}

    public void setDebutBaignade(String avis) {this.debutBaignade = avis; }

    public String getVille() {
        return ville;
    }

    public String getSpot() {
        return spot;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public void setVille(String id) {
        this.ville = id;
    }

    public void setSpot(String username) {
        this.spot = username;
    }

    public void setDate(String password) {
        this.date = password;
    }

    public void setName(String name) {
        this.name = name;
    }
}


