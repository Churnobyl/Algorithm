import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Instant now = Instant.now();
        ZonedDateTime zdt = now.atZone(ZoneOffset.UTC);

        System.out.println(zdt.getYear());
        System.out.println(zdt.getMonthValue());
        System.out.println(zdt.getDayOfMonth());
    }

}
