package main;

public class Video {

    private String pathname, titre, categorie;

    /**
     * Créer un Objet Video
     * @param Pathname Chemin vers la video
     * @param Categorie Categorie de la video (facultatif)
     * @param Titre titre voulu de la vidéo (facultatif)
     */
    public Video(String Pathname,String Categorie, String Titre) {
        this.pathname = Pathname;
        this.categorie = Categorie;
        this.titre = Titre;
    }

    public Video(String Pathname, String Categorie) {
        this.pathname = Pathname;
        this.categorie = Categorie;
        String[] pathname_ = Pathname.split("/");
        this.titre = pathname_[pathname_.length-1];
    }

    public Video(String Pathname) {
        this.pathname = Pathname;
        this.categorie = "none";
        String[] pathname_ = Pathname.split("/");
        this.titre = pathname_[pathname_.length-1];
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
