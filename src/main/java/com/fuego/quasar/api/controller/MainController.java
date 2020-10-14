package com.fuego.quasar.api.controller;

import com.fuego.quasar.api.dto.DataDto;
import com.fuego.quasar.api.dto.SatelliteDto;
import com.fuego.quasar.api.service.ISatelliteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @Autowired
    ISatelliteService satelliteService;

    private Map<String, SatelliteDto> data = new HashMap<>();

    @PostMapping(value = "/topsecret")
    @ResponseBody
    public DataDto getData(@RequestBody List<SatelliteDto> satellites) throws ResponseStatusException {
        DataDto out = null;
        SatelliteDto kenobi = null;
        SatelliteDto skywalker = null;
        SatelliteDto sato = null;

        for(SatelliteDto satelliteDto : satellites){
            String name = satelliteDto.getName();
            if("kenobi".equalsIgnoreCase(name)){
                kenobi = satelliteDto;
            }else if("skywalker".equalsIgnoreCase(name)){
                skywalker = satelliteDto;
            }else if("sato".equalsIgnoreCase(name)){
                sato = satelliteDto;
            }
        }

        if(kenobi == null || skywalker == null || sato == null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "The message or location cannot be estimate"
            );
        }else{
            out = new DataDto();
            out.setPosition(
                    satelliteService.getLocation(
                            kenobi.getDistance()
                           ,skywalker.getDistance()
                           ,sato.getDistance()
                    ));

            out.setMessage(
                    satelliteService.getMessage(
                            kenobi.getMessage()
                           ,skywalker.getMessage()
                           ,sato.getMessage()
                    ));
        }

        return out;
    }

    @PostMapping(value = "/topsecret_split/{satellite_name}")
    @ResponseBody
    public Response setDataSplit(@RequestBody SatelliteDto satelliteDto, @PathVariable String satellite_name){
        if("kenobi".equalsIgnoreCase(satellite_name)){
            data.put("kenobi", satelliteDto);
        }else if("skywalker".equalsIgnoreCase(satellite_name)){
            data.put("skywalker", satelliteDto);
        }else if("sato".equalsIgnoreCase(satellite_name)){
            data.put("sato", satelliteDto);
        }

        return Response.ok().build();
    }

    @GetMapping(value = "/topsecret_split")
    @ResponseBody
    public DataDto getDataSplit() throws ResponseStatusException{
        DataDto out = null;

        if(!data.containsKey("kenobi") || !data.containsKey("skywalker") || !data.containsKey("sato")){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "There is not enough information"
            );
        }else{
            out = new DataDto();
            out.setPosition(
                    satelliteService.getLocation(
                            data.get("kenobi").getDistance()
                            ,data.get("skywalker").getDistance()
                            ,data.get("sato").getDistance()
                    ));

            out.setMessage(
                    satelliteService.getMessage(
                            data.get("kenobi").getMessage()
                            ,data.get("skywalker").getMessage()
                            ,data.get("sato").getMessage()
                    ));
        }

        return out;
    }
}
