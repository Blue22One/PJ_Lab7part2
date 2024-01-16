package Ex2;

public class SetTobe extends InstrumentMuzical {
    private Tip_Tobe tip_tobe;
    private int nr_tobe;
    private int nr_cinele;

    public SetTobe() {
    }

    public SetTobe(String producator, float pret, Tip_Tobe tip_tobe, int nr_tobe, int nr_cinele) {
        super(producator, pret);
        this.tip_tobe = tip_tobe;
        this.nr_tobe = nr_tobe;
        this.nr_cinele = nr_cinele;
    }

    public Tip_Tobe getTip_tobe() {
        return tip_tobe;
    }

    public void setTip_tobe(Tip_Tobe tip_tobe) {
        this.tip_tobe = tip_tobe;
    }

    public int getNr_tobe() {
        return nr_tobe;
    }

    public void setNr_tobe(int nr_tobe) {
        this.nr_tobe = nr_tobe;
    }

    public int getNr_cinele() {
        return nr_cinele;
    }

    public void setNr_cinele(int nr_cinele) {
        this.nr_cinele = nr_cinele;
    }

    @Override
    public String toString() {
        return  super.toString() + ", SetTobe{" +
                "tip_tobe=" + tip_tobe +
                ", nr_tobe=" + nr_tobe +
                ", nr_cinele=" + nr_cinele +
                '}';
    }
}
