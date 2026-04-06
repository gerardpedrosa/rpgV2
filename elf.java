public class elf extends personatge {

    public elf(String nom, int edat, double forca, double destresa, double constitucio, double inteligencia, double saviesa, double carisma) {
        super(nom, edat, forca, destresa + 2, constitucio, inteligencia + 2, saviesa, carisma);
    }

    @Override
    public void regenerarMana() {
        double max = inteligencia * 30;
        mana += inteligencia * 3;
        if (mana > max) mana = max;
    }
}
