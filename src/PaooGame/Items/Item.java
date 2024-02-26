package PaooGame.Items;

import PaooGame.RefLinks;

import java.awt.*;
import java.util.ArrayList;

public abstract class Item
{
    protected float x;                  /*!< Pozitia pe axa X a "tablei" de joc a imaginii entitatii.*/
    protected float y;                  /*!< Pozitia pe axa Y a "tablei" de joc a imaginii entitatii.*/
    protected int width;                /*!< Latimea imaginii entitatii.*/
    protected int height;               /*!< Inaltimea imaginii entitatii.*/
    protected Rectangle bounds;         /*!< Dreptunghiul curent de coliziune.*/
    protected Rectangle normalBounds;   /*!< Dreptunghiul de coliziune aferent starii obisnuite(spatiul ocupat de entitate in mod normal), poate fi mai mic sau mai mare decat dimensiunea imaginii sale.*/
    protected RefLinks refLink;         /*!< O referinte catre un obiect "shortcut", obiect ce contine o serie de referinte utile in program.*/

    protected boolean pickedUp = false;//variabila care retine daca eoul s a intersectat cu respectivui item
    protected int m=0;//banutii pe care ii obtine eroul daca colecteaza acest item

    public Item(RefLinks refLink, float x, float y, int width, int height,int m)
    {
        this.x = x;             /*!< Retine coordonata pe axa X.*/
        this.y = y;             /*!< Retine coordonata pe axa X.*/
        this.width = width;     /*!< Retine latimea imaginii.*/
        this.height = height;   /*!< Retine inaltimea imaginii.*/
        this.refLink = refLink; /*!< Retine the "shortcut".*/

            ///Creaza dreptunghi de coliziune pentru modul normal, aici a fost stabilit la dimensiunea imaginii dar poate fi orice alta dimensiune
        normalBounds = new Rectangle(0, 0, width, height);
            ///Creaza dreptunghi de coliziune pentru modul de atack, aici a fost stabilit la dimensiunea imaginii dar poate fi orice alta dimensiune
            ///Dreptunghiul de coliziune implicit este setat ca fiind cel normal
        bounds = normalBounds;
        this.m=m;
    }

        ///Metoda abstracta destinata actualizarii starii curente
    public abstract void Update();
        ///Metoda abstracta destinata desenarii starii curente
    public abstract void Draw(Graphics g);

    /*! \fn public float GetX()
        \brief Returneaza coordonata pe axa X.
     */
    public float GetX()
    {
        return x;
    }

    /*! \fn public float GetY()
        \brief Returneaza coordonata pe axa Y.
     */
    public float GetY()
    {
        return y;
    }

    /*! \fn public float GetWidth()
        \brief Returneaza latimea entitatii.
     */
    public int GetWidth()
    {
        return width;
    }

    /*! \fn public float GetHeight()
        \brief Returneaza inaltimea entitatii.
     */
    public int GetHeight()
    {
        return height;
    }

    /*! \fn public float SetX()
        \brief Seteaza coordonata pe axa X.
     */
    public void SetX(float x)
    {
        this.x = x;
    }

    /*! \fn public float SetY()
        \brief Seteaza coordonata pe axa Y.
     */
    public void SetY(float y)
    {
        this.y = y;
    }

    /*! \fn public float SetWidth()
        \brief Seteaza latimea imaginii entitatii.
     */
    public void SetWidth(int width)
    {
        this.width = width;
    }

    /*! \fn public float SetHeight()
        \brief Seteaza inaltimea imaginii entitatii.
     */
    public void SetHeight(int height)
    {
        this.height = height;
    }

    public boolean isPickedUp() {
        return pickedUp;
    }//seteaza daca item l e colectat sau nu
    public void SetisPickedUp(boolean b) {
        pickedUp=b;
    }//returneaza is picked up
    public int Getm() {
        return m;
    }//returneaza banutii
}
