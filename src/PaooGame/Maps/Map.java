package PaooGame.Maps;

import PaooGame.Exceptions.InvalidTileIdException;
import PaooGame.GameWindow.GameWindow;
import PaooGame.Items.*;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/*! \class public class Map
    \brief Implementeaza notiunea de harta a jocului.
 */
public class Map extends Room {
    private RefLinks refLink;   /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/
    private int width;          /*!< Latimea hartii in numar de dale.*/
    private int height;         /*!< Inaltimea hartii in numar de dale.*/
    public Room rooms[][];      //matrice de rooms petru primul layer al hartii
    private Room shadows[][];   //matrice de rooms petru al doilea layer al hartii
    public int currentX = 0;      //retinem pozitia camerei curente
    public int currentY = 0;
    private ItemManager[][] chests;//retinem chest-urile
    public EnemyManager[][] enemies;//retinem sheletii
    private int level;

    /*! \fn public Map(RefLinks refLink)
        \brief Constructorul de initializare al clasei.

        \param refLink O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public Map(RefLinks refLink, int level) {
        super(refLink);
        /// Retine referinta "shortcut".
        this.refLink = refLink;
        this.level = level;
        if (level == 1) {
            chests = new ItemManager[3][3];
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    chests[i][j] = new ItemManager(refLink);
            enemies = new EnemyManager[3][3];
            for (int i = 0; i < 3; i++)
                for (int j = 0; j < 3; j++)
                    enemies[i][j] = new EnemyManager(refLink);
        }
        if (level == 2) {
            chests = new ItemManager[4][4];
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    chests[i][j] = new ItemManager(refLink);
            enemies = new EnemyManager[4][4];
            for (int i = 0; i < 4; i++)
                for (int j = 0; j < 4; j++)
                    enemies[i][j] = new EnemyManager(refLink);
        }
        ///incarca harta de start. Functia poate primi ca argument id-ul hartii ce poate fi incarcat.
        LoadWorld(level);

    }

    /*! \fn public  void Update()
        \brief Actualizarea hartii in functie de evenimente (un copac a fost taiat)
     */
    public void Update() {
        chests[currentX][currentY].Update();
        enemies[currentX][currentY].Update();
    }

