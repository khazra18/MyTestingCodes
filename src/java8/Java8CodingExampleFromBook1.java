package java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.*;

public class Java8CodingExampleFromBook1 {


    private static List<Transaction> transactions;

    public static void main(String[] args) {

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");
        transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //Find all transactions in the year 2011 and sort them by value (small to high)
        method1();

        //What are all the unique cities where the traders work?
        method2();

        //Find all traders from Cambridge and sort them by name
        method3();

        //Return a string of all traders names sorted alphabetically.
        method4();

        //Are any traders based in Milan?
        method5();

        //Print the values of all transactions from the traders living in Cambridge.
        method6();

        //What’s the highest value of all the transactions?
        method7();

        //Find the transaction with the smallest value
        method8();

    }

    private static void method8() {

        //Find the transaction with the smallest value
        Optional<Transaction> min = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue));

        min.ifPresent(System.out::println);

    }

    private static void method7() {

        //What’s the highest value of all the transactions?
        Optional<Transaction> max = transactions.stream()
                .max(Comparator.comparing(Transaction::getValue));

        max.ifPresent(System.out::println);

    }

    private static void method6() {

        //Print the values of all transactions from the traders living in Cambridge.
        List<Transaction> list = transactions.stream()
                .filter(e -> e.getTrader().getCity().equalsIgnoreCase("Cambridge"))
                .collect(toList());

        System.out.println(list);

    }

    private static void method5() {

        //Are any traders based in Milan?
        boolean milan = transactions.stream().anyMatch(e -> e.getTrader().getCity().equalsIgnoreCase("milan"));
        System.out.println(milan);

    }

    private static void method4() {

        //Return a string of all traders’ names sorted alphabetically.
        List<String> list = transactions.stream()
                .map(e -> e.getTrader().getName())
                .sorted()
                .distinct()
                .collect(toList());

        System.out.println(list);

    }

    private static void method3() {

        //Find all traders from Cambridge and sort them by name
        List<Trader> list = transactions.stream()
                .map(Transaction::getTrader)
                .filter(e -> e.getCity().equalsIgnoreCase("Cambridge"))
                .sorted(Comparator.comparing(Trader::getName))
                .collect(toList());

        System.out.println(list);

    }

    private static void method2() {
        //What are all the unique cities where the traders work?
        List<String> uniqueCities = transactions.stream()
                .map(e -> e.getTrader().getCity())
                .distinct()
                .collect(toList());

        System.out.println(uniqueCities);

    }

    private static void method1() {

        //Find all transactions in the year 2011 and sort them by value (small to high)
        List<Transaction> myList = transactions.stream()
                .filter(e -> e.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(toList());

        System.out.println(myList);


    }

}

class Trader {
    private final String name;
    private final String city;

    public Trader(String n, String c) {
        this.name = n;
        this.city = c;
    }

    public String getName() {
        return this.name;
    }

    public String getCity() {
        return this.city;
    }

    public String toString() {
        return "Trader:" + this.name + " in " + this.city;
    }
}

class Transaction {
    private final Trader trader;
    private final int year;
    private final int value;

    public Transaction(Trader trader, int year, int value) {
        this.trader = trader;
        this.year = year;
        this.value = value;
    }

    public Trader getTrader() {
        return this.trader;
    }

    public int getYear() {
        return this.year;
    }

    public int getValue() {
        return this.value;
    }

    public String toString() {
        return "{" + this.trader + ", " +
                "year: " + this.year + ", " +
                "value:" + this.value + "}";
    }
}