//Файли с заданиями: https://github.com/Java0Tutor/2_Algorithmization/blob/master/Practice%20(tasks).pdf

import java.util.Scanner;
import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void fill(int n, double a[]) {
        System.out.printf(" Filling the array : ");
        for (int i=0;i<n;i++) {
            a[i] = ThreadLocalRandom.current().nextDouble(-100, 100);
            System.out.printf(" %f", a[i]);
        }
    }
    public static void fillInt(int n, int a[]) {
        System.out.printf(" Filling the array : ");
        for (int i=0;i<n;i++) {
            a[i] = ThreadLocalRandom.current().nextInt(-10, 10);
            System.out.printf(" %d", a[i]);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int index;
        System.out.printf("\nОдномерные массивы\n Chose task: ");
        index = in.nextInt();
        switch(index) {
            case 1 : {
                System.out.printf(" enter N and K : ");
                int n = in.nextInt();
                int k = in.nextInt();
                int a[]=new int[n];
                for (int i=0;i<n;i++) {
                    a[i] = ThreadLocalRandom.current().nextInt(1, 101);
                    System.out.println(" " + a[i]);
                }
                int sum=0;
                for (int i = 0;i<n;i++) if (a[i]%k==0) sum+=a[i];
                System.out.printf(" Answer is : %d", sum);
                break;
            }
            case 2 : {
                System.out.printf(" enter N and Z : ");
                int n = in.nextInt();
                double z = in.nextDouble();
                int count=0;
                double a[]=new double[n];
                fill(n,a);
                System.out.printf("\n New array : ");
                for (int i=0;i<n;i++) {
                    if (a[i]>z) a[i]=z;
                    System.out.printf(" %f", a[i]);
                    count++;
                }
                System.out.printf("\n  Amount of changes : %d",count);
                break;
            }
            case 3 : {
                System.out.printf(" enter N : ");
                int n = in.nextInt();
                double a[]=new double[n];
                fill(n,a);
                int zeros=0,lower=0,higher=0;
                for (int i=0;i<n;i++) {
                    if (a[i]>0) higher++;
                            else if (a[i]==0) zeros++;
                            else lower++;
                }
                System.out.printf("\n nums>0 = %d\n nums=0 = %d\n nums<0 = %d",higher, zeros, lower);
                break;
            }
            case 4 : {
                System.out.printf(" enter N : ");
                int n = in.nextInt();
                double a[]=new double[n];
                fill(n,a);
                double max=a[0], min=a[0];
                int maxindex=0, minindex=0;
                for (int i=0;i<n;i++) {
                    if (a[i]>max) {
                        max = a[i];
                        maxindex = i;
                    } else if (a[i]<min) {
                        min=a[i];
                        minindex=i;
                    }
                }
                if (max!=min) {
                    a[minindex] = max;
                    a[maxindex] = min;
                }
                System.out.printf("\n New array : ");
                for (int i=0;i<n;i++) System.out.printf(" %f", a[i]);
                break;
            }
            case 5 : {
                System.out.printf(" enter N : ");
                int n = in.nextInt();
                int a[]=new int[n];
                fillInt(n,a);
                System.out.printf("\n New array :");
                for (int i=0;i<n;i++) {
                    if (a[i]>i) System.out.printf(" %d", a[i]);
                }
                break;
            }
            case 6 : {
                System.out.printf(" enter N : ");
                int n = in.nextInt();
                double a[]=new double[n];
                fill(n,a);
                double sum=0;
                for (int i=0;i<n;i++) {
                    boolean check=true;
                    for (int ii=2;ii<i;ii++) {
                        if (i%ii==0) check=false;
                        break;
                    }
                    if (check==true) sum+=a[i];
                }
                System.out.printf("\n Summary is : %f",sum);
                break;
            }
            case 7 : {
                System.out.printf(" enter N : ");
                int n = in.nextInt();
                double a[]=new double[2*n];
                fill(2*n,a);
                double pair=a[0]+a[2*n-1];
                System.out.printf(" Pairs :\n a(1)+a(%d) = %f",2*n,pair);
                for (int i=1;i<n;i++) {
                    double temp = a[i]+a[2*n-1-i];
                    System.out.printf("\n a(%d)+a(%d) = %f",i+1,2*n-i,temp);
                    if (temp>pair) pair=temp;
                }
                System.out.printf("\n Max is : %f",pair);
                break;
            }
            case 8 : {
                System.out.printf(" enter N : ");
                int n = in.nextInt();
                int a[]=new int[n];
                fillInt(n,a);
                int min=a[0];
                for (int i=1;i<n;i++) if (a[i] < min) min = a[i];
                System.out.printf("\n New sequence (min = %d) : ",min);
                for (int i=0;i<n;i++) if (a[i]!= min) System.out.printf(" %d",a[i]);
                break;
            }
            case 9 : {
                System.out.printf(" enter N : ");
                int n = in.nextInt();
                int a[]=new int[n];
                int count[]=new int[n];
                int minIndex=0;
                fillInt(n,a);
                System.out.printf("\n Counts : ");
                for (int i=0;i<n-count[minIndex]+1;i++) {
                    int temp=a[i];
                    for (int ii=i;ii<n;ii++) if (a[ii]==temp) count[i]++;
                    System.out.printf(" %d",count[i]);
                    if (count[i]>count[minIndex]) minIndex=i;
                }
                for (int i=0;i<n-count[minIndex]+1;i++) {
                    if (count[i]==count[minIndex]) {
                        if (a[i]<a[minIndex]) minIndex=i;
                    }
                }
                System.out.printf("\n The most frequent number (and the smallest among equally frequent ones) : %d, and its index is %d",a[minIndex],minIndex);
                break;
            }
            case 10 : {
                System.out.printf(" enter N : ");
                int n = in.nextInt();
                int a[]=new int[n];
                fillInt(n,a);
                int fillpos=1;
                for (int i=2;i<n;i+=2) {
                    a[fillpos] = a[i];
                    fillpos++;
                }
                for (int i=fillpos;i<n;i++) a[i]=0;
                System.out.printf("\n New array : ");
                for (int i=0;i<n;i++) System.out.printf(" %d", a[i]);
                break;
            }
        }
        in.close();
    }
}