package org.softuni.mostwanted.parser.implementations;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.softuni.mostwanted.parser.interfaces.ModelParser;
import org.springframework.stereotype.Component;


public class ModelParserImp implements ModelParser {

    @Override
    public <S, D> D convert(S source, Class<D> destinationClass) {
        ModelMapper modelMapper = new ModelMapper();
        D result = modelMapper.map(source,destinationClass);
        return result;
    }

    @Override
    public <S, D> D convert(S source, Class<D> destinationClass, PropertyMap<S, D> propertyMap) {
        ModelMapper modelMapper  = new ModelMapper();
        modelMapper.addMappings(propertyMap);
        D result = modelMapper.map(source,destinationClass);
        return result;
    }
}
