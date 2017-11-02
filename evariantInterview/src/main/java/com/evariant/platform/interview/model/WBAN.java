package com.evariant.platform.interview.model;

import java.io.IOException;

import com.opencsv.CSVParser;

import groovyjarjarcommonscli.ParseException;

public class WBAN {
    private String wbanId;
    private CountyKey countyKey;

    public WBAN(String wbanId, CountyKey county) {
        this.wbanId = wbanId;
        this.countyKey = county;
    }

    public static WBAN parse(String row, CSVParser csvParser) throws ParseException, IOException {
        String[] fields = csvParser.parseLine(row);
        if (fields.length != 19) {
            throw new ParseException("can not parse: " + row);
        }
        String wbanId = fields[1];
        String state = fields[3].toLowerCase();
        String countyName = fields[4].toLowerCase();
        return new WBAN(wbanId, new CountyKey(countyName, state));
    }

    public String getWbanId() {
        return wbanId;
    }

    public CountyKey getCountyKey() {
        return countyKey;
    }

    @Override
    public String toString() {
        return "WBAN{" +
                "wbanId='" + wbanId + '\'' +
                ", countyKey=" + countyKey +
                '}';
    }
}
