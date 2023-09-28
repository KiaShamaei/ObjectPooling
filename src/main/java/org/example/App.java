package org.example;

import java.util.Scanner;

/**
 * this is implement pooling object design pattern
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CarParkManager cp = CarParkManager.getInstance();

        Scanner sc = new Scanner(System.in);
        System.out.println( "Please insert the number of car you want to park" );
        int carNumber= sc.nextInt();

        for(int i=0 ; i <= carNumber ; i++ ){
            cp.borrowClient();

        }


    }
    public void n2(){
        if(true)
            throw new RuntimeException("test");
    }
}
