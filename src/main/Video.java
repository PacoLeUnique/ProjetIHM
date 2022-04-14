package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Video {

    private final String pathname;
    private String titre;
    private BufferedImage miniature;

    /**
     * Créer un Objet Video avec un BlackScreen en miniature par default
     * @param Pathname Chemin vers la video
     * @param Titre titre voulu de la vidéo | le titre du pathname par default (facultatif)
     */
    public Video(String Pathname, String Titre) {
        this.pathname = Pathname;
        this.titre = Titre;
        try { this.miniature = ImageIO.read(new File("BlackScreen.png"));}
        catch (IOException E) { E.printStackTrace(); }
    }

    public Video(String Pathname) {
        this.pathname = Pathname;
        String[] pathname_ = Pathname.split("/");
        this.titre = pathname_[pathname_.length-1];
        try { this.miniature = ImageIO.read(new File("BlackScreen.png"));}
        catch (IOException E) { E.printStackTrace(); }
    }

    /** Getter du chemin */
    public String getPathname() { return pathname; }
    /** Getter du titre */
    public String getTitre() { return titre; }

    /** Change le titre de la video */
    public void changeTitre(String nouveauTitre) { this.titre=nouveauTitre; }
    /** Change la miniature de la video */
    public void changeMiniature(BufferedImage nouvelleMiniature) { this.miniature=nouvelleMiniature; }
}
