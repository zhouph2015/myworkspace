package com.evariant.platform.msawetness;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.evariant.platform.interview.etl.CalculateWetnessPerMSAETL;
import com.evariant.platform.interview.model.MSAWetness;


/**
 * Created by Peter Zhou on 06/10/2017
 */
public class Main {

    private static Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {

      /*  if (args.length != 4) {
            throw new IllegalArgumentException();
        }*/
    	
        System.out.println("Testing");
        logger.error("good");

/*   List<MSAWetness> calculate = CalculateWetnessPerMSAETL.calculate(args[0], args[1], args[2], args[3]);
        //printing the result
        calculate.stream().forEach(System.out::println);*/

    }


}

