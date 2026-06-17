public class Exercise7{


    static double value(double amt,double rate,int year){

        if(year==0)
            return amt; // base case


        return value(amt*(1+rate),rate,year-1);
    }


    public static void main(String args[]){

        double ans=value(1000,0.10,3);

        System.out.println(ans);
    }
}

// tc O(n)
