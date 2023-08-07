import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Array {
            static int najdiNajdolgaCikCak(int a[]) {
            boolean flag=false, first = false,poz=false;
            int max=0,br=0;

            for(int i=0;i<a.length;i++)
            {
                flag=true;
                if(first==false&&a[i]>0)
                {
                    poz=true;
                    br=1;
                    first=true;
                }
                else if(first==false && a[i]<0)
                {
                    poz=false;
                    br=1;
                    first=true;
                }
                else
                {
                    if(a[i]>0 && poz==false)
                    {
                        br++;
                        poz=true;
                    }
                    else if(a[i]<0 && poz==true)
                    {
                        br++;
                        poz=false;
                    }
                    else if(a[i]==0)
                    {

                        if(br>max)
                        {
                            max=br;
                        }


                        first=false;
                        br=0;

                    }
                    else
                    {
                        if(br>max)
                        {
                            max=br;
                        }

                        br=1;

                        if(a[i]>0) poz=true;
                        else poz=false;
                    }
                }
                if(br>max) max=br;
            }

            return max;

        }

        public static void main(String[] args) throws Exception {
            int i,j,k;

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());
            int a[] = new int[N];
            for (i=0;i<N;i++)
                a[i] = Integer.parseInt(br.readLine());

            int rez = najdiNajdolgaCikCak(a);
            System.out.println(rez);

            br.close();

        }


}