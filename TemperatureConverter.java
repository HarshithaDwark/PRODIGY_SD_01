import java.util.Scanner;

public class TemperatureConverter {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Enter temperature: ");
    double temperature = scanner.nextDouble();

    System.out.print("Enter unit (C, F, or K): ");
    String unit = scanner.next().toUpperCase();

   double convertedTemperature = convertTemperature(temperature, unit, 'C'); // Assuming you want to convert to Celsius by default


    if (Double.isNaN(convertedTemperature)) {
      System.out.println("Invalid unit. Please enter 'C', 'F', or 'K'.");
    } else {
      System.out.println(String.format("%.2f %s = %.2f C", temperature, unit, convertedTemperature));
      System.out.println(String.format("%.2f %s = %.2f F", temperature, unit, temperature)); // No conversion needed for same unit
      System.out.println(String.format("%.2f %s = %.2f K", temperature, unit, convertTemperature(temperature, unit, 'K')));
    }
  }

  public static double convertTemperature(double temperature, String unit, char targetUnit) {
    if (unit.equals("C") && targetUnit == 'F') {
      return (temperature * 9.0 / 5.0) + 32;
    } else if (unit.equals("C") && targetUnit == 'K') {
      return temperature + 273.15;
    } else if (unit.equals("F") && targetUnit == 'C') {
      return (temperature - 32) * 5.0 / 9.0;
    } else if (unit.equals("F") && targetUnit == 'K') {
      return (temperature - 32) * 5.0 / 9.0 + 273.15;
    } else if (unit.equals("K") && targetUnit == 'C') {
      return temperature - 273.15;
    } else if (unit.equals("K") && targetUnit == 'F') {
      return (temperature - 273.15) * 9.0 / 5.0 + 32;
    } else {
      System.out.println("Invalid unit. Please enter 'C', 'F', or 'K'.");
      return Double.NaN; // Not a Number
    }
  }
}
