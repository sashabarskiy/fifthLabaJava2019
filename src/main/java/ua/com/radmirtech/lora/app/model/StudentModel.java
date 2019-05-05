package ua.com.radmirtech.lora.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StudentModel {

    Long id;

    String name;

    String surname;

    String group;

    Integer mark;

}
