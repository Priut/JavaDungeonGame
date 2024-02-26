package PaooGame.Items;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import PaooGame.Graphics.Animation;
import PaooGame.RefLinks;
import PaooGame.Graphics.Assets;
//Singleton
public class Hero extends Character {
    //Animatii
    private static Hero h=null;
    private Animation hdown, hup, hleft, hright,hdead,haup,hadown,haleft,haright;//animatia pentru erou fara arma
    private Animation haxedown, haxeup, haxeleft, haxeright,haxeaup,haxeadown,haxealeft,haxearight;//animatia pentru erou cu axe
    private Animation hhammerdown, hhammerup, hhammerleft, hhammerright,hhammeraup,hhammeradown,hhammeraleft,hhammeraright;//animatia pentru erou cu hammer
    private BufferedImage image;/*!< Referinta catre imaginea curenta a eroului.*/
    private int money;
    private int damageTime=50;
    private int level=1;
    public int weapon;

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    public Hero(RefLinks refLink, float x, float y) {
        ///Apel al constructorului clasei de baza
        super(refLink, x, y, Character.DEFAULT_CREATURE_WIDTH, Character.DEFAULT_CREATURE_HEIGHT);
        ///Seteaza imaginea de start a eroului
        image = Assets.heroLeft;
        ///Stabilieste pozitia relativa si dimensiunea dreptunghiului de coliziune, starea implicita(normala)
        normalBounds.x = 16;
        normalBounds.y = 25;
        normalBounds.width = 20;
        normalBounds.height = 20;

        ///Animatie
        hdown = new Animation(100, Assets.hero_down);
        hup = new Animation(100, Assets.hero_up);
        hleft = new Animation(100, Assets.hero_left);
        hright = new Animation(100, Assets.hero_right);
        hdead = new Animation(250, Assets.hero_dead);
        hadown = new Animation(50, Assets.hero_a_down);
        haup = new Animation(50, Assets.hero_a_up);
        haleft = new Animation(50, Assets.hero_a_left);
        haright = new Animation(50, Assets.hero_a_right);

        haxedown = new Animation(100, Assets.hero_axe_down);
        haxeup = new Animation(100, Assets.hero_axe_up);
        haxeleft = new Animation(100, Assets.hero_axe_left);
        haxeright = new Animation(100, Assets.hero_axe_right);
        haxeadown = new Animation(50, Assets.hero_axe_a_down);
        haxeaup = new Animation(50, Assets.hero_axe_a_up);
        haxealeft = new Animation(50, Assets.hero_axe_a_left);
        haxearight = new Animation(50, Assets.hero_axe_a_right);

        hhammerdown = new Animation(100, Assets.hero_hammer_down);
        hhammerup = new Animation(100, Assets.hero_hammer_up);
        hhammerleft = new Animation(100, Assets.hero_hammer_left);
        hhammerright = new Animation(100, Assets.hero_hammer_right);
        hhammeradown = new Animation(50, Assets.hero_hammer_a_down);
        hhammeraup = new Animation(50, Assets.hero_hammer_a_up);
        hhammeraleft = new Animation(50, Assets.hero_hammer_a_left);
        hhammeraright = new Animation(50, Assets.hero_hammer_a_right);
        this.weapon=0;
    }

    public static Hero getInstance(RefLinks refLinks)
    {
        if (h == null)
            h = new Hero(refLinks, 0, 110);

        return h;
    }

    public void addObserver(Observer observer){observers.add(observer);}
    public ArrayList<Observer> getObservers(){return observers;}
    public void notifyObservers(){
        for(int i = 0; i < observers.size(); i++)
            observers.get(i).update(refLink);
    }

