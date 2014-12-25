package com.holdfast.mbide.j2mecompiler;

import java.io.File;


/**
 *
 * @author HoldFast
 */
public class Main {

    public static void main(String[] args) {
        Compiler comp = new Compiler();

        try {
            comp.compile("midpapi"+File.separator+"api.jar", "source"+File.separator, "compiled");            
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }
}
