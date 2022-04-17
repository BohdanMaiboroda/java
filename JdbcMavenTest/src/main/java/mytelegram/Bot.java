package mytelegram;

import database.MySQLiteDataBase;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.LongPollingBot;

import java.util.Date;

public class Bot extends TelegramLongPollingBot {


    public static LongPollingBot getBot() {
        return new Bot();
    }

    @Override
    public void onUpdateReceived(Update update) {
        //
        if (   update != null //пустота от другого - бота - программы
                && update.hasMessage()
                && update.getMessage().hasText())
        {
            String message_text = update.getMessage().getText();
            if (message_text.equals("/time"))
            {
                Date currentDate = new Date();
                String messageSend = currentDate.toString();

                long chat_id = update.getMessage().getChatId();
                sendMsg(update.getMessage().
                        getChatId().toString(), messageSend);
            }
            else if (message_text.equals("/help"))
            {
                long chat_id = update.getMessage().getChatId();
                sendMsg(update.getMessage().
                        getChatId().toString(), "три команды: /time , /help  и /empl");
            }
            else if (message_text.equals("/empl"))
            {
                String messageSend = MySQLiteDataBase.getSelect();
                long chat_id = update.getMessage().getChatId();
                sendMsg(update.getMessage().
                        getChatId().toString(), messageSend);
            }
            else//в ответ отправл¤ю эхом то, что пришло
            {
                String message = update.getMessage().getText();
                sendMsg(update.getMessage().getChatId().toString(), message);
            }
        }
        //
    }

    @Override
    public String getBotUsername() {
        return "mytelega2021122700bot";
    }

    @Override
    public String getBotToken() {
        return "5034197038:AAEtAgGaXZ7A8bQBUyJWQqHEEV0bLXRX87c";
    }
    /**
     * ћетод дл¤ настройки сообщени¤ и его отправки.
     * @param chatId id чата
     * @param s —трока, которую необходимот отправить в качестве сообщени¤.
     */
    public synchronized void sendMsg(String chatId, String s) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.enableMarkdown(true);
        sendMessage.setChatId(chatId);
        sendMessage.setText(s);
        try {
            sendMessage(sendMessage);
        } catch (TelegramApiException e) {
            //log.log(Level.SEVERE, "Exception: ", e.toString());
        }
    }

}
