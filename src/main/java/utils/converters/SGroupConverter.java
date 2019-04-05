package utils.converters;

import entity.SGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import service.interfaces.ISGroupService;

public class SGroupConverter implements Converter<String, SGroup> {


    @Autowired
    ISGroupService service;

    public void setService(ISGroupService service) {
        this.service = service;
    }

    @Override
    public SGroup convert(String s) {
        return service.get(Integer.parseInt(s));
    }




}