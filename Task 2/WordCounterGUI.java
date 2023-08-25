import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordCounterGUI {
    private JFrame frame;
    private JTextArea inputTextArea;
    private JTextArea resultTextArea;
    private JButton countButton;

    public WordCounterGUI() {
        frame = new JFrame("Word Counter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        
        // Styling: Set overall background color
        frame.getContentPane().setBackground(new Color(0, 0, 0));

        inputTextArea = new JTextArea(10, 30);
        inputTextArea.setBorder(new TitledBorder("Input Text")); // Styling: Add border
        JScrollPane inputScrollPane = new JScrollPane(inputTextArea);
        frame.add(inputScrollPane, BorderLayout.CENTER);

        countButton = new JButton("Count Words");
        countButton.setBackground(new Color(240, 13, 7)); // Styling: Set button color
        countButton.setForeground(Color.WHITE); // Styling: Set text color
        frame.add(countButton, BorderLayout.SOUTH);

        resultTextArea = new JTextArea(10, 30);
        resultTextArea.setEditable(false);
        resultTextArea.setBorder(new TitledBorder("Word Count Result")); // Styling: Add border
        JScrollPane resultScrollPane = new JScrollPane(resultTextArea);
        frame.add(resultScrollPane, BorderLayout.EAST);
        
        // Styling: Set margins
        inputScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        resultScrollPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        countButton.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countWords();
            }
        });

        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null); // Styling: Center the frame on screen
    }

    private void countWords() {
        String text = inputTextArea.getText().trim();

        String[] words = text.replaceAll("[^a-zA-Z ]", "").split("\\s+");

        int wordCount = 0;

        Set<String> stopWords = new HashSet<>();
        stopWords.add("the");
        stopWords.add("and");
        stopWords.add("is");
        
        Map<String, Integer> wordFrequency = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word.toLowerCase())) {
                wordCount++;
                wordFrequency.put(word, wordFrequency.getOrDefault(word, 0) + 1);
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Total word count (excluding stop words): ").append(wordCount).append("\n");
        resultBuilder.append("Number of unique words: ").append(wordFrequency.size()).append("\n");
        resultBuilder.append("Word frequencies:\n");

        for (Map.Entry<String, Integer> entry : wordFrequency.entrySet()) {
            resultBuilder.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
        }

        resultTextArea.setText(resultBuilder.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new WordCounterGUI();
            }
        });
    }
}
