
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.Callable;


class SLLNode {
    protected int id;
    protected int plata;
    protected SLLNode succ;

    public SLLNode(int id,int plata, SLLNode succ) {
        this.id = id;
        this.plata=plata;
        this.succ = succ;
    }


}

class SLL {
    private SLLNode first;

    public SLL() {
        // Construct an empty SLL
        this.first = null;
    }

    public void deleteList() {
        first = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            SLLNode tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }


    public void insertFirst(int id, int plata) {
        SLLNode ins = new SLLNode(id,plata, first);
        first = ins;
    }

    public void insertLast(int id,int plata) {
        if (first != null) {
            SLLNode tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode ins = new SLLNode(id, plata, null);
            tmp.succ = ins;
        } else {
            insertFirst(id,plata);
        }
    }

    public SLLNode getFirst() {
        return first;
    }


    public SLL brisi_pomali_od(int iznos) {
        // Vasiot kod tuka
        SLLNode tmp=first;
        while(tmp!=null && tmp.plata<iznos){
            first=tmp.succ;
            tmp=tmp.succ;
        }
        while(tmp!=null && tmp.succ!=null){
            if(tmp.plata<iznos){
                tmp.succ=tmp.succ.succ;
            }
            else {
                tmp=tmp.succ;
            }
        }
        return this;
    }

    public SLL sortiraj_opagacki() {
        // Vasiot kod tuka
        if(this.length()>0){
            SLL lista=new SLL();
            ArrayList<Integer> ids=new ArrayList<>();
            SLLNode tmp=first;
            while(tmp!=null){
                ids.add(tmp.id);
                tmp=tmp.succ;
            }
            Collections.sort(ids);
            Collections.reverse(ids);
           for(int i=0; i<ids.size();i++){
               tmp=first;
               if(tmp.id==ids.get(i)){
                   lista.insertLast(tmp.id,tmp.plata);
                   break;
               }
               tmp=tmp.succ;
           }
           return lista;
        }
        return null;
    }
    public void pecati (SLL lista)
    {
        SLLNode p=lista.first;
        while(p!=null)
        {
            System.out.println(p.id+","+p.plata);
            p=p.succ;
        }
    }

}
public class zadaca {
    public static void main(String[] args) throws IOException {

        SLL lista1 = new SLL();
        BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));
        String s = stdin.readLine();
        int N = Integer.parseInt(s);

        for (int i = 0; i < N; i++) {
            s=stdin.readLine();
            String s1=stdin.readLine();
            lista1.insertLast(Integer.parseInt(s),Integer.parseInt(s1));
        }
        s = stdin.readLine();

        lista1=lista1.brisi_pomali_od(Integer.parseInt(s));
        if(lista1!=null)
        {
            lista1=lista1.sortiraj_opagacki();
            lista1.pecati(lista1);
        }

    }
}

