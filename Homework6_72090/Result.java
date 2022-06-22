package com.providers;

public class Result {
    private char[] chars;
    private int data;

    public Result(char[] chars, int data) {
        this.setChars(chars);
        this.setData(data);
    }

    public final char[] getChars() {
        return this.chars;
    }

    public final void setChars(char[] chars) {
        if (chars.length > 0)
        {
            this.chars = new char[chars.length];
            for (int i = 0; i < chars.length; i++) {
                this.chars[i] = chars[i];
            }
        }

        else
            this.chars = new char[1];
    }

    public final int getData() {
        return this.data;
    }

    public final void setData(int data) {
        if (data >= 0)
            this.data = data;

        else
            this.data = 0;
    }

    @Override
    public String toString() {
        String charsCopy = "[";
        for (int i = 0; i < this.chars.length; i++) {
            if (i == this.chars.length - 1)
            {
                charsCopy += this.chars[i];
                charsCopy += ']';
                break;
            }

            charsCopy += this.chars[i] + ", ";
        }

        return "Chars: " + charsCopy + "\nResult: " + data;
    }
}
