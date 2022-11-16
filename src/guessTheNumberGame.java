import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class guessTheNumberGame extends MyFrame {

    static int guessCounter = 0;

    private static int[] previousGuesses = new int[10];

    static int numberToGuess;
    static int guessedNumber;
    static boolean runnable = true;
    static String resultText = "";



    public static void GuessTheNumberGame() {

        MyFrame gameFrame = new MyFrame();

        MyLabel instructionText = new MyLabel();
        MyLabel remainingText = new MyLabel();
        MyLabel guessesText = new MyLabel();
        MyLabel previousGuessText = new MyLabel();

        MyTextField numberToGuessEntry = new MyTextField();
        MyTextField guessedNumberEntry = new MyTextField();

        instructionText.setText("Enter the number you want people to guess!");
        instructionText.setFont(new Font("Comic Sans", Font.BOLD, 18));
        instructionText.setHorizontalAlignment(JLabel.CENTER);
        instructionText.setHorizontalAlignment(JLabel.CENTER);

        remainingText.setText("Guesses Remaining: 10");
        remainingText.setHorizontalAlignment(JLabel.LEFT);
        remainingText.setVerticalAlignment(JLabel.TOP);
        remainingText.setVisible(false);
        previousGuessText.setVisible(false);

        guessesText.setHorizontalAlignment(JLabel.CENTER);
        guessesText.setFont(new Font("Comic Sans", Font.BOLD, 15));

        previousGuessText.setHorizontalAlignment(JLabel.CENTER);
        previousGuessText.setText("Previous Guesses");
        previousGuessText.setFont(new Font("Comic Sams", Font.BOLD, 17));

        gameFrame.middlePanel.setLayout(new BorderLayout());
        gameFrame.middlePanel.add(instructionText);
        gameFrame.topPanel.add(remainingText);
        gameFrame.bottomPanel.add(numberToGuessEntry);
        gameFrame.guessPanel.add(previousGuessText);
        gameFrame.guessPanel.add(guessesText);



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

        guessedNumberEntry.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!guessedNumberEntry.getText().trim().isEmpty()) {
                    guessedNumber = Integer.parseInt(guessedNumberEntry.getText());
                    guessedNumberEntry.setText("");
                    gameLogic();
                    guessesText.setText(Arrays.toString(previousGuesses));
                    remainingText.setText("Remaining Guesses: " + (10 - guessCounter));
                    instructionText.setText(resultText);
                    if (resultText == "Ran out of guesses!     GAME OVER!"){
                        // Quit Game after running out of guesses
                        int delay = 1000;
                        Timer timer = new Timer(delay, new ActionListener() {
                            public void actionPerformed(ActionEvent e) {
                                Runtime.getRuntime().exit(0);
                            };
                        });
                        timer.setRepeats(false);
                        timer.start();
                    } else if (resultText == "Correct Answer!    WELL DONE"){
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
        if (checkForValue(guessedNumber) == false) {
            guessCounter++;
            if (guessCounter < 10) {
                if (guessedNumber < numberToGuess) {
                    //Guess to low
                    resultText = "Guess too Low!";
                    previousGuesses[guessCounter - 1] = guessedNumber;


                } else if (guessedNumber > numberToGuess) {
                    //Guess to high
                    resultText = "Guess too High!";
                    previousGuesses[guessCounter - 1] = guessedNumber;
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
                if (previousGuesses[i] == val) return true;
        }
        return false; //it will reach here if return true was not called.
    }
}