
import database.MySQLiteDataBase;

//импорты
import mytelegram.Bot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;


public class JdbcMavenTest {


    public static void main(String[] args){
        System.out.println("Hello from jdbcSQLiteConnection and Telega bot");
        // System.out.println(MySQLiteDataBase.getSelect());

        //"заставил" свое приложение и Java машину
        //"проинициализировать" - загрузить в память
        //и сделать доступным все драйверы из maven
        //для работы с телеграммом
        ApiContextInitializer.init();
        //Класс для работы с телеграммом как с сервером
        //нужен мне только для регистрации своего класса
        //Bot при помощи которого я буду обрабатывать
        //приходящие сообщения
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try
        {
            //зарегистрировал свой токен -
            //теперь телеграм знает, что мое
            //приложение онлайн и ему можно передавать
            //данные
            telegramBotsApi.registerBot(Bot.getBot());
            // telegramBotsApi.registerBot(new Bot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
        //

       //
    }


}
