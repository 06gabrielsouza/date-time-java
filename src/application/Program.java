package application;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Program {
    public static void main(String[] args) {

        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        LocalDate d01 = LocalDate.now();
        LocalDateTime d02 = LocalDateTime.now();
        Instant d03 = Instant.now();
        LocalDate d04 = LocalDate.parse("2025-01-20");
        LocalDateTime d05 = LocalDateTime.parse("2025-01-20T20:10:01");
        Instant d06 = Instant.parse("2025-01-20T20:10:01Z");
        Instant d07 = Instant.parse("2025-01-20T20:10:01-03:00");

        LocalDate d08 = LocalDate.parse("20/01/2025", fmt1);
        LocalDateTime d09 = LocalDateTime.parse("20/01/2025 20:35", fmt2);
        LocalDate d10 = LocalDate.of(2025,01,20);
        LocalDateTime d11 = LocalDateTime.of(2025,01,20,20,44);

        System.out.println("d01 = " + d01);
        System.out.println("d02 = " + d02);
        System.out.println("d03 = " + d03);
        System.out.println("d04 = " + d04);
        System.out.println("d05 = " + d05);
        System.out.println("d06 = " + d06);
        System.out.println("d07 = " + d07);
        System.out.println("d08 = " + d08);
        System.out.println("d09 = " + d09);
        System.out.println("d10 = " + d10);
        System.out.println("d11 = " + d11);

        //formatações
        DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt4 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        DateTimeFormatter fmt5 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm").withZone(ZoneId.systemDefault());

        System.out.println("d04 = " + d04.format(fmt3));
        System.out.println("d04 = " + fmt3.format(d04));
        System.out.println("d05 = " + fmt4.format(d05));
        System.out.println("d06 = " + fmt5.format(d06));

        //conversões
        for(String s : ZoneId.getAvailableZoneIds()){
            System.out.println(s);
        }

        LocalDate r1 = LocalDate.ofInstant(d06, ZoneId.systemDefault());
        System.out.println("r1 =" + r1);

        System.out.println("d04 day= "+ d04.getDayOfMonth());
        System.out.println("d04 monthday= "+ d04.getMonthValue());
        System.out.println("d04 year= " +d04.getYear());

        System.out.println("d05 hour= " +d05.getHour());
        System.out.println("d04 minute= " +d05.getMinute());

        //cálculos data-hora
        LocalDate pastWeekDate = d04.minusDays(7);
        LocalDate nextWeekDate = d04.plusDays(7);

        LocalDateTime pastWeekLocalDate = d05.minusDays(7);
        LocalDateTime nextWeekLocalDate = d05.plusDays(7);

        Instant pastWeekInstant = d06.minus(7, ChronoUnit.DAYS);
        Instant nextWeekInstant = d06.plus(7, ChronoUnit.DAYS);

        System.out.println("pastWeekDate = " + pastWeekDate);
        System.out.println("nextWeekDate = " + nextWeekDate);

        System.out.println("pastWeekLocalDate = " + pastWeekLocalDate);
        System.out.println("nextWeekLocalDate = " + nextWeekLocalDate);

        System.out.println("pastWeekInstant = " + pastWeekInstant);
        System.out.println("nextWeekInstant = " + nextWeekInstant);

        Duration t1 = Duration.between(pastWeekDate.atStartOfDay(), d04.atStartOfDay());
        Duration t2 = Duration.between(pastWeekLocalDate, d05);
        Duration t3 = Duration.between(pastWeekInstant, d06);
        Duration t4 = Duration.between(d06, pastWeekInstant);

        System.out.println("t1 dias = " + t1.toDays());
        System.out.println("t2 dias = " + t2.toDays());
        System.out.println("t3 dias = " + t3.toDays());
        System.out.println("t4 dias = " + t4.toDays());













    }
}
