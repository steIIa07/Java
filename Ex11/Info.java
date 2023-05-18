public class Info {
    
    public String server;
    public String os;
    
    Info(String server, String os) {
        this.server = server;
        this.os = os;   
    }

    @Override
    public String toString() {
        return "Server Env: OS of" + server + "is" + os + ".";
        }
}
