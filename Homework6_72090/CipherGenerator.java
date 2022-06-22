package com.providers;

import com.services.Cipherable;

public class CipherGenerator {
    public static Result countDistinct(Cipherable cipher, int seed)
    {
        char[] chars = cipher.getSecretChars(seed);
        boolean isUnique = false;
        int count = 0;
        for (int i = 0; i < chars.length; i++)
        {
            isUnique = true;
            for (int j = 0; j < chars.length; j++)
            {
                if (chars[i] == chars[j] && i != j)
                {
                    isUnique = false;
                    break;
                }
            }

            if (isUnique)
                count++;
        }

        return new Result(chars, count);
    }
}
