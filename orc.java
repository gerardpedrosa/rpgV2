public class orc extends personatge {

    public orc(String nom, int edat, double forca, double destresa, double constitucio, double inteligencia, double saviesa, double carisma) {
        super(nom, edat, forca + 3, destresa, constitucio + 1, inteligencia, saviesa, carisma);
    }

    @Override
    public void equiparArma(int index) {
        arma a = armes.get(index);

        if (a.getMagia()) {
            System.out.println("Els orcs no poden usar armes màgiques.");
            return;
        }

        super.equiparArma(index);
    }

    @Override
    public double atacar() {
        double dany = super.atacar();
        return dany * 1.1;
    }
}
