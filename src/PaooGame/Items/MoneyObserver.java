package PaooGame.Items;

import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;

public class MoneyObserver implements Observer{
    Integer money;

    public MoneyObserver(){
        super();
        money = 0;
    }
    public void update(RefLinks refLinks){
        money = Hero.getInstance(refLinks).getMoney();
    }

    public void Draw(Graphics g,RefLinks refLinks){
        g.setColor(Color.WHITE);
        g.setFont(new Font("arial", Font.PLAIN, 15));
        g.drawImage(Assets.money, 70, 3, Tile.TILE_WIDTH*2/3, Tile.TILE_HEIGHT*2/3, null);
        g.drawString(money+"", Tile.TILE_WIDTH*2/3+72, 20);
    }
}
