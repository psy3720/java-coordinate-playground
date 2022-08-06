package rentCompany;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RentCompanyTest {
    private static final String NEWLINE = System.getProperty("line.separator");

    @Test
    public void getChargeQuantity_Sonata() {
        RentCar car = new Sonata(150);
        double chargeQuantity = car.getChargeQuantity();
        assertThat(chargeQuantity).isEqualTo(15);
    }

    @Test
    public void getChargeQuantity_K5() {
        RentCar car = new K5(260);
        double chargeQuantity = car.getChargeQuantity();
        assertThat(chargeQuantity).isEqualTo(20);
    }

    @Test
    public void getChargeQuantity_Avante() {
        RentCar car = new Avante(300);
        double chargeQuantity = car.getChargeQuantity();
        assertThat(chargeQuantity).isEqualTo(20);
    }

    @Test
    public void report() throws Exception {
        RentCompany company = RentCompany.create();
        company.addCar(new Sonata(150));
        company.addCar(new K5(260));
        company.addCar(new Sonata(120));
        company.addCar(new Avante(300));
        company.addCar(new K5(390));

        String report = company.generateReport();
        assertThat(report).isEqualTo(
                "Sonata : 15리터" + NEWLINE +
                        "K5 : 20리터" + NEWLINE +
                        "Sonata : 12리터" + NEWLINE +
                        "Avante : 20리터" + NEWLINE +
                        "K5 : 30리터" + NEWLINE
        );
    }
}
