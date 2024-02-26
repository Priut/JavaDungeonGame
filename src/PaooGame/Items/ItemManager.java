package PaooGame.Items;

import PaooGame.RefLinks;
import PaooGame.States.LevelWon;
import PaooGame.States.ShopState;
import PaooGame.States.State;
import PaooGame.Tiles.Tile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class ItemManager {
    private RefLinks reflinks;
    private ArrayList<Item> items;

    public ItemManager(RefLinks reflinks)
    {
        this.reflinks=reflinks;
        items=new ArrayList<Item>();
    }
    public void Update()
    {
        Iterator<Item> it = items.iterator();
        while(it.hasNext()){
            collisionwithHero(Hero.getInstance(reflinks));
            Item i = it.next();
            i.Update();
            //singurul item cu m=0 este portalul de iesire..nu e foarte eleganta solutia
            //verifical la ce level suntem pentru a stii daca urmeaza starea intermediara de shop sau cea de final(level won)
            if(i.isPickedUp()&&i.Getm()==0&&Hero.getInstance(reflinks).getLevel()==1)
                State.SetState(new ShopState(reflinks));
            if(i.isPickedUp()&&i.Getm()==0&&Hero.getInstance(reflinks).getLevel()==2)
                State.SetState(new LevelWon(reflinks));
            if(i.isPickedUp()&&i.Getm()!=0){
                reflinks.GetGame().getAudioPlayer().playSound("coin_collect.wav");
                it.remove();
                Hero.getInstance(reflinks).addMoney(i.Getm());
            }


        }
    }

    //functie de coliziune a itemelor cu eroul
    public void collisionwithHero(Hero h){
        for(int i=0;i<this.items.size();i++){
            Rectangle r= new Rectangle((int) (h.x + h.bounds.x), (int) (h.y + h.bounds.y), h.bounds.width, h.bounds.height);
            if(r.intersects(this.items.get(i).normalBounds))
               this.items.get(i).SetisPickedUp(true);
        }
    }

//deseneaza itemele
    public void Draw(Graphics g)
    {
        for(int i=0;i<items.size();i++)
        {
            Item it=items.get(i);
            it.Draw(g);
        }
    }
//adauga un item
    public void addItem(Item i){items.add(i);}

    public RefLinks getReflinks(){ return this.reflinks; }
}
