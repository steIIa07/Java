import java.io.*;
import java.net.*;
import java.nio.charset.Charset;
import java.nio.file.*;


public class SimpleHTTPServer {

  private final int port;
  
  public SimpleHTTPServer(int port){    
    this.port = port; 
  }

  public void start() {
    try {
      // Start a ServerSocker
      // wait for connection
      ServerSocket serverSocket = new ServerSocket(port);

      Socket connection = serverSocket.accept();
      // then send the corresponding socket to an instance of Handler
      Handler handler = new Handler(connection);
        
      // and let it handle the request
      handler.start();
      serverSocket.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    
  }
  
    private class Handler {
      private final Socket connection;

      Handler(Socket connection) {
        this.connection = connection;
      }

      public void start() {
        try {
          // Get InputStream and OutputStream from the socket.
          //
          InputStream in = connection.getInputStream();
          OutputStream out = connection.getOutputStream();
          
          // 1. read the request from the client.
          BufferedReader reader = new BufferedReader(new InputStreamReader(in));
          
          // 2. if it is not starting by "GET" then ignore         
          // 3. otherwise, extract the file name from the request.
          // It will look like: "GET /filename.html HTTP/1.1"
          // You can split the string by whitespaces.
          String request = reader.readLine();
          if(request == null || !request.startsWith("GET")) 
            return;
          
          String[] tokens = request.split(" ");
          String fileName = tokens[1].substring(1);

          // 4. open the file and reads its content
          File file = new File(fileName);

          // 5. create an HTTP header
          if (!file.exists()) {
            String response = "HTTP/1.0 404 Not Found\r\n"
            + "Server: SimpleHTTPServer\r\n"
            + "Content-length: 0\r\n"
            + "Content-type: text/html"
            + "; charset=utf-8" + "\r\n\r\n";

            byte[] header = response.getBytes(Charset.forName("UTF-8"));
            
            out.write(header);
            out.flush();
          } else {
            byte[] content;
            content = Files.readAllBytes(file.toPath());
            
            String headerStr = "HTTP/1.0 200 OK\r\n"
            + "Server: SimpleHTTPServer\r\n"
            + "Content-length: " + content.length + "\r\n"
            + "Content-type: text/html"
            + "; charset=utf-8" + "\r\n\r\n";
            byte[] header = headerStr.getBytes(Charset.forName("UTF-8"));

            // 6. send the header then the content via the OutputStream
            out.write(header);
            out.write(content);
            out.flush();
          }

          connection.close();
        } catch (IOException e) {
          e.printStackTrace();
      }
    }
  }
  public static void main(String[] args) {
    int port;
    try {
      port = Integer.parseInt(args[0]);
      if (port < 1024 || port > 65535) port = 8080;
    } catch (RuntimeException ex) {
      port = 8080;
    }

    try {
      SimpleHTTPServer server = new SimpleHTTPServer(port);
      server.start();
        
    } catch (ArrayIndexOutOfBoundsException ex) {
      System.out.println("Usage: java SimpleHTTPServer [port]");
    }
   } 
}