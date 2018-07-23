package app.retake.parser;

import app.retake.parser.interfaces.ModelParser;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;

@Component
public final class ModelParserImpl implements ModelParser {

    public ModelParserImpl() {

    }
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
