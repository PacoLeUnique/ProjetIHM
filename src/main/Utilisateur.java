package main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;

public class Utilisateur {

    public enum Rang { ADULT, ADO, ENFANT }

    private String pseudo, password;
    private Rang rang;
    private BufferedImage image;

    /**
     * Créer un Utilisateur
     * @param Pseudo Nom de l'utilisateur
     * @param Rang Si l'utilisateur est soit ADULT, ADO ou ENFANT | par default l'utilisateur est ENFANT (facultatif)
     * @param Password Mot de passe de l'utilisateur (facultatif)
     */
    public Utilisateur(String Pseudo, Rang Rang, String Password) {
        this.pseudo = Pseudo;
        this.rang = Rang;
        this.password = Password;
        try { this.image = ImageIO.read(new File("user_icon"));}
        catch (IOException E) { E.printStackTrace(); }
    }

    public Utilisateur(String Pseudo) {
        this.pseudo = Pseudo;
        this.rang = Rang.ENFANT;
        this.password = "";
        try { this.image = ImageIO.read(new File("user_icon"));}
        catch (IOException E) { E.printStackTrace(); }
    }

    /** Getter du pseudo */
    public String getPseudo() { return pseudo; }
    /** Getter du rang */
    public Rang getRang() { return rang; }
    /** Getter de l'image de profil */
    public BufferedImage getImage() { return image; }

    /** Change le pseudo */
    public void setPseudo(String nouveauPseudo) { this.pseudo=nouveauPseudo; }
    /** Verifie si le mot de passe est bon */
    public Boolean checkPassword(String Password) {return password==Password; }
    /** Change l'image de profil */
    public void changeImage(String Pathname) {
        try { this.image = ImageIO.read(new File(Pathname));}
        catch (IOException E) { E.printStackTrace(); }
    }
}
