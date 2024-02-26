package PaooGame.Items;

import PaooGame.RefLinks;
import PaooGame.States.LevelWon;
import PaooGame.States.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class EnemyManager {
    private RefLinks reflinks;
    private ArrayList<Enemy> enemies;

    public EnemyManager(RefLinks reflinks)
    {
        this.reflinks=reflinks;
        enemies=new ArrayList<Enemy>();
    }
    public void Update()
    {

        Iterator<Enemy> it = enemies.iterator();
        while(it.hasNext()){
            while(it.hasNext()){
                Enemy en = it.next();
                en.Update();
                if(en.GetActive()==false) {//Daca sheletul a murit
                    reflinks.GetGame().getAudioPlayer().playMusic("enemy_dies.wav");
                    it.remove();
                }

            }
        }
    }
//Desenam toti scheletii
    public void Draw(Graphics g)
    {
        for(int i=0;i<enemies.size();i++)
        {
            Item it=enemies.get(i);
            it.Draw(g);
        }
    }

    public void addEnemies(Enemy i){enemies.add(i);}//adaugam un enemy
    public ArrayList<Enemy> getEnemies(){return  enemies;}//returneaza toti scheletii
    public void setHpAll(int h){//setam hp-ul tuturor sheletilor
        for(int i=0;i<enemies.size();i++)
        {
            Enemy it=enemies.get(i);
            it.setHp(h);
        }
    }
}
