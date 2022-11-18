import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import java.awt.*;

public class guessTheNumberGame extends MyFrame {

    static int guessCounter = 0;
    static int l = 0;
    static int h = 0;

    private static final int[] previousGuessesLow = new int[10];
    private static final int[] previousGuessesHigh = new int[10];

    static int numberToGuess;
    static int guessedNumber;

    static String resultText = "";

    public static void GuessTheNumberGame() {

        MyFrame gameFrame = new MyFrame();

        MyLabel instructionText = new MyLabel(18);
        MyLabel remainingText = new MyLabel(16);
        MyLabel lowText = new MyLabel(16);
        MyLabel highText = new MyLabel(16);

        JTextPane leftTextArea = new JTextPane();
        JTextPane rightTextArea = new JTextPane();

        MyTextField numberToGuessEntry = new MyTextField();
        MyTextField guessedNumberEntry = new MyTextField();

        instructionText.setText("Enter the number you want people to guess!");
        instructionText.setHorizontalAlignment(JLabel.CENTER);
        instructionText.setHorizontalAlignment(JLabel.CENTER);

        remainingText.setText("Guesses Remaining: 10");
        remainingText.setVisible(false);

        lowText.setVisible(false);
        lowText.setVerticalTextPosition(JLabel.BOTTOM);
        highText.setVisible(false);
        highText.setVerticalTextPosition(JLabel.BOTTOM);

        StyledDocument docLeft = leftTextArea.getStyledDocument();
        SimpleAttributeSet centerLeft = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerLeft, StyleConstants.ALIGN_CENTER);
        docLeft.setParagraphAttributes(0, docLeft.getLength(), centerLeft, false);

        StyledDocument docRight = rightTextArea.getStyledDocument();
        SimpleAttributeSet centerRight = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerRight, StyleConstants.ALIGN_CENTER);
        docRight.setParagraphAttributes(0, docRight.getLength(), centerRight, false);

        remainingText.setHorizontalAlignment(JLabel.CENTER);
        remainingText.setVerticalAlignment(JLabel.TOP);

        lowText.setText("Low");
        lowText.setForeground(Color.ORANGE);
        lowText.setHorizontalAlignment(JLabel.CENTER);
        lowText.setVerticalAlignment(JLabel.BOTTOM);
        lowText.setFocusable(false);

        leftTextArea.setForeground(Color.ORANGE);
        leftTextArea.setBackground(Color.LIGHT_GRAY);
        leftTextArea.setFont(new Font("Comic Sans", Font.BOLD, 18));
        rightTextArea.setForeground(Color.BLUE);
        rightTextArea.setBackground(Color.LIGHT_GRAY);
        rightTextArea.setFont(new Font("Comic Sans", Font.BOLD, 18));

        highText.setText("High");
        highText.setForeground(Color.BLUE);
        highText.setHorizontalAlignment(JLabel.CENTER);
        highText.setVerticalAlignment(JLabel.BOTTOM);
        highText.setFocusable(false);

        gameFrame.middlePanel.setLayout(new BorderLayout());
        gameFrame.middlePanel.add(instructionText);
        gameFrame.bottomPanel.add(numberToGuessEntry);
        gameFrame.guessPanel.add(remainingText);
        gameFrame.leftPanel.add(lowText);
        gameFrame.leftPanel.add(leftTextArea);
        gameFrame.rightPanel.add(highText);
        gameFrame.rightPanel.add(rightTextArea);

        numberToGuessEntry.requestFocus();

        // Method once number to guess has been entered!
        numberToGuessEntry.addActionListener(e -> {
            numberToGuess = Integer.parseInt(numberToGuessEntry.getText());
            numberToGuessEntry.setText("");
            instructionText.setText("Enter your guess below..");
            numberToGuessEntry.setVisible(false);
            gameFrame.bottomPanel.add(guessedNumberEntry);
            remainingText.setVisible(true);
            lowText.setVisible(true);
            highText.setVisible(true);
            guessedNumberEntry.requestFocus();
        });

        // Guessed number method
        guessedNumberEntry.addActionListener(e -> {
            if (!guessedNumberEntry.getText().trim().isEmpty()) {
                guessedNumber = Integer.parseInt(guessedNumberEntry.getText());
                guessedNumberEntry.setText("");
                gameLogic();

                // Print low guesses to JTextArea Left
                leftTextArea.setText("");
                rightTextArea.setText("");
                for (int i = 0; i < 10; i++) {
                    if (previousGuessesLow[i] == 0) continue;
                    leftTextArea.setText((leftTextArea.getText() + (previousGuessesLow[i] + "\n")));
                }

                // Print High guesses to JTextArea Right
                for (int i = 0; i < 10; i++) {
                    if (previousGuessesHigh[i] == 0) continue;
                    rightTextArea.setText((rightTextArea.getText() + (previousGuessesHigh[i] + "\n")));

                }
                // Set remaining guesses
                remainingText.setText("Remaining Guesses: " + (10 - guessCounter));
                instructionText.setText(resultText);
                if (resultText.equals("Ran out of guesses!     GAME OVER!")){
                    // Quit Game after running out of guesses
                    int delay = 2000;
                    Timer timer = new Timer(delay, e1 -> Runtime.getRuntime().exit(0));
                    timer.setRepeats(false);
                    timer.start();
                } else if (resultText.equals("Correct Answer!    WELL DONE")){
                    // Quit Game after winning
                    int delay = 2000;
                    Timer timer = new Timer(delay, e12 -> Runtime.getRuntime().exit(0));
                    timer.setRepeats(false);
                    timer.start();
                }
                int delay = 2000;
                Timer timer = new Timer(delay, e13 -> instructionText.setText("Enter your guess below.."));
                timer.setRepeats(false);
                timer.start();
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