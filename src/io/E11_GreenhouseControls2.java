package io;

import innerclasses.controller.GreenhouseControls;

/**
 * @version 1.0
 * @Description:
 * @author: hxw
 * @date: 2019/2/15 17:37
 */
public class E11_GreenhouseControls2 {

    public static void main(String[] args) {
        GreenhouseControls2 gc = new GreenhouseControls2("GreenhouseConfig.dat");
        try {
            if(args.length == 1){
                gc.addEvent(new GreenhouseControls.Terminate(Long.parseLong(args[0])));
            }
        } catch(NumberFormatException e) {
            System.err.println("Terminate event is not added!");
            e.printStackTrace();
        }
        gc.run();
    }

}
