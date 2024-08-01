package org.example;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {
        try {
            TelegramBotsApi telegramBotsApi=new TelegramBotsApi(DefaultBotSession.class);
            telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }

        DataBinance dataBinance=new DataBinance();
        dataBinance.start();
        CompareData compareData=new CompareData();
        compareData.start();

    }
public static class DataBinance extends Thread{
        @Override
    public void run(){
            while (true){ System.out.print("Data load");
                for (int i = 0; i < 10; i++) {
                    System.out.print(".");
                    try {
                        sleep(1000);
                    } catch (InterruptedException e){
                        throw new RuntimeException(e);
                    }
                }

                SaveData.SaveDataBefore.saveData(ParseDataFromBinance.getDAta());

            }



        }
}
}