//Find a soultion for Shifted Schwefel's Problem 1.2 by using the optimization technique (Genetic Algorithm)

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;


public class Genetic_Algorithm {
    
 public static double[] o={35.6267,-82.9123,-10.6423,-83.5815,83.1552,47.048,-89.4359,-27.4219,76.1448,-39.0595};
 public static double[][]pop=new double[200][10];
 
    public static void main(String[] args) {
        
        // fill array with random numbers between 100 and -100
        for (int i = 0; i < pop.length; i++) {
           for (int j = 0; j < pop[i].length; j++) {
                pop[i][j] = (Math.random() * 201) - 100;
                System.out.print(i+" "+pop[i][j]);
            }
            System.out.println();
            f(o,pop[i]);
    }
  
    //while loop
     int a=0;
    while(a<80000){
        
    double[] ff = new double[200];
    double smallest = 0;

    //fitness of pop
    for (int i = 0; i < 200; i++) {  
        
     ff[i]= f(o,pop[i]);
    
  //choose the smallest value from 100 numbers
     smallest = ff[0]; 
  for (int g = 1; g <200 ; g++) { 
    if (ff[i] < smallest) { 
     smallest = ff[i]; 
    }}}
 // System.out.println(smallest);
  //  if (a % 2000 == 0) {
  System.out.println(smallest);
  //  }


double[][] parents=new double[200][10];

//copy ff to ff2
double[] ff2 = new double[200];
for(int t=0;t<200;t++){
    ff2[t]=ff[t];
}

int [] ind=new int[200];
for(int i=0;i<200;i++){//index
    ind[i]=i;
}

//take the first and second numbers and save them because we do not want to change them
double temp=0;
int temp2 = 0;

for(int d=0;d<200;d++){
    for(int r=1;r<200-d;r++){
        if(ff2[r-1]>ff2[r]){
            temp=ff2[r-1];
            ff2[r-1]=ff2[r];
            ff2[r]=temp;
            
            temp2=ind[r-1];
            ind[r-1]=ind[r];
            ind[r]=temp2;

        }
    }

}
for(int g=0;g<10;g++){
    parents[0][g]=pop[ind[0]][g];
    parents[1][g]=pop[ind[1]][g];
}


//selection algorithm - pick 5 numbers and choose the lowest one 
int best=0;
Random rng = new Random();

for(int k=2; k<200;k++){
double lowest=9999999;

 for(int i=0; i<5;i++){
int randIndex = rng.nextInt(100);//between 0 and 100 "random num"
double r=f(o,pop[randIndex]); //fitness of indexes that we selected it randomly

           if(f(o,pop[randIndex])<lowest){
            lowest=r;
            best=randIndex; //index of best numbers "we saved the indexes that we selected it"
           }
 }
 
           for(int j=0;j<10;j++){
            parents[k][j]=  pop[best][j];
// put the indexes inside pop to give us the array of best numbers then generat it to parents
//now parents has the best 100 numbers
}
 }

 //apply crossover 
 for(int p=2;p<200;p+=2){

 crossover(parents[p],parents[p+1]);
     }
 
 
 //mutation
 for(int q=2;q<200;q++){
 mutation(parents[q]);
 }       
       

 //System.out.println(parents[p][t]+"  ");

 //kids[p][r]=parents[p][r];//generate the parents after mutation to kids
 // System.out.println(kids[p][t]+"  ");
  
  //  System.out.print(i+"- "+pop[i][j] + " ");
                
     
     
     //assign parents to pop
    for(int y=0;y<pop.length;y++){
     for(int z=0;z<pop[y].length;z++){
           pop[y][z]=parents[y][z];
       //System.out.println(f(o,pop[y]));
                }
               //   System.out.println();
            }
a++;
    }
    //print the x's of our solution
    for(int o=0;o<10;o++){
    //System.out.print("solution: "+pop[0][o]+" ");
    }
//System.out.println();
    }

 
    
    public static void mutation(double[] xx){
      	int randomNumber = 0;

       for(int i=0;i<4;i++){
       
      Random rand=new Random();
      int r=rand.nextInt(10);
      double nn= rand.nextDouble()*r;
            double n= rand.nextDouble()*1;

     Random ran=new Random();        
     randomNumber=ran.nextInt(xx.length);

if(n<=0.5){
    if(xx[randomNumber]-nn>=-100)
         xx[randomNumber]=xx[randomNumber]-nn;

}          
else{
        if(xx[randomNumber]+nn<=100)

         xx[randomNumber]=xx[randomNumber]+nn;

}

       }
    }
    
  
    public static double f(double[] opt,double[] ran){
    
    
            double totalSum =0;
           // double sum = 0;
            for(int i=0;i<10;i++){
                double p=0;
                 for(int j=0;j<i;j++){
                    p+= (ran[j] - opt[j]);
                 }
                
                 totalSum+= Math.pow(p, 2);
            }
            
          // System.out.println("f: "+totalSum);
            return totalSum;
    }
    
    
    
public static void crossover(double[] par1,double[] par2){
       int RandomCut;
       Random rng = new Random();
       RandomCut = rng.nextInt(10);//random cut point

for(int i=RandomCut;i<10;i++){
    double temp;
   temp =par1[i];
    par1[i]=par2[i];
    par2[i]=temp;
}                                        
}
}
