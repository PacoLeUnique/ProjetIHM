package main;

import java.lang.reflect.Type;

public class Utilisateur {

    public enum Rang { ADULT, ADO, ENFANT }

    private String pseudo, password;
    private Rang rang;

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
    }

    public Utilisateur(String Pseudo) {
        this.pseudo = Pseudo;
        this.rang = Rang.ENFANT;
        this.password = "";
    }

    /** Getter du pseudo */
    public String getPseudo() { return pseudo; }
    /** Getter du rang */
    public Rang getRang() { return rang; }

    /** Change le pseudo */
    public void setPseudo(String nouveauPseudo) { this.pseudo=nouveauPseudo; }
    /** Verifie si le mot de passe est bon */
    public Boolean checkPassword(String Password) {return password==Password; }
}
