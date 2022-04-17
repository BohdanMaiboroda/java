
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class QuickSort {

    static boolean click = false;
    static int low, high;
    static int columnCoordinates = 20;
    static int delayTime;


    static int []arrInt = new int[amounts()];
    static JButton []buttons = new JButton[arrInt.length];

    static JFrame jFrame = getFrame();
    static JPanel jPanel = new JPanel();
    static JTextField jTextField = new JTextField();

    static Thread quickSortThread;


    public static void main(String[] args) {

        jPanel.setLayout(null);
        jFrame.add(jPanel);

        JButton startButton, resetButton;

        startButton = new JButton();
        resetButton = new JButton();
        JLabel lable = new JLabel();


        startButton.setText("Start");
        resetButton.setText("Reset");
        lable.setText("Enter speed(milliseconds)");

        jPanel.add(jTextField);
        jPanel.add(startButton);
        jPanel.add(resetButton);
        jPanel.add(lable);

        startButton.setBounds(600, 100, 100, 40);
        resetButton.setBounds(600, 150, 100, 40);
        jTextField.setBounds(600, 200, 100, 40);
        lable.setBounds(600, 250, 200, 20);

        buttonArrayOnJFrame(columnCoordinates);

        startButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

        if (click == false) {
            setSpeed();
            quickSortThread = new Thread(() -> {
            low = 0;
            high = arrInt.length - 1;
            quickSort(arrInt, low, high);

           });
        quickSortThread.start();
         }

           if (click == true) {
           reverse(arrInt);
           jPanel.revalidate();
           }
          }
         }
        );


        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    restartApplication();
                } catch (URISyntaxException uriSyntaxException) {
                    uriSyntaxException.printStackTrace();
                }
            }
        });
    }


    public static void buttonArrayOnJFrame(int columnCoordinates){

            for (int i = 0; i < arrInt.length; i++) {

                arrInt[i] = 0 + (int) (Math.random() * 1000);
                String strContext = Integer.toString(arrInt[i]);
                buttons[i] = new JButton(strContext);

                if (i==10 || i==20){
                    columnCoordinates=20;
                }

                if (i<10) {
                    buttons[i].setBounds(10, columnCoordinates, 70, 40);
                }

                if(i>=10){
                    buttons[i].setBounds(110,columnCoordinates,70,40);
                }

                if(i>=20){
                    buttons[i].setBounds(210,columnCoordinates,70,40);
                }

                jPanel.add(buttons[i]);

                //System.out.println(strContext);
                columnCoordinates = columnCoordinates + 50;
            }

            jPanel.repaint();
        }


    public static int amounts(){

        String numOfNumbers = JOptionPane.showInputDialog("Enter the number of numbers to sort");

        if (numOfNumbers.matches("\\D")){
            JOptionPane.showMessageDialog(jPanel, "You didn't enter a number");
            return amounts();
        }
        int amount = Integer.parseInt(numOfNumbers.toString());

        if (amount > 30 || amount < 1){
            JOptionPane.showMessageDialog(jPanel, "Enter quantity from 1 to 30");
          return amounts();
        }
        return amount;
    }


    static void UpdateButtons(){

        for (int i = 0; i < arrInt.length; i++)
        {
            String strContext = Integer.toString(arrInt[i]);
            buttons[i].setText(strContext);
        }
    }

    static JFrame getFrame(){

        JFrame jFrame = new JFrame(){};
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setBounds(dimension.width/2- 400 , dimension.height/2 -300, 800 , 600);
        return jFrame;
    }


    public static long setSpeed(){

        String speed = jTextField.getText();

        if (speed.matches("\\D")){

            JOptionPane.showMessageDialog(jPanel, "You entered not a number, automatic time is now 1 second");
            int standartDelayTime = 1000;
            delayTime = standartDelayTime;
        }
        else {
            delayTime = Integer.parseInt(speed.toString());
        }
        return delayTime;
    }


    public static void quickSortIteration(){

        UpdateButtons();
        jPanel.repaint();

        try {
            Thread.sleep(delayTime);
        } catch (InterruptedException s) {
            s.printStackTrace();
        }
    }


    private static void swap(int [] arrInt, int i, int j) {

        int tmp = arrInt[i];
        arrInt[i] = arrInt[j];
        arrInt[j] = tmp;
    }


    public static void reverse(int []arrInt) {

            int i = 0;
            int j = arrInt.length - 1;

            while (i < j) {
                swap(arrInt, i, j);
                i++;
                j--;
            }

            for (int x = 0; x < arrInt.length; x++) {
                buttons[x].setText(Integer.toString(arrInt[x]));
            }
        }


      public static void quickSort(int []arrInt, int low, int high){

        if (arrInt.length == 0){
            return;
        }

        if (low >= high){
            quickSortIteration();
            return;
        }

        int middle = low + (high-low)/2;
        int opora = arrInt[middle];

        int i = low;
        int j = high;

        while (i<=j){

            while(arrInt[i] < opora){
                i++;
            }

            while (arrInt[j] > opora) {
                j--;
            }

            if (i<=j) {
                quickSortIteration();
                setColor(i,j,Color.yellow,Color.red);

                int temp = arrInt[i];
                arrInt[i] = arrInt[j];
                arrInt[j] = temp;

                quickSortIteration();
                setColor(i,j,Color.green,Color.green);

                i++;
                j--;

            }
        }

        if(low <j){
            quickSort(arrInt,low,j);

        }
        if (high>i){
            quickSort(arrInt,i,high);
        }
   click = true;

    }


    static void setColor(int i, int j, Color a, Color r){

        buttons[j].setBackground(a);
        buttons[i].setBackground(r);
    }


    public static void restartApplication() throws URISyntaxException {

        final String javaBin = System.getProperty("java.home") + File.separator + "bin" + File.separator + "java";
        final File currentJar = new File(QuickSort.class.getProtectionDomain().getCodeSource().getLocation().toURI());

        if (!currentJar.getName().endsWith(".jar")){

        return;
    }
        final ArrayList<String> command = new ArrayList<String>();
        command.add(javaBin);
        command.add("-jar");
        command.add(currentJar.getPath());

        final ProcessBuilder builder = new ProcessBuilder(command);
        try {
            builder.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }
}
