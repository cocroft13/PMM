package com.tcpserver;

import java.io.*;


public class TCPServer extends Thread {

    public static final int SERVERPORT = 4444;
    private boolean running = false;
    private PrintWriter mOut;
    private OnMessageReceived messageListener;

    public static void main(String[] args){


        //abrir la ventana donde se reciben y envian mensajes














    }

    public TCPServer(OnMessageReceived messageListener){
        this.messageListener = messageListener;
    }



    public interface OnMessageReceived{
        public void messageReceived(String message);

    }

}
