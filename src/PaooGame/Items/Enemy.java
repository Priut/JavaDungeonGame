package PaooGame.Items;

import PaooGame.Graphics.Animation;
import PaooGame.Graphics.Assets;
import PaooGame.RefLinks;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Enemy extends Character {


    private Animation edown,eup,eleft,eright;
    private BufferedImage imageup,imagedown,imageleft,imageright;/*!< Referinta catre imaginea curenta a eroului.*/
    private int damageTime=0;

    public Enemy(RefLinks refLinks, float x, float y) {
        super(refLinks,x,y,Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        super.speed = 1;
        //initializam animatiile
        edown=new Animation(100, Assets.enemy_down);
        eup=new Animation(100,Assets.enemy_up);
        eleft=new Animation(100,Assets.enemy_left);
        eright=new Animation(100,Assets.enemy_right);

        imageup = Assets.enemy_up[0];
        imagedown = Assets.enemy_down[0];
        imageleft = Assets.enemy_left[0];
        imageright = Assets.enemy_right[0];
        //bound ul de coliziune a enemy-ului
        normalBounds.x = 16;
        normalBounds.y = 25;
        normalBounds.width = 20;
        normalBounds.height = 20;

        xMove = 0;
        yMove = 0;
    }

       // int[] xpoints={(int)(x + xMove),(int)(x+xMove+1),(int)(Hero.getInstance(refLink).GetX()+Hero.getInstance(refLink).GetXMove()),(int)(Hero.getInstance(refLink).GetX()+Hero.getInstance(refLink).GetXMove()+1)};
       // int[] ypoints={(int)(y + yMove),(int)(y+yMove+1),(int)(Hero.getInstance(refLink).GetY()+Hero.getInstance(refLink).GetYMove()),(int)(Hero.getInstance(refLink).GetY()+Hero.getInstance(refLink).GetYMove()+1)};
       // polygon=new Polygon(xpoints,ypoints,4);





    public void Update() {
        decreaseTime();
        edown.update();
        eup.update();
        eleft.update();
        eright.update();
        Move();

    }

//Desenam enemy-ul
    @Override
    public void Draw(Graphics g) {

        g.drawImage(getCurrentAnimationFrame(), (int)x, (int)y, width, height, null);
        //g.drawString(String.valueOf(life),(int)x, (int)y);
    }
   //o incercare de a face ca enemy-ul sa nu ne vada prin pereti
    //din pacate o incercare esuata
    //voiam sa fac un poligan intre ochiieroului si cei al scheletilor si apoi sa verific daca intersecteaza un tile
    //solid si daca da sa nu mai mut sheletul.. deocamdata nu prea inteleg de ce nu merge, poligonul se deseneaza corect
    public boolean checkpath(){
        int[] xpoints={(int)(refLink.GetMap().getEnemies().get(0).GetX()+20),(int)(refLink.GetMap().getEnemies().get(0).GetX() + +10),(int)(Hero.getInstance(refLink).GetX()+10),(int)(Hero.getInstance(refLink).GetX()+20)};
        int[] ypoints={(int)(refLink.GetMap().getEnemies().get(0).GetY()+20 ),(int)(refLink.GetMap().getEnemies().get(0).GetY()+10),(int)(Hero.getInstance(refLink).GetY()+10),(int)(Hero.getInstance(refLink).GetY()+20)};
        Polygon polygon=new Polygon(xpoints,ypoints,4);
        return !collisionWithpoly(polygon);
    }
    public boolean collisionWithpoly(Polygon poly) {
        for(int x = 0; x < 12; x++)
            for(int y = 0; y < 8; y++) {
                if(poly.intersects(refLink.GetMap().getTileAt(x,y)) && refLink.GetMap().getTileAt(x,y).IsSolid())
                    return true;
            }
        return false;
    }
    //functia de miscare a sheletilor
    @Override
    public void Move() {
        float dx=Hero.getInstance(refLink).GetX() - this.GetX();
        float dy= Hero.getInstance(refLink).GetY() - this.GetY();
        //xMove = Hero.getInstance(refLink).GetX() - this.GetX();
        //yMove = Hero.getInstance(refLink).GetY() - this.GetY();
        double norm = Math.sqrt(dx * dx + dy * dy);

        if (norm!=0&&checkpath())
        {
            xMove = (float) (dx*(speed / norm));
            yMove = (float) (dy*(speed / norm));


            if (xMove > 0) {//Moving right
                int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;

                if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                        !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                    x += xMove;
                }
            } else if (xMove < 0) {//Moving left
                int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;

                if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) &&
                        !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)) {
                    x += xMove;
                }
            }
            if (yMove < 0) {//Up
                int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;

                if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                            !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {
                    y += yMove;
                }
            } else if (yMove > 0) {//Down
                int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

                if (!collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) &&
                        !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)) {

                    y += yMove;
                }
            }

        }


    }


    public int getHp() {
        return life;
    }//Returneaza viata unui schelet
    public void setHp(int h) {
        life=h;
    }//Seteaza viata unui schelet

    //Returneaza animatia curenta pentru a fi randata pe ecran
    private BufferedImage getCurrentAnimationFrame() {
        if(xMove<0)
        {
            int tx = (int) (x + xMove + bounds.x) / Tile.TILE_WIDTH;
            if(collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) ||
                    collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
                return imageleft;
            }
            else
                return eleft.getCurrentFrame();
        }
        else if(xMove>0){//Moving right
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILE_WIDTH;

            if(collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILE_HEIGHT) ||
                    collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILE_HEIGHT)){
                return imageright;

            }
            else return eright.getCurrentFrame();
        }


        else if(yMove<0)
        {//Up
            int ty = (int) (y + yMove + bounds.y) / Tile.TILE_HEIGHT;

            if(collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) ||
                    collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
                return imageup;
            }
            else return eup.getCurrentFrame();
        }
        else if(yMove>0){//Down
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILE_HEIGHT;

            if(collisionWithTile((int) (x + bounds.x) / Tile.TILE_WIDTH, ty) ||
                    collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILE_WIDTH, ty)){
                return imagedown;
            }
            else return edown.getCurrentFrame();
        }
        else
            return imagedown;


    }

    //Scade viata scheletului iar daca aceasta scade sub 0 il dezantivam pentru a ii putea da remove din enemy manager
    @Override
    public void damage(int amount) {

        if(this.damageTime == 0) {
            if (life > 0) {
                this.life -= amount;
                this.damageTime = 7;
            }
        }
        if(life<=0)
            active=false;
    }

    public void decreaseTime() {
        if(this.damageTime > 0) this.damageTime--;
    }



}

