package PaooGame.States;

import PaooGame.Items.Hero;
import PaooGame.Items.LifeObserver;
import PaooGame.Items.MoneyObserver;
import PaooGame.RefLinks;
import PaooGame.Maps.Map;

import java.awt.*;

/*! \class public class PlayState extends State
    \brief Implementeaza/controleaza jocul.
 */
public class PlayState extends State {
    private Map map;    /*!< Referinta catre harta curenta.*/
    public Hero hero;
    public LifeObserver life;
    public MoneyObserver money;



    /*! \fn public PlayState(RefLinks refLink)
        \brief Constructorul de initializare al clasei

        \param refLink O referinta catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.
     */
    public PlayState(RefLinks refLink,int level) {
        ///Apel al constructorului clasei de baza
        super(refLink);
        hero = Hero.getInstance(refLink);
        refLink.SetHero(hero);
        hero.SetX(0);
        hero.SetY(110);
        hero.SetLife(hero.GetMaxLife());
        ///Construieste harta jocului
        map = new Map(refLink,level);
        ///Referinta catre harta construita este setata si in obiectul shortcut pentru a fi accesibila si in alte clase ale programului.
        refLink.SetMap(map);
        ///Construieste eroul
        life= new LifeObserver();
        hero.addObserver(life);
        money= new MoneyObserver();
        hero.addObserver(money);


    }

    /*! \fn public void Update()
        \brief Actualizeaza starea curenta a jocului.
     */
    @Override
    public void Update() {
        hero.Update();
        if(hero.GetLife()==0)
        {
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            SetState(new DeadState(refLink));
                        }
                    },
                    1000
            );

        }
        map.Update();

    }

    /*! \fn public void Draw(Graphics g)
        \brief Deseneaza (randeaza) pe ecran starea curenta a jocului.

        \param g Contextul grafic in care trebuie sa deseneze starea jocului pe ecran.
     */
    @Override
    public void Draw(Graphics g) {
        map.Draw(g);
        hero.Draw(g);
       // g.drawImage(Resources.TEXTURES.get(Resources.ATTACK), this.player.getAttackBox().x, this.player.getAttackBox().y, this.player.getAttackBox().width, this.player.getAttackBox().height, null);

        //g.setColor(Color.WHITE);
        //g.setFont(new Font("arial", Font.PLAIN, 15));
        //g.drawImage(Assets.heart, 3, 3, Tile.TILE_WIDTH*2/3, Tile.TILE_HEIGHT*2/3, null);
        //g.drawString(this.hero.GetLife()+"/"+this.hero.GetMaxLife(), Tile.TILE_WIDTH*2/3+5, 20);
        life.Draw(g,refLink);
        money.Draw(g,refLink);
        //g.drawImage(Assets.money, 70, 3, Tile.TILE_WIDTH*2/3, Tile.TILE_HEIGHT*2/3, null);
        //g.drawString(this.hero.getMoney()+"", Tile.TILE_WIDTH*2/3+72, 20);
    }


}



