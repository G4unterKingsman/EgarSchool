package com.nogo.EgarSchool.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//Слой Трансфера с кривой валидацией (не работает при редактировании документа)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DTODocument {
    @NotEmpty(message = "Название не должно быть пустым")
    private String title;
    @Min(value = 1,message = "Номер не должен быть меньше 0")
    @NotNull(message = "Номер не должен быть пустым")
    private Long number;
    @NotEmpty(message = "Выберете тип документа")
    private String type;
    @Size(max = 5000, message = "Название не должно быть больше 5000 рублей")
    private String contentOfDoc;
}

