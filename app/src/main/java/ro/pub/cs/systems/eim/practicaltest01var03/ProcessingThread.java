package ro.pub.cs.systems.eim.practicaltest01var03;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.os.Process;
import java.util.Random;

public class ProcessingThread extends Thread {
    private Context context;
    private int sum, firstNumber, secondNumber;
    private int difference;
    private boolean isRunning = true;
    private Random random = new Random();


    public ProcessingThread(Context context, int firstNumber, int secondNumber) {
        this.context = context;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.sum = firstNumber + secondNumber;
        this.difference = firstNumber - secondNumber;
    }

    @Override
    public void run() {
        Log.d(Constants.PROCESSING_THREAD_TAG, "Thread has started! PID: " + Process.myPid() + " TID: " + Process.myTid());
        while (isRunning) {
            sendMessageSum();
            sleep();
            sendMessageDiff();
        }
        Log.d(Constants.PROCESSING_THREAD_TAG, "Thread has stopped!");
    }

    private void sendMessageSum() {
        Intent intent = new Intent();
        intent.setAction(Constants.actionTypes[0]);
        intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA, String.valueOf(sum));
        context.sendBroadcast(intent);
    }

    private void sendMessageDiff() {
        Intent intent = new Intent();
        intent.setAction(Constants.actionTypes[1]);
        intent.putExtra(Constants.BROADCAST_RECEIVER_EXTRA, String.valueOf(difference));
        context.sendBroadcast(intent);
    }

    private void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
        }
    }

    public void stopThread() {
        isRunning = false;
    }
}
