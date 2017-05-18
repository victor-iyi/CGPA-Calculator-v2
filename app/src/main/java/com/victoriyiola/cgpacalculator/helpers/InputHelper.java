package com.victoriyiola.cgpacalculator.helpers;


import android.widget.TextView;

public class InputHelper {

    private TextView result;

    public InputHelper(TextView result) {
        this.result = result;
    }

    public void appendToResult(String word) {
        String resultText = this.result.getText().toString();
        if (resultText.length() < 3) {
            if (!resultText.equals("0"))
                word = resultText.concat(word);
            this.result.setText(word);
        }
    }

    public void deleteLastCharacter() {
        String resultText = this.result.getText().toString();
        StringBuilder num = new StringBuilder(resultText);
        if (resultText.length() > 0)
            resultText = num.delete(resultText.length() - 1, resultText.length()).toString();
        this.result.setText(resultText);
        if (resultText.length() == 0)
            this.result.setText("0");
    }

}
