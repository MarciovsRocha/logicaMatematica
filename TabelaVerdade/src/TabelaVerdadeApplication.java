public class TabelaVerdadeApplication {
    public static void main(String[] args) {
        TabelaVerdade t1_0 = new TabelaVerdade("p");

        TabelaVerdade t2_0 = new TabelaVerdade("~p");


        TabelaVerdade t3_0 = new TabelaVerdade("pvq");
        TabelaVerdade t3_1 = new TabelaVerdade("p^q");

        TabelaVerdade t4_0 = new TabelaVerdade("~pvq");
        TabelaVerdade t4_1 = new TabelaVerdade("~p^q");
        TabelaVerdade t4_3 = new TabelaVerdade("p^~q");
        TabelaVerdade t4_4 = new TabelaVerdade("pv~q");


        TabelaVerdade t5_0 = new TabelaVerdade("~pv~q");
        TabelaVerdade t5_1 = new TabelaVerdade("~p^~q");
        TabelaVerdade t5_6 = new TabelaVerdade("pvqvr");
        TabelaVerdade t5_7 = new TabelaVerdade("p^q^r");
        TabelaVerdade t5_8 = new TabelaVerdade("pvq^r");
        TabelaVerdade t5_9 = new TabelaVerdade("p^qvr");

        TabelaVerdade t6_0 = new TabelaVerdade("~p^q^r");
        TabelaVerdade t6_1 = new TabelaVerdade("~p^qvr");
        TabelaVerdade t6_2 = new TabelaVerdade("~pvq^r");
        TabelaVerdade t6_3 = new TabelaVerdade("~pvqvr");
        TabelaVerdade t6_4 = new TabelaVerdade("p^~q^r");
        TabelaVerdade t6_5 = new TabelaVerdade("p^~qvr");
        TabelaVerdade t6_6 = new TabelaVerdade("pv~q^r");
        TabelaVerdade t6_7 = new TabelaVerdade("pv~qvr");
        TabelaVerdade t6_8 = new TabelaVerdade("p^q^~r");
        TabelaVerdade t6_9 = new TabelaVerdade("p^qv~r");
        TabelaVerdade t6_10 = new TabelaVerdade("pvq^~r");
        TabelaVerdade t6_11 = new TabelaVerdade("pvqv~r");
        TabelaVerdade t6_12 = new TabelaVerdade("p^q^~r");

        TabelaVerdade t7_0 = new TabelaVerdade("~p^~q^r");
        TabelaVerdade t7_1 = new TabelaVerdade("~p^~qvr");
        TabelaVerdade t7_2 = new TabelaVerdade("~pv~q^r");
        TabelaVerdade t7_3 = new TabelaVerdade("~pv~qvr");
        TabelaVerdade t7_4 = new TabelaVerdade("~p^q^~r");
        TabelaVerdade t7_5 = new TabelaVerdade("~p^qv~r");
        TabelaVerdade t7_6 = new TabelaVerdade("~pvq^~r");
        TabelaVerdade t7_7 = new TabelaVerdade("~pvqv~r");
        TabelaVerdade t7_8 = new TabelaVerdade("p^~q^~r");
        TabelaVerdade t7_9 = new TabelaVerdade("p^~qv~r");
        TabelaVerdade t7_10 = new TabelaVerdade("pv~q^~r");
        TabelaVerdade t7_11 = new TabelaVerdade("pv~qv~r");

        TabelaVerdade t8_0 = new TabelaVerdade("~p^~q^~r");
        TabelaVerdade t8_1 = new TabelaVerdade("~p^~qv~r");
        TabelaVerdade t8_2 = new TabelaVerdade("~pv~q^~r");
        TabelaVerdade t8_3 = new TabelaVerdade("~pv~qv~r");

    } // public static void main(String[] args)
} // public class TabelaVerdadeApplication
