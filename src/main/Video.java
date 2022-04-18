package main;

import javafx.scene.image.Image;

import java.util.ArrayList;

public class Video {

    private final String pathname;
    private String titre;
    private Image miniature;
    private ArrayList<Permission> permissions = new ArrayList<>();

    /**
     * Créer un Objet Video avec un BlackScreen en miniature par default
     * (Les permissions dependent par default de la categorie, mais peuvent etre ajuste sur une video)
     * @param Pathname Chemin vers la video
     * @param Titre titre voulu de la vidéo | le titre du pathname par default (facultatif)
     */
    public Video(String Pathname, String Titre) {
        this.pathname = Pathname;
        this.titre = Titre;
        this.miniature = new Image("src/main/BlackScreen.png", 150,150, false, false);
    }

    public Video(String Pathname) {
        this.pathname = Pathname;
        String[] pathname_ = Pathname.split("/");
        this.titre = pathname_[pathname_.length-1];
        this.miniature = new Image(getClass().getResource("BlackScreen.png").toExternalForm(), 150,150, false, false);
    }

    /** Getter du chemin */
    public String getPathname() { return pathname; }
    /** Getter du titre */
    public String getTitre() { return titre; }
    /** Getter de la miniature */
    public Image getMiniature() { return miniature; }
    /** Getter des permissions */
    public ArrayList<Permission> getPermissions() {return permissions; }

    /** Change le titre de la video */
    public void changeTitre(String nouveauTitre) { this.titre=nouveauTitre; }
    /** Change la miniature de la video */
    public void changeMiniature(Image nouvelleMiniature) { this.miniature=nouvelleMiniature; }

    /** Ajoute une permission */
    public void addPermission(Permission Permission) { this.permissions.add(Permission); }
    /** Retire une permission */
    public void removePermission(Permission Permission) { this.permissions.remove(Permission); }
    /** Reset les permissions */
    public void resetPermissions() { this.permissions=new ArrayList<>(); }
}
