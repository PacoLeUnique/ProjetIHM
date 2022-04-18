package main;

import java.net.URISyntaxException;

import javafx.scene.image.Image;

public class Utilisateur {

    public enum Rang { ADULT, ADO, ENFANT }

    private String pseudo, password;
    private Rang rang;
    private Image image;

    /**
     * Créer un Utilisateur
     * @param Pseudo Nom de l'utilisateur
     * @param Rang Si l'utilisateur est soit ADULT, ADO ou ENFANT | par default l'utilisateur est ENFANT (facultatif)
     * @param Password Mot de passe de l'utilisateur (facultatif)
     * @throws URISyntaxException 
     */
    public Utilisateur(String Pseudo, Rang Rang, String Password) throws URISyntaxException {
        this.pseudo = Pseudo;
        this.rang = Rang;
        this.password = Password;
        this.image = new Image(getClass().getResource("user_icon.png").toExternalForm(), 150,150, false, false);
    }

    public Utilisateur(String Pseudo) {
        this.pseudo = Pseudo;
        this.rang = Rang.ENFANT;
        this.password = "";
        this.image = new Image(getClass().getResource("user_icon.png").toExternalForm(),150,150, false, false);
    }

    /** Getter du pseudo */
    public String getPseudo() { return pseudo; }
    /** Getter du rang */
    public Rang getRang() { return rang; }
    /** Getter de l'image de profil */
    public Image getImage() { return image; }

    /** Change le pseudo */
    public void setPseudo(String nouveauPseudo) { this.pseudo=nouveauPseudo; }
    /** Verifie si le mot de passe est bon */
    public Boolean checkPassword(String Password) { return password.equals(Password); }
    /** Change l'image de profil */
    public void changeImage(String Pathname) { this.image = new Image(Pathname,150,150, false, false); }
}
