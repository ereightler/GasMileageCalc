import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Float> gasConsumedPerTank = new ArrayList<>();
        List<Float> milesDrivenPerTank = new ArrayList<>();
        List<Float> gasMileagePerTank = new ArrayList<>();
        String cont = "";
        int counter = 0;
        float averageMileage = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the gas consumed for each tank in sequence. " +
                "Enter 'N' when prompted if you would like to stop adding entries.");
        while(true){
            System.out.println("Enter the gas consumed for this tank.");
            gasConsumedPerTank.add(Float.parseFloat(scanner.nextLine()));
            System.out.println("Would you like to continue?");
            cont = scanner.nextLine().toUpperCase();
            if(cont.equals("N")){
                break;
            }
        }
        System.out.println("Now, please enter the miles driven per tank, in the same sequence as entered for gas consumed." +
                "Process will end once amount of entries matches the amount of entries in the list of tanks for the previous section.");
        while(true){
            counter++;
            System.out.println("Enter the miles driven for this tank");
            milesDrivenPerTank.add(Float.parseFloat(scanner.nextLine()));
            if(counter == gasConsumedPerTank.size()){
                break;
            }
        }
        for(int i = 0; i < gasConsumedPerTank.size(); i++){
            float mileage = milesDrivenPerTank.get(i)/gasConsumedPerTank.get(i);
            System.out.println("Mileage for tank " + (i + 1) + " is :" + mileage);
            gasMileagePerTank.add(mileage);
        }
        for(float mileage : gasMileagePerTank){
            averageMileage+= mileage;
        }
        averageMileage = averageMileage/gasMileagePerTank.size();
        System.out.println("The average mileage per tank is :" + averageMileage);
    }
}