    @Override
    public void Update()//actualizeaza pozitia eroului si viata acestuia
    {
        ArrayList<Enemy> e=refLink.GetMap().getEnemies();
        decreaseTime();

        //daca ne intersectam cu enemy eroul pierde viata
        Rectangle r1= new Rectangle((int) (this.x + this.bounds.x), (int) (this.y + this.bounds.y), this.bounds.width, this.bounds.height);
        for(int i=0;i<e.size();i++)
        {
            Rectangle r2= new Rectangle((int) (e.get(i).GetX() + e.get(i).bounds.x), (int) (e.get(i).GetY() + e.get(i).bounds.y), e.get(i).bounds.width, e.get(i).bounds.height);
            if(r2.intersects(r1)) {
                this.damage(1);
            }
        }
        //verificam ce arma are eroul
        if(weapon==0) {
            hdown.update();
            hup.update();
            hleft.update();
            hright.update();
            hdead.update();
            hadown.update();
            haup.update();
            haleft.update();
            haright.update();
        }

        if(weapon==1) {
            haxedown.update();
            haxeup.update();
            haxeleft.update();
            haxeright.update();
            hdead.update();
            haxeadown.update();
            haxeaup.update();
            haxealeft.update();
            haxearight.update();
        }

        if(weapon==2) {
            hhammerdown.update();
            hhammerup.update();
            hhammerleft.update();
            hhammerright.update();
            hdead.update();
            hhammeradown.update();
            hhammeraup.update();
            hhammeraleft.update();
            hhammeraright.update();
        }
            ///Verifica daca a fost apasata o tasta
        GetInput();
            ///Actualizeaza pozitia
        Move();
        checkAttacks();
        notifyObservers();

    }

    private void GetInput()
    {
            ///Implicit eroul nu trebuie sa se deplaseze daca nu este apasata o tasta
        xMove = 0;
        yMove = 0;
            ///Verificare apasare tasta "sus"
        if(refLink.GetKeyManager().up)
        {
            yMove = -speed;
        }
            ///Verificare apasare tasta "jos"
        if(refLink.GetKeyManager().down)
        {
            yMove = speed;
        }
            ///Verificare apasare tasta "left"
        if(refLink.GetKeyManager().left)
        {
            xMove = -speed;
        }
            ///Verificare apasare tasta "dreapta"
        if(refLink.GetKeyManager().right)
        {
            xMove = speed;
        }
    }

