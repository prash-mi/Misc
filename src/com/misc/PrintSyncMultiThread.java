package com.misc;
/*
Given 4 threads each having int array  of different size... threads should print their elements one by one sequentially

Eg
t1 has [1, 5 ,7, 10, 11]
t2 has [2 , 6 , 8]
t3 has [5, 9, 14]
t4 has [3, 4]
Output should be
1 2 5 3 5 6 9 4 7 8 14 10 11

 */

public class PrintSyncMultiThread {
    static Thread[] threads;

    public static void main(String[] args){
        int[][] arrays = new int[4][];
        arrays[0] = new int[]{1, 5, 7, 10, 11};
        arrays[1] = new int[]{2 , 6 , 8};
        arrays[2] = new int[]{5, 9, 14};
        arrays[3] = new int[]{3,4};
            printSync(arrays);

            //Ouput : 1 2 5 3 5 6 9 4 7 8 14 10 11 

    }

    static void printSync(int[][] arrays){
        int numAry = arrays.length;//number of arrays or number of threads
        Torch torch = new Torch(numAry);

        threads= new Thread[numAry];

        //initialize the threads
        for (int i = 0; i < numAry; i++){
            threads[i] = new Runner(arrays[i], torch, i);// pass array to the respective threads
            threads[i].start();//start the thread
        }

    }

    //the Thread class
    static class Runner extends Thread{

        int[] array;
        int cur = 0;
        Torch torch;
        final  int myId;


        @Override
        public void run() {

            while (cur < array.length){//while all the elements in the current array arent printed
                synchronized(torch) {

                    if(torch.threadId == this.myId){
                        torch.next();
                        System.out.print(array[cur++] + " ");
                    }else if(! threads[torch.threadId].isAlive()){//see of thread with torch.threadId is live, else do torch.next() on its behalf
                        torch.next();
                    }

                    torch.notify();//notify other threads to try their luck
                }

            }




        }

        public Runner(int[] ary,Torch torch, int id){
            this.array = ary;
            this.torch = torch;
            this.myId = id;
        }

    }

    //Class for syncriniing the thread, the idea is that the thread with the Torch and matching id will be able to print the number
    static class Torch{
        public int threadId = 0;
        int max;
        Torch(int max){
            this.max = max;
        }

        public void next(){
            threadId++;
            if(threadId>=max){
                threadId = 0;
            }
        }
    }
}
