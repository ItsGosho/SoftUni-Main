package com.masdefect.parser;

import com.masdefect.parser.interfaces.ModelParser;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;

@Component
public class ModelParserImpl implements ModelParser {
    @Override
    public <S, D> D convert(S source, Class<D> destinationClass) {
        ModelMapper modelMapper=new ModelMapper();
        D classToReturn= modelMapper.map(source,destinationClass);
       return classToReturn;
    }

    @Override
    public <S, D> D convert(S source, Class<D> destinationClass, PropertyMap<S, D> propertyMap) {
        ModelMapper modelMapper=new ModelMapper();
        modelMapper.addMappings(propertyMap);
        D classToReturn=modelMapper.map(source,destinationClass);
        return classToReturn;
    }
}
