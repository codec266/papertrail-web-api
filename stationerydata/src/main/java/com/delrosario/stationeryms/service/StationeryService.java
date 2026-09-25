package com.delrosario.stationeryms.service;

import com.delrosario.stationeryms.model.Stationery;

public interface StationeryService {
    Stationery[] getStationery() throws Exception;

    Stationery getStationery(Integer id) throws Exception;

    Stationery create(Stationery product) throws Exception;

    Stationery update(Stationery product) throws Exception;

    void delete(Integer id) throws Exception;
}
