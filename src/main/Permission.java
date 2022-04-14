package main;

public class Permission {

    private final Utilisateur user;
    private Boolean acces;

    /**
     * Créer une Permission qui restreint l'acces de l'objet si acces==false
     * @param User Utilisateur qui est concerne
     * @param Acces True si il a acces et False si il n'a pas acces | True par default (facultatif)
     */
    public Permission(Utilisateur User, Boolean Acces) {
        this.user = User;
        this.acces = Acces;
    }

    public Permission(Utilisateur User) {
        this.user = User;
        this.acces = true;
    }

    /** Getter de l'utilisateur */
    public Utilisateur getUser() { return user; }
    /** Getter de acces */
    public Boolean getAcces() { return acces; }

    /** Setter de acces */
    public void setAcces(Boolean nouvelleAcces) { this.acces=nouvelleAcces; }
}
