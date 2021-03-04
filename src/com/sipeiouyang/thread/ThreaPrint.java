package com.sipeiouyang.thread;

import java.util.Scanner;

/**
 * @author sipeiouyang
 * @version 1.0
 *
 * 这是一道曾经遇到的笔试题
 *
 * 启动N个线程，各线程依次打印数字0到N-1,例如，线程0固定打印0，线程1固定打印1，线程N固定打印N-1。
 * 共打印M遍，要求打印的字符有序，M，N由终端输入，其中M、N的范围在 2～9 之间
 *
 *  例子：在共3个线程，共打印三遍时，过程如下:
 *  第一遍打印时，线程0打印0，线程1打印1，线程2打印2
 *  然后开始第二遍打印，依然由线程0开始，打印0之后，线程1开始打印1,线程2打印2
 *  然后第三遍打印，线程0打印0，线程1打印1,线程2打印2
 * 程序执行完毕。
 *
 */
public class ThreaPrint implements Runnable {

    /**
     * 当前打印的线程
     **/
    private static volatile int currentPrintThread = 0;

    /**
     * 线程打印的数字
     **/
    private int printNum;

    /**
     * 需要循环的次数
     **/
    private int loopSize;

    /**
     * 当前线程打印的次数
     **/
    private int printSize = 0;

    private boolean isEndThread = false;

    public ThreaPrint(int printNum, int loopSize, boolean isEndThread) {
        this.printNum = printNum;
        this.loopSize = loopSize;
        this.isEndThread = isEndThread;
    }

    @Override
    public void run() {
        while (printSize < loopSize){
            if (currentPrintThread == printNum){
                System.out.println(printNum);
                if (!isEndThread){
                    currentPrintThread = printNum + 1;
                }else {
                    currentPrintThread = 0;
                }
                printSize++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("请输入'M,N',M在前，N在后，以英文逗号分隔：");
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        if (str == null){
            return;
        }
        String[] arr = str.split(",");
        int m = Integer.valueOf(arr[0]);
        int n = Integer.valueOf(arr[1]);
        for(int i = 0; i < n; i++){
            Thread thread;
            if (i != (n - 1)){
                thread = new Thread(new ThreaPrint(i, m, false));
            }else {
                thread = new Thread(new ThreaPrint(i, m, true));
            }
            thread.start();
        }
        Thread.sleep(1000);
    }
}
