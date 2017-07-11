package me.vukas.hibernate.hibernate;

import me.vukas.hibernate.domen.Enumeracija;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
//da li da ukljucimo apply za sve tipove Enumeracija, tako da ne moramo da ih anotiramo
//sa @Convert(converter = EnumConverter.class) anotacijom svudje dje se pojavljuju
public class EnumConverter implements AttributeConverter<Enumeracija, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Enumeracija enumeracija) {
        return enumeracija.getId();
    }

    @Override
    public Enumeracija convertToEntityAttribute(Integer integer) {
        return Enumeracija.fromId(integer);
    }
}
