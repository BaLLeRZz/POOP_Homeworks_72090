package com.providers;

import com.services.Cipherable;

import java.util.Random;

public class Wrapper {
    private int size;

    public Wrapper(int size) {
        this.setSize(size);
    }

    public final int getSize() {
        return this.size;
    }

    public final void setSize(int size) {
        if (size > 0)
            this.size = size;

        else
            this.size = 1;
    }

    private class FixedRandom implements Cipherable
    {
        @Override
        public char[] getSecretChars(int seed) {
            Random random = new Random(seed);
            char[] chars = new char[size];
            for (int i = 0; i < size; i++)
                chars[i] = (char) (65 + random.nextInt(26));

            return chars;
        }
    }

    public Cipherable makeFixedRandom()
    {
        return new FixedRandom();
    }

    private class FixedSelection implements Cipherable
    {
        @Override
        public char[] getSecretChars(int seed) {
            Random random = new Random();
            char[] seedChars = new char[seed];
            char[] chars = new char[size];
            char letter;
            boolean hasTheLetter = false;

            for (int i = 0; i < seed; i++)
            {
                letter = (char) (65 + random.nextInt(26));
                hasTheLetter = false;
                for (int j = 0; j < seedChars.length; j++)
                {
                    if (letter == seedChars[j]) {
                        hasTheLetter = true;
                        break;
                    }
                }

                if (!hasTheLetter)
                    seedChars[i] = letter;

                else
                    i--;
            }

            for (int i = 0; i < size; i++)
                chars[i] = seedChars[random.nextInt(seed)];

            return chars;
        }
    }

    public Cipherable makeFixedSelection()
    {
        return new FixedSelection();
    }
}
