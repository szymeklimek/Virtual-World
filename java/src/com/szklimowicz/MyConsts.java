package com.szklimowicz;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MyConsts {

    private MyConsts() {}

    public static final short SPRITE_SIZE = 30;
    public static final short WORLD_X = 20;
    public static final short WORLD_Y = 20;
    public static ImageIcon WOLF_SPRITE;
    public static ImageIcon ANTYLOPE_SPRITE;
    public static ImageIcon CYBERSHEEP_SPRITE;
    public static ImageIcon FOX_SPRITE;
    public static ImageIcon HUMAN_SPRITE;
    public static ImageIcon SHEEP_SPRITE;
    public static ImageIcon TURTLE_SPRITE;
    public static ImageIcon BORSCHT_SPRITE;
    public static ImageIcon DANDELION_SPRITE;
    public static ImageIcon GRASS_SPRITE;
    public static ImageIcon GUARANA_SPRITE;
    public static ImageIcon WOLFBERRIES_SPRITE;
    public static ImageIcon NULL_SPRITE;

    static {
        try {
            NULL_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/null.png")));
            WOLF_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/wilk.png")));
            ANTYLOPE_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/anty.png")));
            CYBERSHEEP_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/cyber.png")));
            FOX_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/lis.png")));
            HUMAN_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/czl.png")));
            SHEEP_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/owca.png")));
            TURTLE_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/zolw.png")));
            BORSCHT_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/barszcz.png")));
            DANDELION_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/mlecz.png")));
            GRASS_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/trawa.png")));
            GUARANA_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/guarana.png")));
            WOLFBERRIES_SPRITE = new ImageIcon(ImageIO.read(new File("sprites/jagoda.png")));
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
