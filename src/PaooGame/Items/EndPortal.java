package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;

public class EndPortal extends Item{
    public EndPortal(RefLinks refLink, float x, float y,int m) {

        super(refLink, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT,m);
        normalBounds.x=(int)x;
        normalBounds.y=(int)y;
        normalBounds.width=20;
        normalBounds.height=20;

    }

    @Override
    public void Update() {


    }

//deseneaza portalul

    @Override
    public void Draw(Graphics g) {
        g.drawImage(Assets.start,(int)x,(int)y, width, height,null);

    }

}
