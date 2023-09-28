package org.example;

import java.util.LinkedList;
import java.util.Queue;

public class CarParkManager {
    private static  CarParkManager pool_manager;
    private static final int POOL_SIZE_LIMIT=9;
    private static final int INIT_POOL_SIZE = 3;
    private final LinkedList<CarPark> pool;

    private CarParkManager(){
        pool=new LinkedList<>();
        for(int i=0; i<INIT_POOL_SIZE; i++)
            pool.offer(new CarPark(i));
    }

    public  CarPark borrowClient()  {
        System.out.println("borrowClient call ");
            if(pool_manager.pool.size() == 1 ){
                System.out.println("touch size limit init ...");
                if(pool_manager.pool.size()< POOL_SIZE_LIMIT){
                   int lastItem =  pool_manager.pool.peekLast().getId();
                   int increase = lastItem + 1 ;
                    pool_manager.pool.offer(new CarPark(increase));
                    System.out.println("pool size increase to " + pool_manager.pool.size());
                }else{
                    System.out.println("CAR_PARK IS FULL ...");
                }
            }

            return pool_manager.pool.poll();
    }

    public  void returnClient(CarPark client){
        System.out.println("return car");
            // do something to reset/sanitize client if required
            pool_manager.pool.offer(client);
    }
    public static CarParkManager getInstance() {
        if (pool_manager == null) {
            pool_manager = new CarParkManager();
        }
        return pool_manager;
    }
}
