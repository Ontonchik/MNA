public class Task1 {
    public double r, h, Q1, Q2;
    public double a=0, b=Math.PI/3;
    public double epsilon=Math.pow(10,-7);


    public double func(double x){
            return Math.exp(x)/(1+Math.sin(x));
    }

    public void Simpson(){
        int n=2;
        r=Integer.MAX_VALUE;
        double integral;
        h=(b-a)/n;
        Q2=h/6*(func(a)+func(b)+2*func(a+h)+4*(func(a+h/2)+func(a+3*h/2)));
        System.out.println("Метод Симпсона: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|          h          |  n  |        Q         |           r         |");
        System.out.println("|   "+h+"|    "+n+"|"+Q2+"|          -          |");
        while(epsilon<r){
            n*=2;
            h=(b-a)/n;
            double sum1=0,sum2=0;
            for (int i = 1; i < n; i++) {
                sum1+=func(a+i*h);
            }
            for (int i = 0; i < n; i++) {
                sum2+=func(a+(2*i+1)*h/2);
            }
            integral=h/6*(func(a)+func(b)+2*sum1+4*sum2);
            Q1=Q2;
            Q2=integral;
            r=Math.abs((Q2-Q1)/15);
            System.out.print("|");
            System.out.printf("%21s",h);
            System.out.print("|");
            System.out.printf("%5d",n);
            System.out.print("|");
            System.out.printf("%18s",Q2);
            System.out.print("|");
            System.out.printf("%21s",r);
            System.out.print("|");
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void Trapezoid(){
        int n=2;
        r=Integer.MAX_VALUE;
        double integral;
        h=(b-a)/n;
        Q2=h*((func(a)+func(b))/2+func(a+h));
        System.out.println("Метод Трапеций: ");
        System.out.println("----------------------------------------------------------------------");
        System.out.println("|          h          |  n  |        Q         |           r         |");
        System.out.println("|   "+h+"|    "+n+"|"+Q2+"|          -          |");
        while(epsilon<r){
            n*=2;
            h=(b-a)/n;
            double sum=0;
            for (int i = 1; i < n; i++) {
                sum+=func(a+i*h);
            }
            integral=h*((func(a)+func(b))/2+sum);
            Q1=Q2;
            Q2=integral;
            r=Math.abs((Q2-Q1)/3);
            System.out.print("|");
            System.out.printf("%21s",h);
            System.out.print("|");
            System.out.printf("%5d",n);
            System.out.print("|");
            System.out.printf("%18s",Q2);
            System.out.print("|");
            System.out.printf("%21s",r);
            System.out.print("|");
            System.out.println();
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void NAST(){
        System.out.println("Метод кф наивысшей степени точности: ");
        int n=5;
        double[] x=new double[5];
        double[] A=new double[5];
        x[0]=-Math.sqrt((35+2*Math.sqrt(70))/63);
        x[4]=-x[0];
        x[1]=-Math.sqrt((35-2*Math.sqrt(70))/63);
        x[3]=-x[1];
        x[2]=0;
        A[0]=(322-13*Math.sqrt(70))/900;
        A[4]=A[0];
        A[1]=(322+13*Math.sqrt(70))/900;
        A[3]=A[1];
        A[2]=(double)128/225;
        double integral=0;
        for (int i = 0; i < n; i++) {
            integral+=(b-a)/2*A[i]*func((a+b)/2+(b-a)/2*x[i]);
        }
        System.out.println(integral);
    }

    public static void main(String[] args) {
        Task1 test=new Task1();
        test.Trapezoid();
        test.Simpson();
        test.NAST();
    }
}