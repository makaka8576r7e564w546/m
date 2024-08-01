package org.example;

public class CompareData extends Thread{
    private long timer=0;
    @Override
    public void run() {
    while (true){
        timer+=1000;
        try {
            sleep(1000);
            if (timer%20000==0){
                SaveData.SaveDataAfter.saveData(ParseDataFromBinance.getDAta());
                System.out.println("after");
            } else if (timer%10000==0) {
                SaveData.SaveDataBefore.saveData(ParseDataFromBinance.getDAta());
                System.out.println("before");
                CompareJSONData.compareJSONData();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
    }

