package com.delrosario.stationeryms.serviceimpl;

import com.delrosario.stationeryms.entity.StationeryData;
import com.delrosario.stationeryms.model.Stationery;
import com.delrosario.stationeryms.repository.StationeryDataRepository;
import com.delrosario.stationeryms.service.StationeryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StationeryServiceImpl implements StationeryService {
    Logger logger = LoggerFactory.getLogger(StationeryServiceImpl.class);

    @Autowired
    StationeryDataRepository stationeryDataRepository;

    @Override
    public Stationery[] getStationery() {
        List<StationeryData> stationeriesData = new ArrayList<>();
        List<Stationery> stationeries = new ArrayList<>();
        stationeryDataRepository.findAll().forEach(stationeriesData::add);
        Iterator<StationeryData> it = stationeriesData.iterator();

        while(it.hasNext()) {
            Stationery stationery = new Stationery();
            StationeryData stationeryData = it.next();
            stationery.setId(stationeryData.getId());
            stationery.setName(stationeryData.getName());
            stationery.setDescription(stationeryData.getDescription());
            stationery.setCost(stationeryData.getCost());
            stationeries.add(stationery);
        }

        Stationery[] array = new Stationery[stationeries.size()];
        for  (int i = 0; i< stationeries.size(); i++){
            array[i] = stationeries.get(i);
        }
//        Employee[] array = (Employee[])employees.toArray();
        return array;
    }

    @Override
    public Stationery create(Stationery stationery) {
        logger.info("add: Input"+ stationery.toString());
        StationeryData stationeryData = new StationeryData();
        stationeryData.setName(stationery.getName());
        stationeryData.setDescription(stationery.getDescription());
        stationeryData.setCost(stationery.getCost());
        stationeryData = stationeryDataRepository.save(stationeryData);
        logger.info("add: Input"+ stationeryData.toString());

        Stationery newStationery = new Stationery();
        newStationery.setId(stationeryData.getId());
        newStationery.setName(stationeryData.getName());
        newStationery.setDescription(stationeryData.getDescription());
        newStationery.setCost(stationeryData.getCost());
        return newStationery;
    }

    @Override
    public Stationery update(Stationery stationery) {
        StationeryData stationeryData = new StationeryData();
        stationeryData.setId(stationery.getId());
        stationeryData.setName(stationery.getName());
        stationeryData.setDescription(stationery.getDescription());
        stationeryData.setCost(stationery.getCost());
        stationeryData = stationeryDataRepository.save(stationeryData);

        Stationery newStationery = new Stationery();
        newStationery.setId(stationeryData.getId());
        newStationery.setName(stationeryData.getName());
        newStationery.setDescription(stationeryData.getDescription());
        newStationery.setCost(stationeryData.getCost());
        return newStationery;
    }

    @Override
    public Stationery getStationery(Integer id) {
        logger.info("Input id >> "+  Integer.toString(id) );
        Optional<StationeryData> optional = stationeryDataRepository.findById(id);
        if(optional.isPresent()) {
            logger.info("Is present >> ");
            Stationery stationery = new Stationery();
            StationeryData employeeDatum = optional.get();
            stationery.setId(employeeDatum.getId());
            stationery.setName(employeeDatum.getName());
            stationery.setDescription(employeeDatum.getDescription());
            stationery.setCost(employeeDatum.getCost());
            return stationery;
        }
        logger.info("Failed  >> unable to locate employee" );
        return null;
    }

    @Override
    public void delete(Integer id) {
        logger.info("Input >> " + Integer.toString(id));
         Optional<StationeryData> optional = stationeryDataRepository.findById(id);
         if( optional.isPresent()) {
             StationeryData employeeDatum = optional.get();
             stationeryDataRepository.delete(employeeDatum);
             logger.info("Success >> " + employeeDatum.toString());
         }
         else {
             logger.info("Failed  >> unable to locate employee id: " +  Integer.toString(id));
         }
    }
}
