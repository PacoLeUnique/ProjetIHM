package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Video {

    private static String pathname;
    private String titre;
    private String categorie;
    private BufferedImage miniature;

    /**
     * Créer un Objet Video
     * @param Pathname Chemin vers la video
     * @param Categorie Categorie de la video | "none" par default (facultatif)
     * @param Titre titre voulu de la vidéo | le titre du pathname par default (facultatif)
     * @param Miniature Image chargé pour prévisualiser la video | un BlackScreen par default (facultatif)
     */
    public Video(String Pathname,String Categorie, String Titre, BufferedImage Miniature) {
        this.pathname = Pathname;
        this.categorie = Categorie;
        this.titre = Titre;
        this.miniature = Miniature;
    }

    public Video(String Pathname,String Categorie, String Titre) {
        this.pathname = Pathname;
        this.categorie = Categorie;
        this.titre = Titre;
        try { this.miniature = ImageIO.read(new File("BlackScreen.png"));}
        catch (IOException E) { E.printStackTrace(); }
    }

    public Video(String Pathname, String Categorie) {
        this.pathname = Pathname;
        this.categorie = Categorie;
        String[] pathname_ = Pathname.split("/");
        this.titre = pathname_[pathname_.length-1];
        try { this.miniature = ImageIO.read(new File("BlackScreen.png"));}
        catch (IOException E) { E.printStackTrace(); }
    }

    public Video(String Pathname) {
        this.pathname = Pathname;
        this.categorie = "none";
        String[] pathname_ = Pathname.split("/");
        this.titre = pathname_[pathname_.length-1];
        try { this.miniature = ImageIO.read(new File("BlackScreen.png"));}
        catch (IOException E) { E.printStackTrace(); }
    }

    /** Getter du chemin */
    public String getPathname() { return pathname; }
    /** Getter du titre */
    public String getTitre() { return titre; }
    /** Getter de la categorie (none si dans aucune categorie) */
    public String getCategorie() { return categorie; }

    /** Change le Titre de la video */
    public void changeTitre(String nouveauTitre) { this.titre=nouveauTitre; }
    /** Change la categorie de la video */
    public void changeCategorie(String Categorie) { this.categorie=Categorie; }
}
