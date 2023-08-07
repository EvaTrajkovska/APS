import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
class SLL<E> {
    private SLLNode<E> first;

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
            SLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            SLLNode<E> tmp = first;
            ret += tmp + "->";
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret += tmp + "->";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public void insertFirst(E o) {
        SLLNode<E> ins = new SLLNode<E>(o, first);
        first = ins;
    }

    public void insertAfter(E o, SLLNode<E> node) {
        if (node != null) {
            SLLNode<E> ins = new SLLNode<E>(o, node.succ);
            node.succ = ins;
        } else {
            System.out.println("Dadenot jazol e null");
        }
    }

    public void insertBefore(E o, SLLNode<E> before) {

        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == before) {
                this.insertFirst(o);
                return;
            }
            // ako first!=before
            while (tmp.succ != before)
                tmp = tmp.succ;
            if (tmp.succ == before) {
                SLLNode<E> ins = new SLLNode<E>(o, before);
                tmp.succ = ins;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
    }

    public void insertLast(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            SLLNode<E> ins = new SLLNode<E>(o, null);
            tmp.succ = ins;
        } else {
            insertFirst(o);
        }
    }

    public E deleteFirst() {
        if (first != null) {
            SLLNode<E> tmp = first;
            first = first.succ;
            return tmp.element;
        } else {
            System.out.println("Listata e prazna");
            return null;
        }
    }

    public E delete(SLLNode<E> node) {
        if (first != null) {
            SLLNode<E> tmp = first;
            if (first == node) {
                return this.deleteFirst();
            }
            while (tmp.succ != node && tmp.succ.succ != null)
                tmp = tmp.succ;
            if (tmp.succ == node) {
                tmp.succ = tmp.succ.succ;
                return node.element;
            } else {
                System.out.println("Elementot ne postoi vo listata");
                return null;
            }
        } else {
            System.out.println("Listata e prazna");
            return null;
        }

    }

    public SLLNode<E> getFirst() {
        return first;
    }

    public SLLNode<E> find(E o) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }


    public void mirror() {
        if (first != null) {
            // m=nextsucc, p=tmp,q=next
            SLLNode<E> tmp = first;
            SLLNode<E> newsucc = null;
            SLLNode<E> next;

            while (tmp != null) {
                next = tmp.succ;
                tmp.succ = newsucc;
                newsucc = tmp;
                tmp = next;
            }
            first = newsucc;
        }

    }

    public void merge(SLL<E> in) {
        if (first != null) {
            SLLNode<E> tmp = first;
            while (tmp.succ != null)
                tmp = tmp.succ;
            tmp.succ = in.getFirst();
        } else {
            first = in.getFirst();
        }
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
public class Zadaca111 {
    public static void Zadaca111(SLL<Integer> lista,SLL<Integer> pomali, SLL<Integer> pogolemi){
        SLLNode<Integer> prv= lista.getFirst();
        SLLNode<Integer> posleden=lista.getFirst();
        while(posleden.succ!=null){
            posleden=posleden.succ;
        }
        lista.delete(prv);
        lista.delete(posleden);
        lista.insertFirst(posleden.element);
        lista.insertLast(prv.element);
        System.out.println(lista);

    }
    public static void main(String[] args) throws IOException{
        SLL<Integer> lista=new SLL<Integer>();
        SLL<Integer> pomali=new SLL<Integer>();
        SLL<Integer> pogolemi=new SLL<Integer>();
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        String line=br.readLine();
        String []pom=line.split(" ");
        for(int i=0;i<N;i++){
            lista.insertLast(Integer.parseInt(pom[i]));
        }
        Zadaca111(lista,pomali,pogolemi);
    }
} */

/*public class Zadaca111 {
    public static void zaad(SLL<Integer> lista, int n, int m){
        SLLNode<Integer>tmp= lista.getFirst();
        SLLNode<Integer>tmpN=null;
        SLLNode<Integer>tmpM=null;
        int br=1;
        while(tmp!=null){
            if(br==n){
                tmpN=tmp;
                System.out.println(tmpN.element);
            } else if(br==m){
                tmpM=tmp;
                System.out.println(tmpM.element);
            }
            br++;
            tmp=tmp.succ;
        }
        tmp=tmpN;
        while(tmp!=null && tmp!=tmpM){
            tmp=tmp.succ;
        }
        System.out.println(lista);
    }
    public static void main(String [] args ) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        SLL<Integer> lista=new SLL<Integer>();
        String line= br.readLine();
        String []pom=line.split(" ");
        for(int i=0;i<pom.length;i++){
            lista.insertLast(Integer.parseInt(pom[i]));
        }
        int n=Integer.parseInt(br.readLine());
        int m=Integer.parseInt(br.readLine());
        zaad(lista,n,m);
    }
}

public class Zadaca111 {
    public static void main(String [] args ) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        SLL<String> lista = new SLL<String>();
        String line = br.readLine();
        String[] pom = line.split(" ");
        for (int i = 0; i < pom.length; i++) {
            lista.insertLast(pom[i]);
        }
        System.out.println(lista);
        zad(lista);
    }
    public static void zad(SLL<String> lista ) {
        SLLNode<String> tmp = lista.getFirst();
        char posl;
        while(tmp!=null ){
           String s= tmp.element;
           posl=s.charAt(s.length()-1); // V
            System.out.println(posl);
           String nov= posl+s.substring(1,s.length()-1);
           lista.insertBefore(nov,tmp);
           lista.delete(tmp);
           tmp=tmp.succ;
        }
        System.out.println(lista);
    }

} */
class DLL<E> {
    private DLLNode<E> first, last;

    public DLL() {
        // Construct an empty SLL
        this.first = null;
        this.last = null;
    }

    public void deleteList() {
        first = null;
        last = null;
    }

    public int length() {
        int ret;
        if (first != null) {
            DLLNode<E> tmp = first;
            ret = 1;
            while (tmp.succ != null) {
                tmp = tmp.succ;
                ret++;
            }
            return ret;
        } else
            return 0;

    }

    public DLLNode<E> find(E o) {
        if (first != null) {
            DLLNode<E> tmp = first;
            while (tmp.element != o && tmp.succ != null)
                tmp = tmp.succ;
            if (tmp.element == o) {
                return tmp;
            } else {
                System.out.println("Elementot ne postoi vo listata");
            }
        } else {
            System.out.println("Listata e prazna");
        }
        return first;
    }

    public void insertFirst(E o) {
        DLLNode<E> ins = new DLLNode<E>(o, null, first);
        if (first == null)
            last = ins;
        else
            first.pred = ins;
        first = ins;
    }

    public void insertLast(E o) {
        if (first == null)
            insertFirst(o);
        else {
            DLLNode<E> ins = new DLLNode<E>(o, last, null);
            last.succ = ins;
            last = ins;
        }
    }

    public void insertAfter(E o, DLLNode<E> after) {
        if (after == last) {
            insertLast(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, after, after.succ);
        after.succ.pred = ins;
        after.succ = ins;
    }

    public void insertBefore(E o, DLLNode<E> before) {
        if (before == first) {
            insertFirst(o);
            return;
        }
        DLLNode<E> ins = new DLLNode<E>(o, before.pred, before);
        before.pred.succ = ins;
        before.pred = ins;
    }

    public E deleteFirst() {
        if (first != null) {
            DLLNode<E> tmp = first;
            first = first.succ;
            if (first != null)
                first.pred = null;
            if (first == null)
                last = null;
            return tmp.element;
        } else
            return null;
    }

    public E deleteLast() {
        if (first != null) {
            if (first.succ == null)
                return deleteFirst();
            else {
                DLLNode<E> tmp = last;
                last = last.pred;
                last.succ = null;
                return tmp.element;
            }
        }
        // else throw Exception
        return null;
    }

    public E delete(DLLNode<E> node) {
        if (node == first) {
            deleteFirst();
            return node.element;
        }
        if (node == last) {
            deleteLast();
            return node.element;
        }
        node.pred.succ = node.succ;
        node.succ.pred = node.pred;
        return node.element;

    }

    @Override
    public String toString() {
        String ret = new String();
        if (first != null) {
            DLLNode<E> tmp = first;
            // ret += tmp + "<->";
            while (tmp.succ != null) {

                ret += tmp + "<->";
                tmp = tmp.succ;
            }
            ret += tmp;

        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public String toStringR() {
        String ret = new String();
        if (last != null) {
            DLLNode<E> tmp = last;
            ret += tmp + " ";
            while (tmp.pred != null) {
                tmp = tmp.pred;
                ret += tmp + " ";
            }
        } else
            ret = "Prazna lista!!!";
        return ret;
    }

    public DLLNode<E> getFirst() {
        return first;
    }

    public DLLNode<E> getLast() {

        return last;
    }

}
class DLLNode<E> {
    protected E element;
    protected DLLNode<E> pred, succ;

    public DLLNode(E elem, DLLNode<E> pred, DLLNode<E> succ) {
        this.element = elem;
        this.pred = pred;
        this.succ = succ;
    }

    @Override
    public String toString() {
        return element.toString();
    }
}

public class Zadaca111 {
    public static void zaad(DLL<Integer> lista, int n, int m) {
        DLLNode<Integer> tmp = lista.getFirst();
        DLLNode<Integer> tmp1 = null;
        DLLNode<Integer> pom = null;
        DLLNode<Integer> pom1 = null;
        int br = 0;
        int max=0;
        while (tmp != null) {
            tmp1=tmp.succ;
            while(tmp1!=null){
                pom=null;
                pom1=null;
                if(tmp.element==tmp1.element){
                    pom=tmp;
                    pom1=tmp1;
                    br=0;
                    while(pom!=pom1 && pom1.succ!=pom){
                        if(pom.element==pom1.element){
                            br++;
                            pom=pom.succ;
                            br++;
                            pom1=pom1.pred;
                        }
                    }
                    if (pom == pom1) {
                        br++;
                    }
                    if(br>max){
                        max=br;
                    }
                    tmp=tmp.succ;
                }

            }

            System.out.println(lista);
        }
        public static void main (String[]args ) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            DLL<Integer> lista = new DLL<Integer>();
            int n=Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] pom = line.split(" ");
            for (int i = 0; i < n; i++) {
                lista.insertLast(Integer.parseInt(pom[i]));
            }
            int zad=zaad(lista);
            System.out.println(zad);
        }
    }
}
