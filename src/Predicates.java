import java.util.function.Predicate;

public class Predicates {
    public static void main(String args[]) {

        //Making and testing predicates, predicates return a boolean value.
        Predicate<String> predicate = (s) -> s.length() > 0;
        Predicate<String> predicate2 = (s) -> s.length() > 100;

        System.out.print("Predicates: \n");
        System.out.print("predicate.test : " + predicate.test("foo") + "\n");
        System.out.print("predicate.negate : " + predicate.negate().test("foo") + "\n");
        System.out.print("predicate.test and predicate2.test : " + predicate.and(predicate2).test("foo") + "\n");
        System.out.print("predicate.test or predicate2.test : " + predicate.or(predicate2).test("foo") + "\n");

    }
}