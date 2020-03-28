/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author orestis
 */
public interface DateFormatable {
    String dateFormatStr = "dd/MM/yyyy";
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(dateFormatStr);
}
