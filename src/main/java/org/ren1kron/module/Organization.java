package org.ren1kron.module;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Organization implements Validatable, Serializable {
    private long id;                                //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NonNull
    private String name;                            //Поле не может быть null, Строка не может быть пустой
    @NonNull
    private Coordinates coordinates;                //Поле не может быть null
    @NonNull
    private LocalDateTime creationDate;             //Поле не может быть null, Значение этого поля должно генерироваться автоматически при создании/подгружаться из файла при запуске приложения
    private int annualTurnover;                     //Значение поля должно быть больше 0
    private String fullName;                        //Поле может быть null
    private Integer employeesCount;                 //Поле может быть null, Значение поля должно быть больше 0
    private OrganizationType type;                  //Поле может быть null
    @NonNull
    private Address postalAddress;                  //Поле не может быть null

    @Override
    public boolean validate() {
        return false;
    }
}
