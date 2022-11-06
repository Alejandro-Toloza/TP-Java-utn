package neoris.app.jdbc;

public class MiShutdownHook extends Thread{

    @Override
    public void run(){
        MiJdbc.getInstance().disconnect();
        System.out.println("---Disconect---");
    }

}
