import java.util.Scanner;

public class App
{
    boolean wash = false, adams = false, jefferson = false, madison = false, monroe = false,
            jq_adams = false, jackson = false, buren = false, w_h_harrison = false, tyler = false,
            polk = false, taylor = false, fillmore = false, pierce = false, buchanan = false,
            lincoln = false, johnson = false, grant = false, hayes = false, garfield = false,
            arthur = false, cleveland = false, b_harrison = false, mckinley = false,
            t_roosevelt = false, taft = false, wilson = false, harding = false, coolidge = false,
            hoover = false, fdr = false, truman = false, eisenhower = false, kennedy = false,
            lbj = false, nixon = false, ford = false, carter = false, reagan = false,
            h_w_bush = false, clinton = false, w_bush = false, obama = false, trump = false,
            biden = false;

    public static void main(String[] args)
    {
        App program = new App();
        program.run();
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        long start = System.nanoTime();
        while (true){
            clearConsole();
            displayPresidentsInTwoColumns();

            System.out.print("\n\nName a president (Type exit to quit): ");
            String answer = input.nextLine();
            if (answer.toLowerCase().contains("exit") || answer.toLowerCase().contains("quit")) {
                break;
            } else {
                processAnswer(answer.toLowerCase());
            }
        }
    }

    private void displayPresidentsInTwoColumns() {
        PresidentEntry[] entries = {
            new PresidentEntry("1789-1793", "George Washington", wash),
            new PresidentEntry("1793-1797", "George Washington", wash),
            new PresidentEntry("1797-1801", "John Adams", adams),
            new PresidentEntry("1801-1805", "Thomas Jefferson", jefferson),
            new PresidentEntry("1805-1809", "Thomas Jefferson", jefferson),
            new PresidentEntry("1809-1813", "James Madison", madison),
            new PresidentEntry("1813-1817", "James Madison", madison),
            new PresidentEntry("1817-1821", "James Monroe", monroe),
            new PresidentEntry("1821-1825", "James Monroe", monroe),
            new PresidentEntry("1825-1829", "John Quincy Adams", jq_adams),
            new PresidentEntry("1829-1833", "Andrew Jackson", jackson),
            new PresidentEntry("1833-1837", "Andrew Jackson", jackson),
            new PresidentEntry("1837-1841", "Martin Van Buren", buren),
            new PresidentEntry("1841", "William Henry Harrison", w_h_harrison),
            new PresidentEntry("1841-1845", "John Tyler", tyler),
            new PresidentEntry("1845-1849", "James Polk", polk),
            new PresidentEntry("1849-1850", "Zachary Taylor", taylor),
            new PresidentEntry("1850-1853", "Millard Fillmore", fillmore),
            new PresidentEntry("1853-1857", "Franklin Pierce", pierce),
            new PresidentEntry("1857-1861", "James Buchanan", buchanan),
            new PresidentEntry("1861-1865", "Abraham Lincoln", lincoln),
            new PresidentEntry("1865-1869", "Andrew Johnson", johnson),
            new PresidentEntry("1869-1873", "Ulysses S. Grant", grant),
            new PresidentEntry("1873-1877", "Ulysses S. Grant", grant),
            new PresidentEntry("1877-1881", "Rutherford B. Hayes", hayes),
            new PresidentEntry("1881", "James Garfield", garfield),
            new PresidentEntry("1881-1885", "Chester A. Arthur", arthur),
            new PresidentEntry("1885-1889", "Grover Cleveland", cleveland),
            new PresidentEntry("1889-1893", "Benjamin Harrison", b_harrison),
            new PresidentEntry("1893-1897", "Grover Cleveland", cleveland),
            new PresidentEntry("1897-1901", "William McKinley", mckinley),
            new PresidentEntry("1901-1905", "Theodore Roosevelt", t_roosevelt),
            new PresidentEntry("1905-1909", "Theodore Roosevelt", t_roosevelt),
            new PresidentEntry("1909-1913", "William Taft", taft),
            new PresidentEntry("1913-1917", "Woodrow Wilson", wilson),
            new PresidentEntry("1917-1921", "Woodrow Wilson", wilson),
            new PresidentEntry("1921-1923", "Warren G. Harding", harding),
            new PresidentEntry("1923-1925", "Calvin Coolidge", coolidge),
            new PresidentEntry("1925-1929", "Calvin Coolidge", coolidge),
            new PresidentEntry("1929-1933", "Herbert Hoover", hoover),
            new PresidentEntry("1933-1937", "Franklin Roosevelt", fdr),
            new PresidentEntry("1937-1941", "Franklin Roosevelt", fdr),
            new PresidentEntry("1941-1945", "Franklin Roosevelt", fdr),
            new PresidentEntry("1945-1949", "Harry Truman", truman),
            new PresidentEntry("1949-1953", "Harry Truman", truman),
            new PresidentEntry("1953-1957", "Dwight Eisenhower", eisenhower),
            new PresidentEntry("1957-1961", "Dwight Eisenhower", eisenhower),
            new PresidentEntry("1961-1963", "John F. Kennedy", kennedy),
            new PresidentEntry("1963-1965", "Lyndon B. Johnson", lbj),
            new PresidentEntry("1965-1969", "Lyndon B. Johnson", lbj),
            new PresidentEntry("1969-1973", "Richard Nixon", nixon),
            new PresidentEntry("1973-1974", "Richard Nixon", nixon),
            new PresidentEntry("1974-1977", "Gerald Ford", ford),
            new PresidentEntry("1977-1981", "Jimmy Carter", carter),
            new PresidentEntry("1981-1985", "Ronald Reagan", reagan),
            new PresidentEntry("1985-1989", "Ronald Reagan", reagan),
            new PresidentEntry("1989-1993", "George H.W. Bush", h_w_bush),
            new PresidentEntry("1993-1997", "Bill Clinton", clinton),
            new PresidentEntry("1997-2001", "Bill Clinton", clinton),
            new PresidentEntry("2001-2005", "George W. Bush", w_bush),
            new PresidentEntry("2005-2009", "George W. Bush", w_bush),
            new PresidentEntry("2009-2013", "Barack Obama", obama),
            new PresidentEntry("2013-2017", "Barack Obama", obama),
            new PresidentEntry("2017-2021", "Donald Trump", trump),
            new PresidentEntry("2021-2025", "Joe Biden", biden),
            new PresidentEntry("2025-Present", "Donald Trump", trump)
        };

        int totalEntries = entries.length;
        int halfWay = (int) Math.ceil(totalEntries / 2.0);
        int yearWidth = 12;
        int nameWidth = 25;

        for (int i = 0; i < halfWay; i++) {
            PresidentEntry entry1 = entries[i];

            String leftName = entry1.guessed ? entry1.name : "";
            System.out.printf("%-" + yearWidth + "s %-" + nameWidth + "s",
                              entry1.years + ":", leftName);

            int rightIndex = i + halfWay;
            if (rightIndex < totalEntries) {
                PresidentEntry entry2 = entries[rightIndex];
                String rightName = entry2.guessed ? entry2.name : "";
                System.out.printf("%-" + yearWidth + "s %-" + nameWidth + "s%n",
                                  entry2.years + ":", rightName);
            } else {
                System.out.println();
            }
        }
    }

