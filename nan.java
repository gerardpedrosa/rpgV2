public class nan extends personatge {

    public nan(String nom, int edat, double forca, double destresa, double constitucio, double inteligencia, double saviesa, double carisma) {
        super(nom, edat, forca, destresa - 1, constitucio + 4, inteligencia, saviesa, carisma);
    }

    @Override
    public void regenerarVida() {
        double max = constitucio * 50;
        salut += constitucio * 4;
        if (salut > max) salut = max;
    }

    @Override
    public void rebreAtac(double dany, boolean defensant) {

        if (esquivar()) {
            System.out.println(nom + " esquiva l'atac!");
            return;
        }

        if (defensant) {
            dany *= 0.25;
        }

        salut -= dany;
        if (salut < 0) salut = 0;

        System.out.println(nom + " rep " + dany + " de dany.");
    }
}
