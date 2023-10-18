package edu.escuelaing.arep.app.apps;

import static spark.Spark.*;
/**
 * Hello world!
 *
 */
public class SparkSecure 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        port(5000);
        //API: secure(keystoreFilePath, keystorePassword, truststoreFilePath,
        //truststorePassword);
        secure("keystores/ecikeystore.p12", "123456", null, null); 
        get("/helloService",(req, res) -> "hello service");

    }
    private static int getPort(){
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 5000; //returns default port if heroku-port isn't set (i.e. on localhost)
    }
}