    private void processAnswer(String answer) {
        if (answer.contains("washington")){ wash = true;
        } else if (answer.contains("adams")){ adams = true; jq_adams = true;
        } else if (answer.contains("jefferson")){ jefferson = true;
        } else if (answer.contains("madison")){ madison = true;
        } else if (answer.contains("monroe")){ monroe = true;
        } else if (answer.contains("jackson")){ jackson = true;
        } else if (answer.contains("buren") || answer.contains("van buren")){ buren = true;
        } else if (answer.contains("william henry harrison")){ w_h_harrison = true;
        } else if (answer.contains("benjamin harrison")){ b_harrison = true;
        } else if (answer.contains("harrison")){ w_h_harrison = true; b_harrison = true;
        } else if (answer.contains("tyler") || answer.contains("accidency")){ tyler = true;
        } else if (answer.contains("polk")){ polk = true;
        } else if (answer.contains("taylor")){ taylor = true;
        } else if (answer.contains("fillmore")){ fillmore = true;
        } else if (answer.contains("pierce")){ pierce = true;
        } else if (answer.contains("buchanan")){ buchanan = true;
        } else if (answer.contains("lincoln")){ lincoln = true;
        } else if (answer.contains("andrew johnson")){ johnson = true;
        } else if (answer.contains("lyndon johnson") || answer.contains("lbj")){ lbj = true;
        } else if (answer.contains("johnson")){ johnson = true; lbj = true;
        } else if (answer.contains("grant")){ grant = true;
        } else if (answer.contains("hayes")){ hayes = true;
        } else if (answer.contains("garfield")){ garfield = true;
        } else if (answer.contains("arthur")){ arthur = true;
        } else if (answer.contains("cleveland")){ cleveland = true;
        } else if (answer.contains("mckinley")){ mckinley = true;
        } else if (answer.contains("theodore roosevelt") || answer.contains("teddy roosevelt")){ t_roosevelt = true;
        } else if (answer.contains("franklin roosevelt") || answer.contains("fdr")){ fdr = true;
        } else if (answer.contains("roosevelt")){ t_roosevelt = true; fdr = true;
        } else if (answer.contains("taft")){ taft = true;
        } else if (answer.contains("wilson")){ wilson = true;
        } else if (answer.contains("harding")){ harding = true;
        } else if (answer.contains("coolidge")){ coolidge = true;
        } else if (answer.contains("hoover")){ hoover = true;
        } else if (answer.contains("truman")){ truman = true;
        } else if (answer.contains("eisenhower")){ eisenhower = true;
        } else if (answer.contains("kennedy") || answer.contains("jfk")){ kennedy = true;
        } else if (answer.contains("nixon")){ nixon = true;
        } else if (answer.contains("ford")){ ford = true;
        } else if (answer.contains("carter")){ carter = true;
        } else if (answer.contains("reagan")){ reagan = true;
        } else if (answer.contains("george h w bush") || answer.contains("h w bush")){ h_w_bush = true;
        } else if (answer.contains("george w bush") || answer.contains("w bush")){ w_bush = true;
        } else if (answer.contains("bush")){ h_w_bush = true; w_bush = true;
        } else if (answer.contains("clinton")){ clinton = true;
        } else if (answer.contains("obama")){ obama = true;
        } else if (answer.contains("trump")){ trump = true;
        } else if (answer.contains("biden")){ biden = true;
        }
    }

    private class PresidentEntry {
        String years;
        String name;
        boolean guessed;

        PresidentEntry(String years, String name, boolean guessed) {
            this.years = years;
            this.name = name;
            this.guessed = guessed;
        }
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J\033[3J");
        System.out.flush();
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
        }
    }
}