    @Override
    public void Draw(Graphics g)
    {

       // Rectangle r2= new Rectangle((int) (refLink.GetGame().getEnemy().GetX() +refLink.GetGame().getEnemy().bounds.x), (int) (refLink.GetGame().getEnemy().GetY()  + refLink.GetGame().getEnemy().bounds.y), refLink.GetGame().getEnemy().bounds.width, refLink.GetGame().getEnemy().bounds.height);


        //g.fillRect((int) (refLink.GetGame().getEnemy().GetX() + refLink.GetGame().getEnemy().bounds.getX()), (int) (refLink.GetGame().getEnemy().GetY() + refLink.GetGame().getEnemy().bounds.getY()), refLink.GetGame().getEnemy().bounds.width, refLink.GetGame().getEnemy().bounds.height);
        g.drawImage(getCurrentAnimationFrame(), (int)x, (int)y, width, height, null);
        //observers.forEach(observer -> observer.);
    }
    //eroul ataca
    private void checkAttacks(){


        Rectangle ar = new Rectangle();
        if(weapon==0)
        {
            int arSize = 20;
            ar.width = arSize;
            ar.height = arSize;
            Rectangle cb = getCollisionBounds(0, 0);
            if (refLink.GetKeyManager().aup) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y - arSize;
            } else if (refLink.GetKeyManager().adown) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y + cb.height;
            } else if (refLink.GetKeyManager().aleft) {
                ar.x = cb.x - arSize;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            } else if (refLink.GetKeyManager().aright) {
                ar.x = cb.x + cb.width;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            } else {
                return;
            }
            ArrayList<Enemy> en=refLink.GetMap().getEnemies();
            for (Enemy enemy : en) {
                if (enemy.getCollisionBounds(0, 0).intersects(ar)) {
                    enemy.damage(1);
                    return;
                }

            }
        }

        if(weapon==1)
        {
            int arSize = 40;
            ar.width = arSize;
            ar.height = arSize;
            Rectangle cb = getCollisionBounds(0, 0);
            if (refLink.GetKeyManager().aup) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y - arSize;
            } else if (refLink.GetKeyManager().adown) {
                ar.x = cb.x + cb.width / 2 - arSize / 2;
                ar.y = cb.y + cb.height;
            } else if (refLink.GetKeyManager().aleft) {
                ar.x = cb.x - arSize;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            } else if (refLink.GetKeyManager().aright) {
                ar.x = cb.x + cb.width;
                ar.y = cb.y + cb.height / 2 - arSize / 2;
            } else {
                return;
            }
            ArrayList<Enemy> en=refLink.GetMap().getEnemies();
            for (Enemy enemy : en) {
                if (enemy.getCollisionBounds(0, 0).intersects(ar)) {
                    enemy.damage(1);
                    return;
                }

            }
        }


    }
    public void addMoney(int m){
        money=money+m;
        //notifyObservers();
    }//adauga bani eroului
    public void setMoney(int m){
        money=m;
    }//adauga bani eroului

    public int getMoney(){
        return money;
    }//returneaza nr de banuti pe care ii are eroul

    public void setWeapon(int w){weapon=w;}//seteaza arma eroului

    private BufferedImage getCurrentAnimationFrame()//returneaza animatia curenta
    {
        if(weapon==0) {
            if (this.life == 0)
                return hdead.getCurrentFrame();
            else if (xMove < 0)
                return hleft.getCurrentFrame();
            else if (xMove > 0)
                return hright.getCurrentFrame();
            else if (yMove < 0)
                return hup.getCurrentFrame();
            else if (yMove > 0)
                return hdown.getCurrentFrame();
            else if (refLink.GetKeyManager().aup)
                return haup.getCurrentFrame();
            else if (refLink.GetKeyManager().adown)
                return hadown.getCurrentFrame();
            else if (refLink.GetKeyManager().aleft)
                return haleft.getCurrentFrame();
            else if (refLink.GetKeyManager().aright)
                return haright.getCurrentFrame();
            else
                return image;
        }
        if(weapon==1) {
            if (this.life == 0)
                return hdead.getCurrentFrame();
            else if (xMove < 0)
                return haxeleft.getCurrentFrame();
            else if (xMove > 0)
                return haxeright.getCurrentFrame();
            else if (yMove < 0)
                return haxeup.getCurrentFrame();
            else if (yMove > 0)
                return haxedown.getCurrentFrame();
            else if (refLink.GetKeyManager().aup)
                return haxeaup.getCurrentFrame();
            else if (refLink.GetKeyManager().adown)
                return haxeadown.getCurrentFrame();
            else if (refLink.GetKeyManager().aleft)
                return haxealeft.getCurrentFrame();
            else if (refLink.GetKeyManager().aright)
                return haxearight.getCurrentFrame();
            else
                return image;
        }
        if(weapon==2) {
            if (this.life == 0)
                return hdead.getCurrentFrame();
            else if (xMove < 0)
                return hhammerleft.getCurrentFrame();
            else if (xMove > 0)
                return hhammerright.getCurrentFrame();
            else if (yMove < 0)
                return hhammerup.getCurrentFrame();
            else if (yMove > 0)
                return hhammerdown.getCurrentFrame();
            else if (refLink.GetKeyManager().aup)
                return hhammeraup.getCurrentFrame();
            else if (refLink.GetKeyManager().adown)
                return hhammeradown.getCurrentFrame();
            else if (refLink.GetKeyManager().aleft)
                return hhammeraleft.getCurrentFrame();
            else if (refLink.GetKeyManager().aright)
                return hhammeraright.getCurrentFrame();
            else
                return image;
        }
        else return null;

    }
    public void damage(int amount) {//cade viata eroului
        if(this.damageTime == 0) {
            if(life>0) {
                this.life -= amount;
                this.damageTime = 50;
            }
        }
    }
    //scade"timpul" astfel incat eroul nu pierde viata instant
    public void decreaseTime() {
        if(this.damageTime > 0) this.damageTime--;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
