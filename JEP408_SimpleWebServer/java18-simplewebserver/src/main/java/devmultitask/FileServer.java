package devmultitask;

import java.net.InetSocketAddress;
import java.nio.file.Path;

import com.sun.net.httpserver.SimpleFileServer;
import com.sun.net.httpserver.SimpleFileServer.OutputLevel;

public class FileServer {

	private static final int HTTP_PORT = 8000;
	private static final String ROOT = System.getProperty("user.dir");

	public static void main(String[] args) {
  
		var server = SimpleFileServer.createFileServer(new InetSocketAddress(HTTP_PORT), Path.of(ROOT),
				OutputLevel.VERBOSE);

        System.out.println("* Running Simple Web Server...");
        
        System.out.println("Please check:  http://127.0.0.1:"+HTTP_PORT);
       
		server.start();
	}
}
