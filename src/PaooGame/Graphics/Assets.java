package PaooGame.Graphics;

import java.awt.image.BufferedImage;

/*! \class public class Assets
    \brief Clasa incarca fiecare element grafic necesar jocului.

    Game assets include tot ce este folosit intr-un joc: imagini, sunete, harti etc.
 */
public class Assets
{
    /// Referinte catre elementele grafice (dale) utilizate in joc.

    public static BufferedImage meniu;

    public static BufferedImage heroLeft;
    public static BufferedImage heroRight;
    public static BufferedImage gol;
    public static BufferedImage pint1;
    public static BufferedImage pint2;
    public static BufferedImage pint3;
    public static BufferedImage pint4;
    public static BufferedImage pint5;
    public static BufferedImage pint6;
    public static BufferedImage pint7;
    public static BufferedImage pint8;
    public static BufferedImage pint9;
    public static BufferedImage pint10;
    public static BufferedImage pint11;
    public static BufferedImage pint12;
    public static BufferedImage pint13;

    public static BufferedImage peretiext1;
    public static BufferedImage peretiext2;
    public static BufferedImage peretiext3;
    public static BufferedImage peretiext4;

    public static BufferedImage peretiint1;
    public static BufferedImage peretiint2;
    public static BufferedImage peretiint3;
    public static BufferedImage peretiint4;
    public static BufferedImage peretiint5;
    public static BufferedImage peretiint6;
    public static BufferedImage peretiint7;
    public static BufferedImage peretiint8;
    public static BufferedImage peretiint9;
    public static BufferedImage peretiint10;
    public static BufferedImage peretiint11;
    public static BufferedImage peretiint12;

    public static BufferedImage shadow1;
    public static BufferedImage blood1;
    public static BufferedImage blood2;
    public static BufferedImage blood3;
    public static BufferedImage blood4;
    public static BufferedImage chest;
    public static BufferedImage money;
    public static BufferedImage heart;
    public static BufferedImage start;

    public static BufferedImage[] hero_down;
    public static BufferedImage[] hero_up;
    public static BufferedImage[] hero_left;
    public static BufferedImage[] hero_right;
    public static BufferedImage[] hero_dead;
    public static BufferedImage[] hero_a_down;
    public static BufferedImage[] hero_a_up;
    public static BufferedImage[] hero_a_left;
    public static BufferedImage[] hero_a_right;

    public static BufferedImage[] hero_axe_down;
    public static BufferedImage[] hero_axe_up;
    public static BufferedImage[] hero_axe_left;
    public static BufferedImage[] hero_axe_right;
    public static BufferedImage[] hero_axe_a_down;
    public static BufferedImage[] hero_axe_a_up;
    public static BufferedImage[] hero_axe_a_left;
    public static BufferedImage[] hero_axe_a_right;

    public static BufferedImage[] hero_hammer_down;
    public static BufferedImage[] hero_hammer_up;
    public static BufferedImage[] hero_hammer_left;
    public static BufferedImage[] hero_hammer_right;
    public static BufferedImage[] hero_hammer_a_down;
    public static BufferedImage[] hero_hammer_a_up;
    public static BufferedImage[] hero_hammer_a_left;
    public static BufferedImage[] hero_hammer_a_right;

    public static BufferedImage[] enemy_down;
    public static BufferedImage[] enemy_up;
    public static BufferedImage[] enemy_left;
    public static BufferedImage[] enemy_right;


