package tdd.kata;

public class AlreadyOccupiedSlotException extends RuntimeException {
   public AlreadyOccupiedSlotException(String msg) {
      super(msg);
   }
}
