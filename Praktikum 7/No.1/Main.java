public final class Main {
    public static void main(String[] args) {
        Pair<Length, Weight> p1 = new Pair<>(new Length(5.0), new Weight(80.0));
        Pair<Length, Weight> p2 = new Pair<>(new Length(4.0), new Weight(70.0));

        System.out.println(PairComparator.isGreater(p1, p2));

        Pair<Weight, Length> t1 = new Pair<>(new Weight(13), new Length(1.0));
        Pair<Weight, Length> t2 = new Pair<>(new Weight(18), new Length(2.0));

        System.out.println(PairComparator.isGreater(t1, t2));

        Pair<Weight, Temperature> s1 = new Pair<>(new Weight(13), new Temperature(1.0));
        Pair<Weight, Temperature> s2 = new Pair<>(new Weight(18), new Temperature(2.0));

        System.out.println(PairComparator.isGreater(s1, s2));

        Pair<Length, Weight> standardPair = new Pair<>(new Length(1200.0), new Weight(90.0));
        Pair<KilometerLength, GramWeight> specializedPair = new Pair<>(new KilometerLength(1.1), new GramWeight(85000));

        System.out.println(PairComparator.isGreater(standardPair, specializedPair));
    }
}