    /*! \fn public static void Init()
        \brief Functia initializaza referintele catre elementele grafice utilizate.

        Aceasta functie poate fi rescrisa astfel incat elementele grafice incarcate/utilizate
        sa fie parametrizate. Din acest motiv referintele nu sunt finale.
     */
    public static void Init()
    {
        /// Se creaza temporar un obiect SpriteSheet initializat prin intermediul clasei ImageLoader
        SpriteSheet sheet1 = new SpriteSheet(ImageLoader.LoadImage("/textures/GameSprite.png"));
        SpriteSheet sheet2 = new SpriteSheet(ImageLoader.LoadImage("/textures/HeroSpriteSheet.png"));
        SpriteSheet enemysheet = new SpriteSheet(ImageLoader.LoadImage("/textures/EnemySpriteSheet.png"));
        SpriteSheet moneysheet = new SpriteSheet(ImageLoader.LoadImage("/textures/money.png"));
        SpriteSheet heartsheet = new SpriteSheet(ImageLoader.LoadImage("/textures/heart.png"));
        SpriteSheet meniusheet = new SpriteSheet(ImageLoader.LoadImage("/textures/menubg.png"));

        /// Se obtin subimaginile corespunzatoare elementelor necesare.
        meniu=meniusheet.crop(0,0,3);
        gol = sheet1.crop(9, 9,0);
        pint1 = sheet1.crop(0, 0,0);
        pint2 = sheet1.crop(1, 0,0);
        pint3 = sheet1.crop(2, 0,0);
        pint4 = sheet1.crop(3, 0,0);
        pint5 = sheet1.crop(4, 0,0);
        pint6 = sheet1.crop(5, 0,0);
        pint7 = sheet1.crop(3, 1,0);
        pint8 = sheet1.crop(4, 1,0);
        pint9 = sheet1.crop(5, 1,0);
        pint10 = sheet1.crop(6, 1,0);
        pint11 = sheet1.crop(7, 1,0);
        pint12 = sheet1.crop(8, 1,0);
        pint13 = sheet1.crop(9, 1,0);

        peretiext1 = sheet1.crop(4, 3,0);
        peretiext2 = sheet1.crop(5, 3,0);
        peretiext3 = sheet1.crop(6, 3,0);
        peretiext4 = sheet1.crop(7, 3,0);

        peretiint1 = sheet1.crop(0, 1,0);
        peretiint2 = sheet1.crop(1, 1,0);
        peretiint3 = sheet1.crop(2, 1,0);
        peretiint4 = sheet1.crop(0, 2,0);
        peretiint5 = sheet1.crop(1, 2,0);
        peretiint6 = sheet1.crop(2, 2,0);
        peretiint7 = sheet1.crop(3, 2,0);
        peretiint8 = sheet1.crop(4, 2,0);
        peretiint9 = sheet1.crop(5, 2,0);
        peretiint10 = sheet1.crop(6, 2,0);
        peretiint11 = sheet1.crop(7, 2,0);
        peretiint12 = sheet1.crop(8, 2,0);

        shadow1 = sheet1.crop(8, 3,0);
        blood1 = sheet1.crop(5, 5,0);
        blood2 = sheet1.crop(5, 6,0);
        blood3 = sheet1.crop(5, 7,0);
        blood4 = sheet1.crop(6, 7,0);
        chest = sheet1.crop(7, 4,0);
        start = sheet1.crop(9, 4,0);


        heroLeft = sheet2.crop(1, 2,1);
        heroRight = sheet2.crop(9, 1,1);

        hero_down=new BufferedImage[9];
        hero_down[0]=sheet2.crop(0,2,1);
        hero_down[1]=sheet2.crop(1,2,1);
        hero_down[2]=sheet2.crop(2,2,1);
        hero_down[3]=sheet2.crop(3,2,1);
        hero_down[4]=sheet2.crop(4,2,1);
        hero_down[5]=sheet2.crop(5,2,1);
        hero_down[6]=sheet2.crop(6,2,1);
        hero_down[7]=sheet2.crop(7,2,1);
        hero_down[8]=sheet2.crop(8,2,1);

        hero_axe_down=new BufferedImage[9];
        hero_axe_down[0]=sheet2.crop(0,11,1);
        hero_axe_down[1]=sheet2.crop(1,11,1);
        hero_axe_down[2]=sheet2.crop(2,11,1);
        hero_axe_down[3]=sheet2.crop(3,11,1);
        hero_axe_down[4]=sheet2.crop(4,11,1);
        hero_axe_down[5]=sheet2.crop(5,11,1);
        hero_axe_down[6]=sheet2.crop(6,11,1);
        hero_axe_down[7]=sheet2.crop(7,11,1);
        hero_axe_down[8]=sheet2.crop(8,11,1);

        hero_hammer_down=new BufferedImage[9];
        hero_hammer_down[0]=sheet2.crop(0,19,1);
        hero_hammer_down[1]=sheet2.crop(1,19,1);
        hero_hammer_down[2]=sheet2.crop(2,19,1);
        hero_hammer_down[3]=sheet2.crop(3,19,1);
        hero_hammer_down[4]=sheet2.crop(4,19,1);
        hero_hammer_down[5]=sheet2.crop(5,19,1);
        hero_hammer_down[6]=sheet2.crop(6,19,1);
        hero_hammer_down[7]=sheet2.crop(7,19,1);
        hero_hammer_down[8]=sheet2.crop(8,19,1);

        hero_up=new BufferedImage[9];
        hero_up[0]=sheet2.crop(0,0,1);
        hero_up[1]=sheet2.crop(1,0,1);
        hero_up[2]=sheet2.crop(2,0,1);
        hero_up[3]=sheet2.crop(3,0,1);
        hero_up[4]=sheet2.crop(4,0,1);
        hero_up[5]=sheet2.crop(5,0,1);
        hero_up[6]=sheet2.crop(6,0,1);
        hero_up[7]=sheet2.crop(7,0,1);
        hero_up[8]=sheet2.crop(8,0,1);

        hero_axe_up=new BufferedImage[9];
        hero_axe_up[0]=sheet2.crop(0,9,1);
        hero_axe_up[1]=sheet2.crop(1,9,1);
        hero_axe_up[2]=sheet2.crop(2,9,1);
        hero_axe_up[3]=sheet2.crop(3,9,1);
        hero_axe_up[4]=sheet2.crop(4,9,1);
        hero_axe_up[5]=sheet2.crop(5,9,1);
        hero_axe_up[6]=sheet2.crop(6,9,1);
        hero_axe_up[7]=sheet2.crop(7,9,1);
        hero_axe_up[8]=sheet2.crop(8,9,1);

        hero_hammer_up=new BufferedImage[9];
        hero_hammer_up[0]=sheet2.crop(0,17,1);
        hero_hammer_up[1]=sheet2.crop(1,17,1);
        hero_hammer_up[2]=sheet2.crop(2,17,1);
        hero_hammer_up[3]=sheet2.crop(3,17,1);
        hero_hammer_up[4]=sheet2.crop(4,17,1);
        hero_hammer_up[5]=sheet2.crop(5,17,1);
        hero_hammer_up[6]=sheet2.crop(6,17,1);
        hero_hammer_up[7]=sheet2.crop(7,17,1);
        hero_hammer_up[8]=sheet2.crop(8,17,1);

        hero_right=new BufferedImage[9];
        hero_right[0]=sheet2.crop(0,3,1);
        hero_right[1]=sheet2.crop(1,3,1);
        hero_right[2]=sheet2.crop(2,3,1);
        hero_right[3]=sheet2.crop(3,3,1);
        hero_right[4]=sheet2.crop(4,3,1);
        hero_right[5]=sheet2.crop(5,3,1);
        hero_right[6]=sheet2.crop(6,3,1);
        hero_right[7]=sheet2.crop(7,3,1);
        hero_right[8]=sheet2.crop(8,3,1);

        hero_axe_right=new BufferedImage[9];
        hero_axe_right[0]=sheet2.crop(0,12,1);
        hero_axe_right[1]=sheet2.crop(1,12,1);
        hero_axe_right[2]=sheet2.crop(2,12,1);
        hero_axe_right[3]=sheet2.crop(3,12,1);
        hero_axe_right[4]=sheet2.crop(4,12,1);
        hero_axe_right[5]=sheet2.crop(5,12,1);
        hero_axe_right[6]=sheet2.crop(6,12,1);
        hero_axe_right[7]=sheet2.crop(7,12,1);
        hero_axe_right[8]=sheet2.crop(8,12,1);

        hero_hammer_right=new BufferedImage[9];
        hero_hammer_right[0]=sheet2.crop(0,20,1);
        hero_hammer_right[1]=sheet2.crop(1,20,1);
        hero_hammer_right[2]=sheet2.crop(2,20,1);
        hero_hammer_right[3]=sheet2.crop(3,20,1);
        hero_hammer_right[4]=sheet2.crop(4,20,1);
        hero_hammer_right[5]=sheet2.crop(5,20,1);
        hero_hammer_right[6]=sheet2.crop(6,20,1);
        hero_hammer_right[7]=sheet2.crop(7,20,1);
        hero_hammer_right[8]=sheet2.crop(8,20,1);

        hero_left=new BufferedImage[9];
        hero_left[0]=sheet2.crop(0,1,1);
        hero_left[1]=sheet2.crop(1,1,1);
        hero_left[2]=sheet2.crop(2,1,1);
        hero_left[3]=sheet2.crop(3,1,1);
        hero_left[4]=sheet2.crop(4,1,1);
        hero_left[5]=sheet2.crop(5,1,1);
        hero_left[6]=sheet2.crop(6,1,1);
        hero_left[7]=sheet2.crop(7,1,1);
        hero_left[8]=sheet2.crop(8,1,1);

        hero_axe_left=new BufferedImage[9];
        hero_axe_left[0]=sheet2.crop(0,10,1);
        hero_axe_left[1]=sheet2.crop(1,10,1);
        hero_axe_left[2]=sheet2.crop(2,10,1);
        hero_axe_left[3]=sheet2.crop(3,10,1);
        hero_axe_left[4]=sheet2.crop(4,10,1);
        hero_axe_left[5]=sheet2.crop(5,10,1);
        hero_axe_left[6]=sheet2.crop(6,10,1);
        hero_axe_left[7]=sheet2.crop(7,10,1);
        hero_axe_left[8]=sheet2.crop(8,10,1);

        hero_hammer_left=new BufferedImage[9];
        hero_hammer_left[0]=sheet2.crop(0,18,1);
        hero_hammer_left[1]=sheet2.crop(1,18,1);
        hero_hammer_left[2]=sheet2.crop(2,18,1);
        hero_hammer_left[3]=sheet2.crop(3,18,1);
        hero_hammer_left[4]=sheet2.crop(4,18,1);
        hero_hammer_left[5]=sheet2.crop(5,18,1);
        hero_hammer_left[6]=sheet2.crop(6,18,1);
        hero_hammer_left[7]=sheet2.crop(7,18,1);
        hero_hammer_left[8]=sheet2.crop(8,18,1);

        hero_dead=new BufferedImage[6];
        hero_dead[0]=sheet2.crop(0,8,1);
        hero_dead[1]=sheet2.crop(1,8,1);
        hero_dead[2]=sheet2.crop(2,8,1);
        hero_dead[3]=sheet2.crop(3,8,1);
        hero_dead[4]=sheet2.crop(4,8,1);
        hero_dead[5]=sheet2.crop(5,8,1);

        hero_a_down=new BufferedImage[6];
        hero_a_down[0]=sheet2.crop(0,6,1);
        hero_a_down[1]=sheet2.crop(1,6,1);
        hero_a_down[2]=sheet2.crop(2,6,1);
        hero_a_down[3]=sheet2.crop(3,6,1);
        hero_a_down[4]=sheet2.crop(4,6,1);
        hero_a_down[5]=sheet2.crop(5,6,1);

        hero_axe_a_down=new BufferedImage[6];
        hero_axe_a_down[0]=sheet2.crop(0,15,1);
        hero_axe_a_down[1]=sheet2.crop(1,15,1);
        hero_axe_a_down[2]=sheet2.crop(2,15,1);
        hero_axe_a_down[3]=sheet2.crop(3,15,1);
        hero_axe_a_down[4]=sheet2.crop(4,15,1);
        hero_axe_a_down[5]=sheet2.crop(5,15,1);

        hero_hammer_a_down=new BufferedImage[6];
        hero_hammer_a_down[0]=sheet2.crop(0,23,1);
        hero_hammer_a_down[1]=sheet2.crop(1,23,1);
        hero_hammer_a_down[2]=sheet2.crop(2,23,1);
        hero_hammer_a_down[3]=sheet2.crop(3,23,1);
        hero_hammer_a_down[4]=sheet2.crop(4,23,1);
        hero_hammer_a_down[5]=sheet2.crop(5,23,1);

        hero_a_up=new BufferedImage[6];
        hero_a_up[0]=sheet2.crop(0,4,1);
        hero_a_up[1]=sheet2.crop(1,4,1);
        hero_a_up[2]=sheet2.crop(2,4,1);
        hero_a_up[3]=sheet2.crop(3,4,1);
        hero_a_up[4]=sheet2.crop(4,4,1);
        hero_a_up[5]=sheet2.crop(5,4,1);

        hero_axe_a_up=new BufferedImage[6];
        hero_axe_a_up[0]=sheet2.crop(0,13,1);
        hero_axe_a_up[1]=sheet2.crop(1,13,1);
        hero_axe_a_up[2]=sheet2.crop(2,13,1);
        hero_axe_a_up[3]=sheet2.crop(3,13,1);
        hero_axe_a_up[4]=sheet2.crop(4,13,1);
        hero_axe_a_up[5]=sheet2.crop(5,13,1);

        hero_hammer_a_up=new BufferedImage[6];
        hero_hammer_a_up[0]=sheet2.crop(0,21,1);
        hero_hammer_a_up[1]=sheet2.crop(1,21,1);
        hero_hammer_a_up[2]=sheet2.crop(2,21,1);
        hero_hammer_a_up[3]=sheet2.crop(3,21,1);
        hero_hammer_a_up[4]=sheet2.crop(4,21,1);
        hero_hammer_a_up[5]=sheet2.crop(5,21,1);

        hero_a_left=new BufferedImage[6];
        hero_a_left[0]=sheet2.crop(0,5,1);
        hero_a_left[1]=sheet2.crop(1,5,1);
        hero_a_left[2]=sheet2.crop(2,5,1);
        hero_a_left[3]=sheet2.crop(3,5,1);
        hero_a_left[4]=sheet2.crop(4,5,1);
        hero_a_left[5]=sheet2.crop(5,5,1);

        hero_axe_a_left=new BufferedImage[6];
        hero_axe_a_left[0]=sheet2.crop(0,14,1);
        hero_axe_a_left[1]=sheet2.crop(1,14,1);
        hero_axe_a_left[2]=sheet2.crop(2,14,1);
        hero_axe_a_left[3]=sheet2.crop(3,14,1);
        hero_axe_a_left[4]=sheet2.crop(4,14,1);
        hero_axe_a_left[5]=sheet2.crop(5,14,1);

        hero_hammer_a_left=new BufferedImage[6];
        hero_hammer_a_left[0]=sheet2.crop(0,22,1);
        hero_hammer_a_left[1]=sheet2.crop(1,22,1);
        hero_hammer_a_left[2]=sheet2.crop(2,22,1);
        hero_hammer_a_left[3]=sheet2.crop(3,22,1);
        hero_hammer_a_left[4]=sheet2.crop(4,22,1);
        hero_hammer_a_left[5]=sheet2.crop(5,22,1);

        hero_a_right=new BufferedImage[6];
        hero_a_right[0]=sheet2.crop(0,7,1);
        hero_a_right[1]=sheet2.crop(1,7,1);
        hero_a_right[2]=sheet2.crop(2,7,1);
        hero_a_right[3]=sheet2.crop(3,7,1);
        hero_a_right[4]=sheet2.crop(4,7,1);
        hero_a_right[5]=sheet2.crop(5,7,1);

        hero_axe_a_right=new BufferedImage[6];
        hero_axe_a_right[0]=sheet2.crop(0,16,1);
        hero_axe_a_right[1]=sheet2.crop(1,16,1);
        hero_axe_a_right[2]=sheet2.crop(2,16,1);
        hero_axe_a_right[3]=sheet2.crop(3,16,1);
        hero_axe_a_right[4]=sheet2.crop(4,16,1);
        hero_axe_a_right[5]=sheet2.crop(5,16,1);

        hero_hammer_a_right=new BufferedImage[6];
        hero_hammer_a_right[0]=sheet2.crop(0,24,1);
        hero_hammer_a_right[1]=sheet2.crop(1,24,1);
        hero_hammer_a_right[2]=sheet2.crop(2,24,1);
        hero_hammer_a_right[3]=sheet2.crop(3,24,1);
        hero_hammer_a_right[4]=sheet2.crop(4,24,1);
        hero_hammer_a_right[5]=sheet2.crop(5,24,1);

        money=moneysheet.crop(0,0,2);
        heart=heartsheet.crop(0,0,2);

        enemy_down=new BufferedImage[9];
        enemy_down[0]=enemysheet.crop(0,2,1);
        enemy_down[1]=enemysheet.crop(1,2,1);
        enemy_down[2]=enemysheet.crop(2,2,1);
        enemy_down[3]=enemysheet.crop(3,2,1);
        enemy_down[4]=enemysheet.crop(4,2,1);
        enemy_down[5]=enemysheet.crop(5,2,1);
        enemy_down[6]=enemysheet.crop(6,2,1);
        enemy_down[7]=enemysheet.crop(7,2,1);
        enemy_down[8]=enemysheet.crop(8,2,1);

        enemy_up=new BufferedImage[9];
        enemy_up[0]=enemysheet.crop(0,0,1);
        enemy_up[1]=enemysheet.crop(1,0,1);
        enemy_up[2]=enemysheet.crop(2,0,1);
        enemy_up[3]=enemysheet.crop(3,0,1);
        enemy_up[4]=enemysheet.crop(4,0,1);
        enemy_up[5]=enemysheet.crop(5,0,1);
        enemy_up[6]=enemysheet.crop(6,0,1);
        enemy_up[7]=enemysheet.crop(7,0,1);
        enemy_up[8]=enemysheet.crop(8,0,1);

        enemy_right=new BufferedImage[9];
        enemy_right[0]=enemysheet.crop(0,3,1);
        enemy_right[1]=enemysheet.crop(1,3,1);
        enemy_right[2]=enemysheet.crop(2,3,1);
        enemy_right[3]=enemysheet.crop(3,3,1);
        enemy_right[4]=enemysheet.crop(4,3,1);
        enemy_right[5]=enemysheet.crop(5,3,1);
        enemy_right[6]=enemysheet.crop(6,3,1);
        enemy_right[7]=enemysheet.crop(7,3,1);
        enemy_right[8]=enemysheet.crop(8,3,1);

        enemy_left=new BufferedImage[9];
        enemy_left[0]=enemysheet.crop(0,1,1);
        enemy_left[1]=enemysheet.crop(1,1,1);
        enemy_left[2]=enemysheet.crop(2,1,1);
        enemy_left[3]=enemysheet.crop(3,1,1);
        enemy_left[4]=enemysheet.crop(4,1,1);
        enemy_left[5]=enemysheet.crop(5,1,1);
        enemy_left[6]=enemysheet.crop(6,1,1);
        enemy_left[7]=enemysheet.crop(7,1,1);
        enemy_left[8]=enemysheet.crop(8,1,1);


    }
}
