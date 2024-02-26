package PaooGame.Tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile extends Rectangle
{
    private static final int NO_TILES   = 50;
    public static Tile[] tiles          = new Tile[NO_TILES];       /*!< Vector de referinte de tipuri de dale.*/

        /// De remarcat ca urmatoarele dale sunt statice si publice. Acest lucru imi permite sa le am incarcate
        /// o singura data in memorie
    public static Tile gol        = new Gol(30);
    public static Tile Piatraint1        = new Piatraint1(0);
    public static Tile Piatraint2        = new Piatraint2(1);
    public static Tile Piatraint3        = new Piatraint3(2);
    public static Tile Piatraint4        = new Piatraint4(3);
    public static Tile Piatraint5        = new Piatraint5(4);
    public static Tile Piatraint6        = new Piatraint6(5);
    public static Tile Piatraint7        = new Piatraint7(6);
    public static Tile Piatraint8        = new Piatraint8(7);
    public static Tile Piatraint9        = new Piatraint9(8);
    public static Tile Piatraint10        = new Piatraint10(9);
    public static Tile Piatraint11        = new Piatraint11(10);
    public static Tile Piatraint12        = new Piatraint12(11);
    public static Tile Piatraint13        = new Piatraint13(12);

    public static Tile Peretiext1        = new Peretiext1(13);
    public static Tile Peretiext2        = new Peretiext2(14);
    public static Tile Peretiext3        = new Peretiext3(15);
    public static Tile Peretiext4        = new Peretiext4(16);

    public static Tile Peretiint1        = new Peretiint1(17);
    public static Tile Peretiint2        = new Peretiint2(18);
    public static Tile Peretiint3        = new Peretiint3(19);
    public static Tile Peretiint4        = new Peretiint4(20);
    public static Tile Peretiint5        = new Peretiint5(21);
    public static Tile Peretiint6        = new Peretiint6(22);
    public static Tile Peretiint7        = new Peretiint7(23);
    public static Tile Peretiint8        = new Peretiint8(24);
    public static Tile Peretiint9        = new Peretiint9(25);
    public static Tile Peretiint10        = new Peretiint10(26);
    public static Tile Peretiint11        = new Peretiint11(27);
    public static Tile Peretiint12        = new Peretiint12(28);

    public static Tile Shadow       = new Shadow(29);
    public static Tile Blood1       = new Blood1(31);
    public static Tile Blood2       = new Blood2(32);
    public static Tile Blood3       = new Blood3(33);
    public static Tile Blood4       = new Blood4(34);

    public static Tile Start       = new Start(35);


    public static final int TILE_WIDTH  = 32;
    public static final int TILE_HEIGHT = 32;

    protected BufferedImage img;
    protected final int id;

    public Tile(BufferedImage image, int idd)
    {
        img = image;
        id = idd;

        tiles[id] = this;
    }

    public void Update()
    {

    }

    /*! \fn public void Draw(Graphics g, int x, int y)
        \brief Deseneaza in fereastra dala.

        \param g Contextul grafic in care sa se realizeze desenarea
        \param x Coordonata x in cadrul ferestrei unde sa fie desenata dala
        \param y Coordonata y in cadrul ferestrei unde sa fie desenata dala
     */
    public void Draw(Graphics g, int x, int y)
    {

        g.drawImage(img, x, y, TILE_WIDTH, TILE_HEIGHT, null);
    }

    public boolean IsSolid()
    {
        return true;
    }

    public int GetId()
    {
        return id;
    }
}
