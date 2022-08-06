package rentCompany;

import java.util.ArrayList;
import java.util.List;

public class RentCompany {
    private static final String NEWLINE = System.getProperty("line.separator");
    private static RentCompany rentCompany;
    List<RentCar> carList;

    public RentCompany() {
        this.carList = new ArrayList<>();
    }

    public static RentCompany create() {
        if(null == rentCompany) {
            rentCompany = new RentCompany();
        }
        return rentCompany;
    }

    public void addCar(RentCar car) {
        carList.add(car);
    }

    public String generateReport() {
        StringBuilder result = new StringBuilder();

        for(RentCar car : carList) {
            result.append(car.getName())
                    .append(" : ")
                    .append(Math.round(car.getChargeQuantity()))
                    .append("리터")
                    .append(NEWLINE);
        }

        return result.toString();
    }
}
