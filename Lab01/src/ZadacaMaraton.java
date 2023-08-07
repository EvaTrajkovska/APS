import java.util.Scanner;
interface IMaraton
{
    Atleticar najdobroVreme();
    int atleticariOd(String s);
}
class Atleticar
{
    String ime, pol, zemja;
    int vozrast;
    double vreme;



    public Atleticar(String ime, String pol, int vozrast, double vreme, String zemja)
    {
        this.ime=ime;
        this.pol=pol;
        this.vozrast=vozrast;
        this.vreme=vreme;
        this.zemja=zemja;
    }

    public String getIme()
    {
        return ime;
    }

    public void setIme(String ime)
    {
        this.ime = ime;
    }

    public String getPol()
    {
        return pol;
    }

    public void setPol(String pol)
    {
        this.pol = pol;
    }

    public int getVozrast()
    {
        return vozrast;
    }

    public void setVozrast(int vozrast)
    {
        this.vozrast = vozrast;
    }

    public double getVreme()
    {
        return vreme;
    }

    public void setVreme(double vreme)
    {
        this.vreme = vreme;
    }

    public String getZemja()
    {
        return zemja;
    }

    public void setZemja(String zemja)
    {
        this.zemja = zemja;
    }

    public String toString()
    {
        return  ime + "\n" + vozrast + "\n" + zemja + "\n" + vreme + "\n";
    }

}

class Maraton implements IMaraton
{
    String mesto;
    int godina;
    Atleticar a[];

    public Maraton(String mesto, int godina, Atleticar[] a)
    {
        this.mesto = mesto;
        this.godina = godina;
        this.a = a;
    }

    public Maraton() {}

    public String getMesto()
    {
        return mesto;
    }

    public void setMesto(String mesto)
    {
        this.mesto = mesto;
    }

    public int getGodina()
    {
        return godina;
    }

    public void setGodina(int godina)
    {
        this.godina = godina;
    }

    public Atleticar[] getA()

    {
        return a;
    }

    public void setA(Atleticar[] a)
    {
        this.a = a;
    }

    public String toString()
    {

        String s=mesto + "\n" + godina + "\n";
        for(int i=0;i<a.length;i++)
        {
            s=s + a[i].toString();
        }
        return s;


    }

    public Atleticar najdobroVreme()
    {
        double min=a[0].getVreme();
        int indeks=0;
        for(int i=1;i<a.length;i++)
        {
            if(a[i].getVreme()<min)
            {
                indeks=i;
                min=a[i].getVreme();
            }
        }
        return a[indeks];
    }

    public int atleticariOd(String s)
    {
        int br=0;
        for(int i=0;i<a.length;i++)
        {
            if(a[i].getZemja().compareTo(s)==0)
            {
                br++;
            }
        }
        return br;
    }

}

public class ZadacaMaraton {

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int n=input.nextInt();
        Atleticar[] atleticari = new Atleticar[n];

        String ime;
        String pol;
        int vozrast;
        double vreme;
        String zemja;

        input.nextLine();

        for(int i=0;i<n;i++)
        {
            ime = input.nextLine();
            pol = input.nextLine();
            vozrast = input.nextInt();
            vreme = input.nextDouble();
            input.nextLine();
            zemja = input.nextLine();
            atleticari[i]=new Atleticar(ime,pol,vozrast,vreme,zemja);
        }

        String mesto;
        int godina;
        String zemjaP;
        mesto = input.nextLine();
        godina = input.nextInt();
        input.nextLine();

        Maraton m1 = new Maraton(mesto, godina, atleticari);
        System.out.print(m1.toString());

        zemjaP = input.nextLine();
        System.out.println("Prvo mesto: " + m1.najdobroVreme().toString());
        System.out.println("Ima vkupno " + m1.atleticariOd(zemjaP) + " atleticar/i od " + zemjaP);
    }
}

