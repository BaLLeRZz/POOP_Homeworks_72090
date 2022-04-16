package fmi.poop.zad2a;

public class CeaserCipher {
    private int shiftLength;
    private static final int CAPITAL_A_CODE = 'A';

    public CeaserCipher(int shiftLength) {
        this.setShiftLength(shiftLength);
    }

    public CeaserCipher() {
        this.shiftLength = 3;
    }

    public int getShiftLength() {
        return this.shiftLength;
    }

    public void setShiftLength(int shiftLength) {
        if (shiftLength > 0 && shiftLength <= 26)
            this.shiftLength = shiftLength;
        else
            this.shiftLength = 3;
    }

    public String encrypt(String plainText)
    {
        char[] letters = plainText.toCharArray();
        // (letterCode - capitalACode + shiftLength) % 26 + capitalACode
        for (int i = 0; i < letters.length; i++)
        {
            int letterCode = letters[i];
            letters[i] = (char) ((letterCode - CAPITAL_A_CODE + this.shiftLength) % 26 + CAPITAL_A_CODE);
        }

        return new String(letters);
    }

    public String decrypt(String encryptedText)
    {
        char[] letters = encryptedText.toCharArray();
        for (int i = 0; i < letters.length; i++)
        {
            int letterCode = letters[i];
            letters[i] = (char) ((letterCode - CAPITAL_A_CODE - this.shiftLength + 26) % 26 + CAPITAL_A_CODE);
        }

        return new String(letters);
    }
}
