package DesignPatternPractice;

public class ProxyDesignPattern {

    public static void main(String[] args) {

        Internet proxyInternet = new ProxyInternet();
        try{
            proxyInternet.connectTo("hostname.com");
            proxyInternet.connectTo("abc.com");
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}

interface Internet{
    void connectTo(String hostname) throws Exception;
}

class RealInternet implements Internet{

    @Override
    public void connectTo(String hostname) throws Exception {
        System.out.println("connecting to ---- " + hostname);
    }
}

class ProxyInternet implements Internet{

    Internet realInternet = new RealInternet();

    @Override
    public void connectTo(String hostname) throws Exception {

        if (hostname.equals("abc.com"))
        {
            throw new RuntimeException("Cannot connect to abc.com");
        }else {
            realInternet.connectTo(hostname);
        }

    }
}
