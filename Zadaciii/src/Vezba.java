/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class CBHT<K extends Comparable<K>, E> {

    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    public SLLNode<MapEntry<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(String namena, K targetKey) {
        // Find which if any node of this CBHT contains an entry whose key is
        // equal
        // to targetKey. Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) { // Insert the entry <key, val> into this CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                // Make newEntry replace the existing entry ...
                curr.element = newEntry;
                return;
            }
        }
        // Insert newEntry at the front of the 1WLL in bucket b ...
        buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

    public boolean get(boolean equals) {
        // TODO Auto-generated method stub
        return false;
    }

    public Object get(String string) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean containsKey(String username) {
        // TODO Auto-generated method stub
        return false;
    }


}

class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {

    // Each MapEntry object is a pair consisting of a key (a Comparable
    // object) and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo(K that) {
        // Compare this map entry to that map entry.
        @SuppressWarnings("unchecked")
        MapEntry<K, E> other = (MapEntry<K, E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString() {
        return "<" + key + "," + value + ">";
    }
}

public class Vezba{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT<String, String> tabela = new CBHT<String, String>(2*N+1);
        for(int i=0;i<N;i++){
            String line=br.readLine();
            String []pom=line.split(" ");
            String imeLek=pom[0];
            String namena=pom[1];
            String lek_cena=pom[0]+" "+pom[2];
            int cena=Integer.parseInt(pom[2]);
            String s=imeLek+" "+cena;
           SLLNode<MapEntry<String, String>> h = tabela.search(namena,lek_cena);
           if(h==null){
               tabela.insert(namena,lek_cena);
        }else{
               String ceni=tabela.buckets[h].value;
           }

    }
    }

}
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

class SLLNode<E> {
    public String value;
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class CBHT<K extends Comparable<K>, E> {

    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    SLLNode<MapEntry<K, E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K, E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K, E>> search(K targetKey) {
        // Find which if any node of this CBHT contains an entry whose key is
        // equal
        // to targetKey. Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) { // Insert the entry <key, val> into this CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                // Make newEntry replace the existing entry ...
                curr.element = newEntry;
                return;
            }
        }
        // Insert newEntry at the front of the 1WLL in bucket b ...
        buckets[b] = new SLLNode<MapEntry<K, E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        for (SLLNode<MapEntry<K, E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K, E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

    public boolean get(boolean equals) {
        // TODO Auto-generated method stub
        return false;
    }

    public Object get(String string) {
        // TODO Auto-generated method stub
        return null;
    }

    public boolean containsKey(String username) {
        // TODO Auto-generated method stub
        return false;
    }

}

class MapEntry<K extends Comparable<K>, E> implements Comparable<K> {

    // Each MapEntry object is a pair consisting of a key (a Comparable
    // object) and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry(K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo(K that) {
        // Compare this map entry to that map entry.
        @SuppressWarnings("unchecked")
        MapEntry<K, E> other = (MapEntry<K, E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString() {
        return "<" + key + "," + value + ">";
    }
}


public class Vezba{
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(br.readLine());
        String menadzString="";
        SLLNode<MapEntry<String,Integer>>tmp=null;
        CBHT<String,String>table=new CBHT<String,String>(2*n+1);
        CBHT<String,Integer>table2=new CBHT<String,Integer>(2*n+1);
        for (int i=0;i<n;i++) {
            String line = br.readLine();
            String[] pom = line.split(" ");
            String vraboten = pom[0];
            String menadz = pom[1];
            table.insert(vraboten, menadz);
            if (!menadzString.contains(menadz)) {
                menadzString += menadz + " ";
            }
            tmp = table2.search(menadz);
            if (tmp == null) {
                if (vraboten.compareTo(menadz) != 0) {
                    table2.insert(menadz, 1);
                }
            } else {
                int vrednost = tmp.element.value + 1;
                if (vraboten.compareTo(menadz) != 0) {
                    table2.insert(menadz, vrednost);
                }
            }
        }
        System.out.println(menadzString);
        String s1="{";
        String s2="";
        SLLNode<MapEntry<String,String>>tmp1=null;
        SLLNode<MapEntry<String,Integer>>tmp2=null;
        String[]pomenadz=menadzString.split(" ");
        for (int i=0;i< pomenadz.length;i++){
            tmp2=table2.search(pomenadz[i]);
            if(tmp2==null){
                return;
            }else{
                tmp1= table.search(pomenadz[i]);
                if(tmp1==null){
                    s2+=("*the manager "+pomenadz[i]+"is not an employee");
                }else{
                    if(s1!="{"){
                        s1+=","+pomenadz[i]+" "+tmp2.element.value;
                    }else{
                        s1+=pomenadz[i]+" "+tmp2.element.value;
                    }
                }
            }
        }
        if(s2==""){
            s2+="(all managers are employees)";
        }
        System.out.println(s1+"}");
        System.out.println(s2);
    }
}


/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class MapEntry<K extends Comparable<K>,E> implements Comparable<K> {

    // Each MapEntry object is a pair consisting of a key (a Comparable
    // object) and a value (an arbitrary object).
    K key;
    E value;

    public MapEntry (K key, E val) {
        this.key = key;
        this.value = val;
    }

    public int compareTo (K that) {
        // Compare this map entry to that map entry.
        @SuppressWarnings("unchecked")
        MapEntry<K,E> other = (MapEntry<K,E>) that;
        return this.key.compareTo(other.key);
    }

    public String toString () {
        return "<" + key + "," + value + ">";
    }
}

class SLLNode<E> {
    protected E element;
    protected SLLNode<E> succ;

