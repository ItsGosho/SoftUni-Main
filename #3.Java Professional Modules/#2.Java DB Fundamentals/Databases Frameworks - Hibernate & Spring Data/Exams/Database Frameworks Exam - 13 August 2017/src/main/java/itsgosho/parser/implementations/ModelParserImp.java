package itsgosho.parser.implementations;

import itsgosho.parser.interfaces.ModelParser;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;


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
