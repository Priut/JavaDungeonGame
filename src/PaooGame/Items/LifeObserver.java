package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class LifeObserver implements Observer{
    Integer life;

    public LifeObserver(){
        super();
        life = 10;
    }
    public void update(RefLinks refLinks){
        life = Hero.getInstance(refLinks).GetLife();
    }

    public void Draw(Graphics g,RefLinks refLinks){
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 15));
        g.drawImage(Assets.heart, 3, 3, Tile.TILE_WIDTH*2/3, Tile.TILE_HEIGHT*2/3, null);
        g.drawString(life+"/"+Hero.getInstance(refLinks).GetMaxLife(), Tile.TILE_WIDTH*2/3+5, 20);
    }
}
