package lab3;

public class lab3 {
    //Функция с установленным N
    public static double SummN (double endN, double x)
    {
        double summ = 1, n = 0, currnumb, xb = x, factorialb = 1, fact = 1, Z;
        do {
            n++;
            Z = Math.cos(n*Math.PI/4);
            currnumb = xb * Z / factorialb;
            factorialb *= ++fact;
            xb *= x;
            summ += currnumb;
        }while (n<endN);
        return summ;
    }

    //Функция  с установленной точностью
    public static double SummE (double e, double x)
    {
        double summ = 1, currnumb = 0, prevnumb, xb = x, factorialb = 1, factorial = 1, Z, k=0;
        do
        {
            k++;
            Z = Math.cos(k*Math.PI/4);
            prevnumb = currnumb;
            currnumb = Z * xb / factorialb;
            factorialb *= ++factorial;
            xb *= x;
            summ += currnumb;
        } while (Math.abs(currnumb - prevnumb) >= e);
        return summ;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        double xn = 0.1, xk = 1, dx = (xk-xn)/10, eps = 0.0001, x, n = 25, y, summN, summE;
        System.out.println("X - параметр;\nSummN - суммы для заданного n;\nSummE - суммы для заданной точности;\nY - точное значение функции;\nпогрешность SummN, погрешность SummE – относительные погрешности приближенных вычислений.\nn = "+n+"\n");
        for (x = xn; (x <= xk) && (x >= 0.1); x += dx)
        {
// Использование функции расчета значения с заданным n:
            summN = SummN(n,x);
// Использование функции расчета значения с заданной точностью:
            summE = SummE(eps,x);
// Расчет условно точного значения:
            y = Math.pow(Math.E,x*Math.cos(Math.PI/4))*x*Math.sin(Math.PI/4);
            System.out.println(String.format("X = %f; SummN = %.15f; SummE = %.15f; Y = %.15f; погрешность SummN = %.15f; погрешность SummE = %.15f;", x, summN, summE, y, Math.abs((y-summN)/y), Math.abs((y-summE)/y)));
        }
    }
}

