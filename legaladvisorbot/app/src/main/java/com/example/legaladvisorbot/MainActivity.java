package com.example.legaladvisorbot;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText userInput;
    Button sendButton;
    TextView chatHistory;
    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userInput = findViewById(R.id.userInput);
        sendButton = findViewById(R.id.sendButton);
        chatHistory = findViewById(R.id.chatHistory);
        scrollView = findViewById(R.id.scrollView);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String question = userInput.getText().toString().trim();
                if (!question.isEmpty()) {
                    updateChat("You: " + question);
                    String response = getBotResponse(question);
                    updateChat("Bot: " + response);
                    userInput.setText("");
                }
            }
        });
    }

    private void updateChat(String message) {
        chatHistory.append(message + "\n\n");
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }

    private String getBotResponse(String userQuestion) {
        userQuestion = userQuestion.toLowerCase();

        if (userQuestion.contains("contract")) {
            return "A contract is a legally binding agreement between two or more parties.";
        } else if (userQuestion.contains("divorce")) {
            return "Divorce involves the legal dissolution of a marriage by a court or competent body.";
        } else if (userQuestion.contains("property")) {
            return "Property law covers ownership rights in both personal and real property.";
        } else if (userQuestion.contains("criminal")) {
            return "Criminal law deals with behavior that is or can be construed as an offense against the public, society, or state.";
        } else if (userQuestion.contains("intellectual property") || userQuestion.contains("copyright") || userQuestion.contains("trademark")) {
            return "Intellectual property law protects creations of the mind, like inventions, literary and artistic works, and symbols.";
        } else if (userQuestion.contains("employment") || userQuestion.contains("job") || userQuestion.contains("labor")) {
            return "Employment law governs the relationship between employers and employees, including workplace rights and responsibilities.";
        } else if (userQuestion.contains("immigration") || userQuestion.contains("visa") || userQuestion.contains("citizenship")) {
            return "Immigration law refers to national regulations that control who can enter or stay in a country.";
        } else if (userQuestion.contains("consumer") || userQuestion.contains("rights")) {
            return "Consumer rights laws protect buyers against unfair practices and defective products.";
        } else if (userQuestion.contains("cyber") || userQuestion.contains("internet") || userQuestion.contains("online crime")) {
            return "Cyber law deals with legal issues related to the internet, e-commerce, and cyber crimes.";
        } else if (userQuestion.contains("personal injury") || userQuestion.contains("accident")) {
            return "Personal injury law provides legal remedies to those who suffer harm from accidents or negligence.";
        } else if (userQuestion.contains("tax") || userQuestion.contains("taxation")) {
            return "Tax law covers the rules, policies, and laws that oversee the tax process.";
        } else if (userQuestion.contains("bankruptcy")) {
            return "Bankruptcy law involves the rights and obligations of an insolvent debtor and the creditors who have claims on that debtor's assets.";
        } else if (userQuestion.contains("will") || userQuestion.contains("estate") || userQuestion.contains("inheritance")) {
            return "Estate law deals with wills, trusts, and the distribution of a person's property after death.";
        } else {
            return "I'm a legal advisor bot. Could you please specify your question related to contracts, property, criminal, family, immigration, employment, cyber law, consumer rights, tax, or personal injury?";
        }
    }
}
