package bootcamp.creators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import interfaces.DateFormatable;

public abstract class Creator implements DateFormatable {
//    protected DateTimeFormatter formatter; 
//    protected String dateFormatStr;
    protected String nameInvalidMsg;
    protected String nameRegex;
    protected String titleInvalidMsg;
    protected String titleRegex;
    protected String dateInvalidMsg;
    
    public Creator() {
//        dateFormatStr = "dd/MM/yyyy";
//        formatter = DateTimeFormatter.ofPattern(dateFormatStr);
        nameInvalidMsg = "Only letters are allowed. Please enter a new value: ";
        nameRegex = "[a-zA-Z]+(\\s+[a-zA-Z]+)*";
        titleInvalidMsg = "Only letters, numbers, dashes, underscores and sharps are allowed. Please enter a new value: ";
        titleRegex = "[\\w\\s\\_#\\-]+(\\s+[\\w\\s\\_#\\-]+)*";
    }
//    private Creator(DateTimeFormatter formatter, String dateFormat) {
//        this();
//        this.formatter = formatter;
//        this.dateFormatStr = dateFormat;
//    }
    protected DateTimeFormatter getFormatter() {
        return formatter;
    }
    protected String getDateFormat() {
        return dateFormatStr;
    }
    protected String getInvalidDateAfterMsg(LocalDate minDate){
      return "Invalid date. Enter a valid date after " + minDate.format(formatter) + " (" + dateFormatStr + "): ";
    }
    protected String getInvalidDateBetweenMsg(String minDateStr, String maxDateStr){
        return String.format("Invalid date. Enter a valid date between %s and %s (%s): ", minDateStr, maxDateStr, dateFormatStr);
    }
    
}
