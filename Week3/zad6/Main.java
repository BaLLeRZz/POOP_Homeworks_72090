package fmi.poop.zad6;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        allFridays();
    }
    private static void allFridays()
    {
        // [1900, 2020]
        Locale bg = new Locale("bg", "BG");
        Locale.setDefault(bg);
        Random random = new Random();
        int year = 1900 + random.nextInt(121); // 2020 - 1900 + 1 = 121
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE dd MMMM yyyy");
        for (int i = 0; i < 12; i++)
        {
            LocalDate date = LocalDate.of(year, i + 1, 13);
            if (date.getDayOfWeek() == DayOfWeek.FRIDAY)
                System.out.println(formatter.format(date));
        }
    }
}
