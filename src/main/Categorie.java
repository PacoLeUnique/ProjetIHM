package main;

import java.util.ArrayList;

public class Categorie {

    private String nom;
    private ArrayList<Video> Videos = new ArrayList<>();
    private ArrayList<Permission> permissions = new ArrayList<>();

    /**
     * Créer une Categorie de Video qui est une liste avec les permissions au maximum à la creation
     * @param Nom Nom de la categorie
     */
    public Categorie(String Nom) {
        this.nom = Nom;
    }

    /** Getter du nom */
    public String getNom() { return nom; }
    /** Getter des videos */
    public ArrayList<Video> getVideos() { return Videos; }
    /** Getter des permissions */
    public ArrayList<Permission> getPermissions() { return permissions; }

    /** Change le nom */
    public void setNom(String nouveauNom) { this.nom = nouveauNom; }

    /** Ajoute une video à la categorie */
    public void addVideo(Video video) { Videos.add(video); }
    /** Retire une video de la categorie */
    public void removeVideo(Video video) { Videos.remove(video); }

    /** Ajoute une permission */
    public void addPermission(Permission Permission) { this.permissions.add(Permission); }
    /** Retire une permission */
    public void removePermission(Permission Permission) { this.permissions.remove(Permission); }
}
