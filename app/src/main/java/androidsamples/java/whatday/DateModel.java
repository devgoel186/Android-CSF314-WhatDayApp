package androidsamples.java.whatday;

import androidx.annotation.NonNull;
import java.util.Calendar;

/**
 * Represents the date to be set, whether it is a valid date, and the message with error status or the day of the week.
 */
public class DateModel {
  private static String message;

  /*
  This method checks whether input data can be parsed as an integer or not.
  If not returns false, else returns true.
   */
  private static boolean isParsable(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch (final NumberFormatException e) {
      return false;
    }
  }

  /*
  This method checks for valid input date, month and year, and assigns an
  appropriate message based on the result.
   */
  private static boolean checkAndAssignMessage(int dateVal, int monthVal, int yearVal)
  {
    if(yearVal <= 0) {
      message = "Invalid year";
      return false;
    }

    else if(monthVal <= 0 || monthVal > 12) {
      message = "Invalid month";
      return false;
    }

    else if(dateVal <= 0 || dateVal > 31) {
      message = "Invalid date";
      return false;
    }

    else if(monthVal == 4 || monthVal == 6 || monthVal == 9 || monthVal == 11) {
      if (dateVal == 31) {
        message = "This month does not have 31 days";
        return false;
      }
    }

    else if(monthVal == 2) {
      if (dateVal >= 30) {
        message = "This month does not have " + dateVal + " days";
        return false;
      }

      else if (dateVal == 29) {
        if ((yearVal % 400 != 0 && yearVal % 100 == 0) || (yearVal % 4 != 0)) {
          message = "February of " + yearVal + " does not have 29 days";
          return false;
        }
      }
    }

    return true;
  }

  /**
   * Initializes the {@link DateModel} with the given year, month, and date.
   * If the date is not valid, it sets the appropriate error message.
   * If it is valid, it sets the appropriate day of the week message.
   *
   * @param yearStr  a {@code String} representing the year, e.g., "1947"
   * @param monthStr a {@code String} representing the month, e.g., "8"
   * @param dateStr  a {@code String} representing the date, e.g., "15"
   */
  public static void initialize(String yearStr, String monthStr, String dateStr) {
    int yearVal, monthVal, dateVal;

    if(isParsable(yearStr) && isParsable(monthStr) && isParsable(dateStr)) {
      yearVal = Integer.parseInt(yearStr);
      monthVal = Integer.parseInt(monthStr);
      dateVal = Integer.parseInt(dateStr);
    }
    else {
      message = "Enter values in a proper numeric format";
      return;
    }

    boolean flag = checkAndAssignMessage(dateVal, monthVal, yearVal);
    if(!flag)
      return;

    monthVal--;
    Calendar cal = Calendar.getInstance();
    cal.set(yearVal, monthVal, dateVal);
    int calculatedDay = cal.get(Calendar.DAY_OF_WEEK);

    switch (calculatedDay){
      case 1: message = "Sunday";
        break;
      case 2: message = "Monday";
        break;
      case 3: message = "Tuesday";
        break;
      case 4: message = "Wednesday";
        break;
      case 5: message = "Thursday";
        break;
      case 6: message = "Friday";
        break;
      case 7: message = "Saturday";
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + calculatedDay);
    }
  }

  /**
   * Retrieves the message from the {@link DateModel}.
   * It can be an error message like "February of 2019 does not have 29 days"
   * or a success message like "Friday".
   *
   * @return the message from the model
   */
  @NonNull
  public static String getMessage() {
    return message;
  }
}
