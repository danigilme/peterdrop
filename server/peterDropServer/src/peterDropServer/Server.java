package peterDropServer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.io.*;

import javax.xml.ws.*;
import javax.xml.ws.http.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

@WebServiceProvider
@ServiceMode(value = Service.Mode.PAYLOAD)
public class Server {

    public static void main(String[] args) throws InterruptedException {
    	//address
    	String address = "http://192.168.3.117:1150/";
    	
    	//connect
        Endpoint.create(HTTPBinding.HTTP_BINDING, new CoreConnect()).publish(address + "connect");
        
        //check 
        Endpoint.create(HTTPBinding.HTTP_BINDING, new CoreConnect()).publish(address + "check");
        
        //save
        Endpoint.create(HTTPBinding.HTTP_BINDING, new CoreConnect()).publish(address + "save");
        
        //out
        System.out.println("Service running at " + address);
        System.out.println("Type [CTRL]+[C] to quit!");
        
        Thread.sleep(Long.MAX_VALUE);
    }
}

