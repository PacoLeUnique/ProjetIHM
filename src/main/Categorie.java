package main;

import java.util.ArrayList;

public class Categorie {

    private String nom;
    private ArrayList<Integer> permissions;
    private ArrayList<Video> Videos = new ArrayList<>();

    /**
     * Créer un Objet Video avec un BlackScreen en miniature par default
     * @param Nom Nom de la categorie
     * @param Permissions Definie les permissions de la categorie | tout les droits sont données par default (facultatif)
     */
    public Categorie(String Nom, ArrayList<Integer> Permissions) {
        this.nom = Nom;
        this.permissions = Permissions;
    }

    public Categorie(String Nom) {
        this.nom = Nom;
        this.permissions = null;
    }

    /** Getter du nom */
    public String getNom() { return nom; }
    /** Getter des permissions */
    public ArrayList<Integer> getPermissions() { return permissions; }
    /** Getter des videos */
    public ArrayList<Video> getVideos() { return Videos; }

    /** Change le nom */
    public void setNom(String nouveauNom) { this.nom = nouveauNom; }
    /** Change les permissions de la categorie */
    public void setPermissions(ArrayList<Integer> nouvellesPermissions) { this.permissions = nouvellesPermissions; }

    /** Ajoute une video à la categorie */
    public void addVideo(Video video) { Videos.add(video); }
    /** Retire une video de la categorie */
    public void removeVideo(Video video) { Videos.remove(video); }
}
