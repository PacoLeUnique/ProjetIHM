package main.Controllers;

import main.Utilisateur;
import main.Video;

import java.util.ArrayList;

public class optionController {

    private Video video;
    private ArrayList<Utilisateur> users;

    public void sendModel(Video Video) {
        this.video=Video;
    }
}
