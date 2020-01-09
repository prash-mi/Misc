package com.misc;

public class PrintSyncMultiThread {
    public static void main(String[] args){
        int[][] arrays = new int[4][];
        arrays[0] = new int[]{1, 5, 7, 10, 11};
        arrays[1] = new int[]{2 , 6 , 8};
        arrays[2] = new int[]{5, 9, 14};
        arrays[3] = new int[]{3,4};

        printSync(arrays);
    }

    static void printSync(int[][] arrays){
        SyncThread.Lock lock = new SyncThread.Lock();

        int numAry = arrays.length;//number of arrays

        Thread[] threads = new Thread[numAry];

        //initialize the threads
        for (int i = 0; i < numAry; i++){
            threads[i] = new SyncThread.Runner(arrays[i], lock);// pass array to the respective threads
        }

        //start the threads
        for (int i = 0; i < numAry; i++){
            ((SyncThread.Runner)threads[i]).next = i < numAry-1 ? threads[i+1]: threads[0]; // set the next thread's ref in a circular fashion

            ((SyncThread.Runner)threads[i]).prev = i == 0 ? threads[numAry-1]: threads[i-1]; // set the prev thread's ref in a circular fashion

            // threads[i].start();//start the thread
        }
        //  synchronized(threads[numAry-1]) {
        // threads[numAry-1].notify();
        //   }

        for(int i = 1; i < numAry; i++){
            threads[i].start();//start the thread
        }

        //the only object on which the lock isnt held is the last thread's reference and the first thread isnt yet started

        synchronized( threads[numAry-1]) {
            threads[0].start();
            threads[numAry-1].notify();
        }

    }

    static class Runner extends Thread{

        int[] array;
        int cur = 0;
        Torch torch;


        @Override
        public void run() {

            while (true){

                try {
                    synchronized(torch) {
                        if (cur < array.length) {
                            System.out.println(array[cur++]);
                        }

                        this.notify();

                        next.wait();
                    }




                    // lock.notifyAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }




        }

        public Runner(int[] ary, SyncThread.Lock lock){
            this.array = ary;
            this.lock = lock;
        }

    }

    static class Torch{
        private int threadNum = 0;
        public int getTurn(){
            return threadNum;
        }
    }
}