    public SLLNode(E elem, SLLNode<E> succ) {
        this.element = elem;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

class CBHT<K extends Comparable<K>, E> {

    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    private SLLNode<MapEntry<K,E>>[] buckets;

    @SuppressWarnings("unchecked")
    public CBHT(int m) {
        // Construct an empty CBHT with m buckets.
        buckets = (SLLNode<MapEntry<K,E>>[]) new SLLNode[m];
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % buckets.length;
    }

    public SLLNode<MapEntry<K,E>> search(K targetKey) {
        // Find which if any node of this CBHT contains an entry whose key is
        // equal
        // to targetKey. Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry<K, E>) curr.element).key))
                return curr;
        }
        return null;
    }

    public void insert(K key, E val) {		// Insert the entry <key, val> into this CBHT.
        MapEntry<K, E> newEntry = new MapEntry<K, E>(key, val);
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry<K, E>) curr.element).key)) {
                // Make newEntry replace the existing entry ...
                curr.element = newEntry;
                return;
            }
        }
        // Insert newEntry at the front of the 1WLL in bucket b ...
        buckets[b] = new SLLNode<MapEntry<K,E>>(newEntry, buckets[b]);
    }

    public void delete(K key) {
        // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        for (SLLNode<MapEntry<K,E>> pred = null, curr = buckets[b]; curr != null; pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry<K,E>) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }

    public String toString() {
        String temp = "";
        for (int i = 0; i < buckets.length; i++) {
            temp += i + ":";
            for (SLLNode<MapEntry<K,E>> curr = buckets[i]; curr != null; curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }

}


public class KumanovskiDijalekt {
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(
                System.in));
        int N = Integer.parseInt(br.readLine());
        CBHT <String, String> tabela = new CBHT<String, String>(2*N+1);
        SLLNode<MapEntry<String, String>> tmp = null;
        String rechnik[]=new String[N];
        for(int i=0;i<N;i++){
            rechnik[i]=br.readLine();
            String []deli=rechnik[i].split(" ");
            tabela.insert(deli[0], deli[1]);
        }
        String tekst=br.readLine();
        String []pom= tekst.split(" ");
       for (int i=0; i< pom.length; i++)
       {
           String zbor = pom[i];
           boolean isgolema = Character.isUpperCase(zbor.charAt(0));
           boolean isbukva = Character.isAlphabetic(zbor.charAt(zbor.length()-1));
           char posledna = zbor.charAt(zbor.length()-1);
         //  tmp=tabela.search(zbor);
           if(isgolema)
           {
               if(zbor.length()==1)
               {
                   zbor=zbor.toLowerCase();
               }
               else
               {
                   zbor = Character.toLowerCase(zbor.charAt(0))+zbor.substring(1);
               }
           }
           if(!isbukva)
           {
               zbor = zbor.substring(0 , zbor.length()-1);
           }
           tmp = tabela.search(zbor);

           if(tmp==null)
           {
               System.out.print(pom[i]+" ");
           }
           else
           {
               String novzbor = tmp.element.value;
               if(isgolema)
               {

                   novzbor = Character.toUpperCase(novzbor.charAt(0))+novzbor.substring(1);
                   System.out.print(novzbor+" ");
               }
               else if(!isbukva)
               {

                   novzbor = novzbor+posledna;
                   System.out.print(novzbor+" ");
               }
               else{
                   System.out.print(tmp.element.value+" ");
               }

           }

           }

    }

}













5
Nutela Vitaminka 240
Oreo Kanela 340
Nutela Kanela 550
Milka Vitaminka 220
Kinder Shtark 490
Vitaminka




3 3
jessie 25000
jackie 22000
ashley 20000

jessie 30000
jackie 25000
john 18000
3
070111222 AleksandarStojmenski
071222333 IlinkaIvanovska
022333444 BojanaKoteska
046464646 AnastasMisev
046646463 SlobodanKalajdziski
078999888 AnaMadevska
077789888 SashoNajdov
075554433 VladimirTrajkovik
042424242 EftimZdravevski
034874585 PetreLamesski

*/