    public void Draw(Graphics g) {
        ///Se parcurge matricea de dale (codurile aferente) si se deseneaza harta respectiva
        //int[] xpoints={(int)(refLink.GetMap().getEnemies().get(0).GetX()+20 /*+ refLink.GetMap().getEnemies().get(0).GetXMove()*/),(int)(refLink.GetMap().getEnemies().get(0).GetX() + /*refLink.GetMap().getEnemies().get(0).GetXMove()*/+10),(int)(refLink.GetHero().GetX()+10/*+refLink.GetHero().GetXMove()*/),(int)(refLink.GetHero().GetX()+10+/*refLink.GetHero().GetXMove()*/+10)};
        //int[] ypoints={(int)(refLink.GetMap().getEnemies().get(0).GetY()+20 /*+ refLink.GetMap().getEnemies().get(0).GetYMove()*/),(int)(refLink.GetMap().getEnemies().get(0).GetY() /*+ refLink.GetMap().getEnemies().get(0).GetYMove()*/+10),(int)(refLink.GetHero().GetY()+10/*+refLink.GetHero().GetYMove()*/),(int)(refLink.GetHero().GetY()+10/*+refLink.GetHero().GetYMove()*/+10)};
        //Polygon polygon=new Polygon(xpoints,ypoints,4);

            changeRoom(Hero.getInstance(refLink));
            for (int y = 0; y < refLink.GetGame().GetHeight() / Tile.TILE_HEIGHT; y++) {
                for (int x = 0; x < refLink.GetGame().GetWidth() / Tile.TILE_WIDTH; x++) {

                    getTileAt( x, y).Draw(g, (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
                    getShadowTileAt( x, y).Draw(g, (int) x * Tile.TILE_HEIGHT, (int) y * Tile.TILE_WIDTH);
                }
            }
            chests[currentX][currentY].Draw(g);
            enemies[currentX][currentY].Draw(g);

        //g.fillPolygon(polygon);


    }

    //functie pentru schimbarea camerei curente
    public void changeRoom(Hero hero) {
        if (hero.GetX() < 0) {
            this.currentX--;
            hero.SetX(GameWindow.GetWndWidth());
            refLink.GetGame().getAudioPlayer().playSound("thunder1.wav");
        } else if (hero.GetX() > GameWindow.GetWndWidth()) {
            this.currentX++;
            hero.SetX(0);
        } else if (hero.GetY() < 0) {
            this.currentY--;
            hero.SetY(GameWindow.GetWndHeight());
        } else if (hero.GetY() > GameWindow.GetWndHeight()) {
            this.currentY++;
            hero.SetY(0);
            refLink.GetGame().getAudioPlayer().playSound("thunder2.wav");
        }
    }

    private void LoadWorld(int level) {
        String FileMap1 = null,FileMap2=null,FileShadows1=null,FileShadows2=null;
        String FileEnemy1 = null,FileEnemy2=null,FileChest1=null,FileChest2=null;
        BufferedReader reader;
        Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:game.db");
            connection.setAutoCommit(false);
            stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Game;" );
            while ( rs.next() ) {
                int id = rs.getInt("Id");
                String file = rs.getString("File");
                if(id==1)
                    FileMap1=file;
                else if(id==2)
                    FileShadows1=file;
                else if(id==3)
                    FileMap2=file;
                else if(id==4)
                    FileShadows2=file;
                else if(id==5)
                    FileEnemy1=file;
                else if(id==6)
                    FileChest1=file;
                else if(id==7)
                    FileEnemy2=file;
                else if(id==8)
                    FileChest2=file;
            }
            rs.close();
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        if (level == 1) {
            ///Se stabileste latimea hartii in numar de camere
            width = 3;
            ///Se stabileste inaltimea hartii in numar de camere
            height = 3;
            ///Se construieste matricea de coduri de dale

            rooms = new Room[width][height];
            shadows = new Room[width][height];
            int[][] map1=DungeonLvl1(FileMap1);
            int[][]shadows1=Shadows1(FileShadows1);
            //Se incarca matricea cu coduri
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    rooms[x][y] = new Room();
                    shadows[x][y] = new Room();
                    //o icercare de a pune random enemy-urile, din pacate jumatate erau in pereti
               /*Random rand=new Random();
               int enemyx= rand.nextInt(8);
               int enemyy= rand.nextInt(13);
               while(getTileAt(enemyy, enemyx).IsSolid())
               {
                   Random rand1=new Random();
                   enemyx= rand1.nextInt(8);
                   enemyy= rand1.nextInt(13);
               }
               rooms[x][y].addEnemies(new Enemy(refLink,enemyx*Tile.TILE_WIDTH,enemyy*Tile.TILE_HEIGHT,2,h));
                */
                    for (int z = 0; z < 8; z++)
                        for (int q = 0; q < 13; q++) {
                            rooms[x][y].camera[q][z] = map1[z + y * 7][q + x * 12];
                            shadows[x][y].camera[q][z] = shadows1[z + y * 7][q + x * 12];
                        }
                }
            }
            //initializare chest-uri pe camere
            try {
                reader = new BufferedReader(new FileReader(FileChest1));
                String line = reader.readLine();
                while (line != null) {
                    String[] c=line.split(" ");
                    chests[Integer.parseInt(c[0])][Integer.parseInt(c[1])].addItem(new Chest(refLink, Integer.parseInt(c[2]) * Tile.TILE_WIDTH, Integer.parseInt(c[3]) * Tile.TILE_HEIGHT, Integer.parseInt(c[4])));
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //Portalul de final
            chests[2][0].addItem(new EndPortal(refLink, 12 * Tile.TILE_WIDTH, 2 * Tile.TILE_HEIGHT, 0));
            //initializare chest-uri pe camere
            try {
                reader = new BufferedReader(new FileReader(FileEnemy1));
                String line = reader.readLine();
                while (line != null) {
                    String[] c=line.split(" ");
                    enemies[Integer.parseInt(c[0])][Integer.parseInt(c[1])].addEnemies(new Enemy(refLink, Integer.parseInt(c[2]), Integer.parseInt(c[3])));
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if(level==2){
            ///Se stabileste latimea hartii in numar de camere
            width = 4;
            ///Se stabileste inaltimea hartii in numar de camere
            height = 4;
            ///Se construieste matricea de coduri de dale

            rooms = new Room[width][height];
            shadows = new Room[width][height];

            int[][] map2=DungeonLvl2(FileMap2);
            int[][]shadows2=Shadows2(FileShadows2);
            //Se incarca matricea cu coduri
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    rooms[x][y] = new Room();
                    shadows[x][y] = new Room();
                    for (int z = 0; z < 8; z++)
                        for (int q = 0; q < 13; q++) {
                            rooms[x][y].camera[q][z] = map2[z + y * 7][q + x * 12];
                            shadows[x][y].camera[q][z] = shadows2[z + y * 7][q + x * 12];
                        }
                }
            }
            //initializare enemy pe camere

            try {
                reader = new BufferedReader(new FileReader(FileEnemy2));
                String line = reader.readLine();
                while (line != null) {
                    String[] c=line.split(" ");
                    enemies[Integer.parseInt(c[0])][Integer.parseInt(c[1])].addEnemies(new Enemy(refLink, Integer.parseInt(c[2]), Integer.parseInt(c[3])));
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //initializare chest-uri pe camere
            try {
                reader = new BufferedReader(new FileReader(FileChest2));
                String line = reader.readLine();
                while (line != null) {
                    String[] c=line.split(" ");
                    chests[Integer.parseInt(c[0])][Integer.parseInt(c[1])].addItem(new Chest(refLink, Integer.parseInt(c[2]) * Tile.TILE_WIDTH, Integer.parseInt(c[3]) * Tile.TILE_HEIGHT, Integer.parseInt(c[4])));
                    line = reader.readLine();
                }
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            chests[3][3].addItem(new EndPortal(refLink, 12 * Tile.TILE_WIDTH, 6 * Tile.TILE_HEIGHT, 0));
        }
    }

    public Tile getTileAt(int i, int j) {
        Tile t = Tile.gol;
        if (i == 13)
            t = Tile.tiles[rooms[currentX + 1][currentY].camera[i - 13][j]];
        else if (i == 14)
            t = Tile.tiles[rooms[currentX + 1][currentY].camera[i - 14][j]];
        else if (j == 8)
            t = Tile.tiles[rooms[currentX][currentY + 1].camera[i][j - 8]];
        else if (j == 9)
            t = Tile.tiles[rooms[currentX][currentY + 1].camera[i][j - 9]];
        else t = Tile.tiles[rooms[currentX][currentY].camera[i][j]];

        return t;
    }

    public Tile getShadowTileAt(int i, int j) {
        Tile t = Tile.gol;
        if (i == 13)
            t = Tile.tiles[shadows[currentX + 1][currentY].camera[i - 13][j]];
        else if (i == 14)
            t = Tile.tiles[shadows[currentX + 1][currentY].camera[i - 14][j]];
        else if (j == 8)
            t = Tile.tiles[shadows[currentX][currentY + 1].camera[i][j - 8]];
        else if (j == 9)
            t = Tile.tiles[shadows[currentX][currentY + 1].camera[i][j - 9]];
        else t = Tile.tiles[shadows[currentX][currentY].camera[i][j]];

        return t;
    }

    public ArrayList<Enemy> getEnemies() {
        return enemies[currentX][currentY].getEnemies();
    }

    private int[][] DungeonLvl1(String file) {
        ///Citirea din fisier a matricii de coduri
        int[][]map=new int[22][37];
        try {
            Scanner scanner=new Scanner(new File(file));
            for(int i = 0; i < 22;  i++){
                for(int j = 0; j < 37; j++){
                    int id=scanner.nextInt();
                    if(id<0||id>35)
                        throw new InvalidTileIdException("Invalid Tile ID:"+id+"");
                    map[i][j] = id;
                }
            }

        } catch (FileNotFoundException | InvalidTileIdException e) {
            e.printStackTrace();
        }
        return map;
    }

    private int[][] DungeonLvl2(String file) {
        ///Citirea din fisier a matricii de coduri
        int[][]map=new int[29][49];
        try {
            Scanner scanner=new Scanner(new File(file));
            for(int i = 0; i < 29;  i++){
                for(int j = 0; j < 49; j++){
                    int id=scanner.nextInt();
                    if(id<0||id>35)
                        throw new InvalidTileIdException("Invalid Tile ID:"+id+"");
                    map[i][j] = id;
                }
            }

        } catch (FileNotFoundException | InvalidTileIdException e) {
            e.printStackTrace();
        }
        return map;
    }

    private int[][] Shadows1(String file)
    {
        ///Citirea din fisier a matricii de coduri
        int[][]map=new int[22][37];
        try {
            Scanner scanner=new Scanner(new File(file));
            for(int i = 0; i < 22;  i++){
                for(int j = 0; j < 37; j++){
                    int id=scanner.nextInt();
                    if(id<0||id>35)
                        throw new InvalidTileIdException("Invalid Tile ID:"+id+"");
                    map[i][j] = id;
                }
            }

        } catch (FileNotFoundException | InvalidTileIdException e) {
            e.printStackTrace();
        }
        return map;


    }

    private int[][] Shadows2(String file)
    {
        ///Citirea din fisier a matricii de coduri
        int[][]map=new int[29][49];
        try {
            Scanner scanner=new Scanner(new File(file));
            for(int i = 0; i < 29;  i++){
                for(int j = 0; j < 49; j++){
                    int id=scanner.nextInt();
                    if(id<0||id>35)
                        throw new InvalidTileIdException("Invalid Tile ID:"+id+"");
                    map[i][j] = id;
                }
            }

        } catch (FileNotFoundException | InvalidTileIdException e) {
            e.printStackTrace();
        }
        return map;
    }

}