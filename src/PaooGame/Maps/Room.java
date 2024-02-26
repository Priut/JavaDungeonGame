package PaooGame.Maps;

import PaooGame.Items.Enemy;
import PaooGame.Items.Hero;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

public class Room {
    private RefLinks refLink;
    public int w=13;
    public int h=8;
    public int camera[][];
    public int shadowtiles[][];
    public Room(){
        camera=new int[w][h];
    }

    public Room(RefLinks refLink)
    {

        this.refLink = refLink;
    }
    public  void Update()
    {

    }
    public int[][] getData() {
        return camera;
    }

    public Tile getTileAt(int x,int y){
        return Tile.tiles[camera[x][y]];
    }


}


