import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class guessTheNumberGame extends MyFrame {

    static int guessCounter = 0;
    static int l = 0;
    static int h = 0;

    private static int[] previousGuessesLow = new int[10];
    private static int[] previousGuessesHigh = new int[10];

    static int numberToGuess;
    static int guessedNumber;

    static String resultText = "";

    public static void GuessTheNumberGame() {

        MyFrame gameFrame = new MyFrame();

        MyLabel instructionText = new MyLabel(18);
        MyLabel remainingText = new MyLabel(12);
        MyLabel guessesTextLow = new MyLabel(12);
        MyLabel guessesTextHigh = new MyLabel(12);
        MyLabel previousGuessText = new MyLabel(12);
        MyLabel lowText = new MyLabel(12);
        MyLabel highText = new MyLabel(12);

        MyTextField numberToGuessEntry = new MyTextField();
        MyTextField guessedNumberEntry = new MyTextField();

        instructionText.setText("Enter the number you want people to guess!");
        instructionText.setHorizontalAlignment(JLabel.CENTER);
        instructionText.setHorizontalAlignment(JLabel.CENTER);

        remainingText.setText("Guesses Remaining: 10");
        remainingText.setHorizontalAlignment(JLabel.CENTER);
        remainingText.setVerticalAlignment(JLabel.BOTTOM);
        remainingText.setHorizontalAlignment(JLabel.CENTER);
        remainingText.setVerticalTextPosition(JLabel.BOTTOM);
        remainingText.setVisible(false);
        previousGuessText.setVisible(false);

        previousGuessText.setHorizontalAlignment(JLabel.CENTER);
        previousGuessText.setVerticalAlignment(JLabel.TOP);
        previousGuessText.setHorizontalTextPosition(JLabel.CENTER);
        previousGuessText.setVerticalTextPosition(JLabel.CENTER);
        previousGuessText.setText("Previous Guesses");

        guessesTextLow.setVerticalAlignment(JLabel.CENTER);
        guessesTextLow.setHorizontalTextPosition(JLabel.CENTER);
        guessesTextHigh.setVerticalAlignment(JLabel.CENTER);
        guessesTextHigh.setHorizontalTextPosition(JLabel.CENTER);

        lowText.setText("Low");
        lowText.setHorizontalAlignment(JLabel.CENTER);
        lowText.setHorizontalTextPosition(JLabel.CENTER);
        highText.setText("High");
        highText.setHorizontalAlignment(JLabel.CENTER);
        highText.setVerticalAlignment(JLabel.CENTER);

        gameFrame.middlePanel.setLayout(new BorderLayout());
        gameFrame.middlePanel.add(instructionText);
        gameFrame.bottomPanel.add(numberToGuessEntry);
        gameFrame.guessPanel.add(lowText);
        gameFrame.guessPanel.add(previousGuessText);
        gameFrame.guessPanel.add(highText);
        gameFrame.guessPanel.add(guessesTextLow);
        gameFrame.guessPanel.add(remainingText);
        gameFrame.guessPanel.add(guessesTextHigh);

        // Method once number to guess has been entered!
        numberToGuessEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numberToGuess = Integer.parseInt(numberToGuessEntry.getText());
                numberToGuessEntry.setText("");
                instructionText.setText("Enter your guess below..");
                numberToGuessEntry.setVisible(false);
                gameFrame.bottomPanel.add(guessedNumberEntry);
                remainingText.setVisible(true);
                previousGuessText.setVisible(true);

            }
        });

        // Guessed number method
        guessedNumberEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!guessedNumberEntry.getText().trim().isEmpty()) {
                    guessedNumber = Integer.parseInt(guessedNumberEntry.getText());
                    guessedNumberEntry.setText("");
                    gameLogic();
                    // Set too low previous answers from array [*][]
                    guessesTextLow.setText(Arrays.toString(previousGuessesLow));
                    // Set too high previous answers from array [][*]
                    guessesTextHigh.setText(Arrays.toString(previousGuessesHigh));
                    // Set remaining guesses
                    remainingText.setText("Remaining Guesses: " + (10 - guessCounter));
                    instructionText.setText(resultText);
                    if (resultText.equals("Ran out of guesses!     GAME OVER!")){
                        // Quit Game after running out of guesses
                        int delay = 1000;
                        Timer timer = new Timer(delay, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Runtime.getRuntime().exit(0);
                            };
                        });
                        timer.setRepeats(false);
                        timer.start();
                    } else if (resultText.equals("Correct Answer!    WELL DONE")){
                        // Quit Game after winning
                        int delay = 1000;
                        Timer timer = new Timer(delay, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Runtime.getRuntime().exit(0);
                            };
                        });
                        timer.setRepeats(false);
                        timer.start();
                    }
                    int delay = 1000;
                    Timer timer = new Timer(delay, new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            instructionText.setText("Enter your guess below..");
                        };
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            }
        });
    }

    public static void gameLogic() {
        if (!checkForValue(guessedNumber)) {
            guessCounter++;
            if (guessCounter < 10) {
                if (guessedNumber < numberToGuess) {
                    //Guess to low
                    l++;
                    resultText = "Guess too Low!";
                    previousGuessesLow[l - 1] = guessedNumber;


                } else if (guessedNumber > numberToGuess) {
                    //Guess to high
                    h++;
                    resultText = "Guess too High!";
                    previousGuessesHigh[h - 1] = guessedNumber;
                } else {
                    // Correct Answer
                    resultText = "Correct Answer!    WELL DONE";
                }
            }else {
                // Ran out of guesses
                resultText = "Ran out of guesses!     GAME OVER!";
            }
        } else {
            // Number already chosen
            resultText = "Number already guessed, Try Again!";

        }
    }

    // Check if already guessed
    public static boolean checkForValue(int val) {
        for (int i = 0; i < 10; i++) {
            if (previousGuessesLow[i] == val) return true;}
        for (int j = 0; j < 10 ; j++) {
                if (previousGuessesHigh[j] == val) return true;}

        return false; //it will reach here if return true was not called.
    }
}