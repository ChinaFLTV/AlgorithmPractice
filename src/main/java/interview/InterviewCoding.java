package interview;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class InterviewCoding {


    private static final String FILE_PATH = "orders.txt";
    private static final int TOP_N = 10;
    private static final String OUTPUT_FORMAT = "%s, %.2f%n";


    private static void processOrder() {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(FILE_PATH)))) {

            reader.lines()
                    .parallel()
                    .skip(1)
                    .map(l -> {

                        String[] fieldVals = l.split(",");
                        return List.of(Long.parseLong(fieldVals[2]), Double.parseDouble(fieldVals[4]));

                    })
                    .sorted((o1, o2) -> (int) ((Double) o2.get(1) - (Double) o1.get(1)))
                    .limit(TOP_N)
                    .forEach(r -> System.out.println(String.format(OUTPUT_FORMAT, r.get(0), (Double) r.get(1))));


        } catch (IOException ignore) {


        }

    }


    public String solution(String arg1) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("final_user_list.txt")))) {

            String gender = arg1.split(",")[1];
            String birthDate = arg1.split(",")[2];
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            long birthSeconds = formatter.parse(birthDate).getSeconds();

            List<List<String>> best = reader.lines()
                    .parallel()
                    .map(l -> List.of(l.split(",")))
                    .filter(l -> l.get(1).equals(gender))
                    .sorted((o1, o2) -> {

                        try {

                            long dD1 = Math.abs(formatter.parse(o1.get(2)).getSeconds() - birthSeconds);
                            long dD2 = Math.abs(formatter.parse(o2.get(2)).getSeconds() - birthSeconds);

                            if (dD1 != dD2) {

                                return (int) (dD1 - dD2);

                            } else {

                                return o1.get(0).compareTo(o2.get(0));

                            }

                        } catch (ParseException e) {

                            throw new RuntimeException(e);

                        }

                    })
                    .limit(1)
                    .toList();

            return String.join(",", best.get(0));

        } catch (Exception ignore) {


        }

        return null;

    }


}