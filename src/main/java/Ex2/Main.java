package Ex2;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Set<InstrumentMuzical> instr = new HashSet<InstrumentMuzical>();
        //----------------------------------------------------------------------------------------------------
        InstrumentMuzical i;
        i = new Chitara("Criman", 199.99F, TipChitara.valueOf("ACUSTICA"), 10);
        instr.add(i);
        i = new Chitara("Yamaha", 500, TipChitara.valueOf("CLASICA"), 15);
        instr.add(i);
        i = new Chitara("Yamaha", 3450.5F, TipChitara.valueOf("ELECTRICA"), 10);
        instr.add(i);
        //----------------------------------------------------------------------------------------------------
        i = new SetTobe("Roland", 2000, Tip_Tobe.valueOf("ACUSTICE"), 5, 5);
        instr.add(i);
        i = new SetTobe("Akai", 10000, Tip_Tobe.valueOf("ELECTRONICE"), 10, 5);
        instr.add(i);
        i = new SetTobe("Yamaha", 14999.99F, Tip_Tobe.valueOf("ELECTRONICE"), 7, 3);
        instr.add(i);

        scriere(instr);

        Set<InstrumentMuzical> instr2 = citire();
        for (InstrumentMuzical x : instr2) {
            System.out.println(x.toString());
        }

        i = new SetTobe("Yamaha", 14999.99F, Tip_Tobe.valueOf("ELECTRONICE"), 10, 3);

        for (InstrumentMuzical x : instr2) {
            if(x.toString().equals(i.toString()))
            {
                System.out.println("Fara duplicate!");
            }
        }
        System.out.println("------------------------------------------");
        instr2.removeIf(x->x.getPret()<3000);
        for (InstrumentMuzical x : instr2) {
            System.out.println(x.toString());
        }
        System.out.println("------------------------------------------");
        instr.stream()
                .filter(x -> x instanceof Chitara)
                .forEach(System.out::println);
        System.out.println("------------------------------------------");
        instr.stream()
                .filter(x->x.getClass().equals(SetTobe.class))
                .forEach(System.out::println);
        System.out.println("------------------------------------------");
        Optional<InstrumentMuzical> op = instr.stream()
                .filter(x -> x instanceof Chitara)
                .max(Comparator.comparing(InstrumentMuzical::getPret));
        if(op.isPresent())
        {
            System.out.println(op);
        }
        else
        {
            System.out.println("Nu avem chitare in set");
        }
        System.out.println("------------------------------------------");
        instr.stream()
                .filter(x->x instanceof SetTobe)
                .sorted(Comparator.comparing(x->((SetTobe) x).getNr_tobe()))
                .forEach(System.out::println);
    }

    public static void scriere(Set<InstrumentMuzical> instr) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            File file = new File("src/main/resources/instrumente.json");
            mapper.writeValue(file, instr);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public static Set<InstrumentMuzical> citire()
    {
        try
        {
            ObjectMapper mapper = new ObjectMapper();
            mapper.activateDefaultTyping(mapper.getPolymorphicTypeValidator());
            File file = new File("src/main/resources/instrumente.json");
            Set<InstrumentMuzical> instrumentMuzical = mapper.readValue(file, new TypeReference<HashSet<InstrumentMuzical>>() {});
            return instrumentMuzical;
        }
        catch (IOException exception)
        {
            exception.printStackTrace();
        }
        return null;
    }
}
