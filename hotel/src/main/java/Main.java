import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static void decrementDayLeft(ArrayList<Integer> remainingDays) {
        for (int roomNumber = 0; roomNumber < remainingDays.size(); roomNumber++) {
            int roomDayLeft = remainingDays.get(roomNumber);
            if (roomDayLeft == 0) continue;
            remainingDays.set(roomNumber, roomDayLeft - 1);
        }
    }

    public static void main(String[] args) {
        ArrayList<Integer> roomList = new ArrayList<Integer>(Arrays.asList(0,0,4,2,0,0,1));
        decrementDayLeft(roomList);
    }
}
