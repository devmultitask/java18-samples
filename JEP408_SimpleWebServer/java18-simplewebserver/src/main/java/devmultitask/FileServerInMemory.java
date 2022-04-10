package devmultitask;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import com.google.common.jimfs.Configuration;
import com.google.common.jimfs.Jimfs;
import com.sun.net.httpserver.SimpleFileServer;

import static com.sun.net.httpserver.SimpleFileServer.OutputLevel;

/*
 * A Simple Web Server as in-memory server, using Jimfs (in-memory file system)
 * 
 * Original Source:
 * https://inside.java/2021/12/06/working-with-the-simple-web-server/
 */
public class FileServerInMemory {
	
    private static final int HTTP_PORT = 8000;
    
	private static final InetSocketAddress LOOPBACK_ADDR =
            new InetSocketAddress(InetAddress.getLoopbackAddress(), HTTP_PORT);
 
    public static void main( String[] args ) throws Exception {
    	
        Path root = createDirectoryHierarchy();
        var server = SimpleFileServer.createFileServer(LOOPBACK_ADDR, root, OutputLevel.VERBOSE);
        
        System.out.println("* Running Simple Web Server in Memory...");
        
        System.out.println("Please check:  http://127.0.0.1:"+HTTP_PORT);
        
        server.start();
    }

    private static Path createDirectoryHierarchy() throws IOException {
    	
    	System.out.println("* Creating directories and files...");
    	
        FileSystem fs = Jimfs.newFileSystem(Configuration.unix());
        Path root = fs.getPath("/");
 
        // creating some dirs
        Files.createDirectories(root.resolve("work"));
        Files.createDirectories(root.resolve("movies"));
        Files.createDirectories(root.resolve("billing"));
        Files.createDirectories(root.resolve("static"));
        
        // static files with index
        Files.writeString(root.resolve("static/index.html"), "<html><b>HTML</b>  ok !</html>");
        
        // IT TV shows
        Files.createDirectories(root.resolve("series/IT Crowd"));
        Files.createDirectories(root.resolve("series/Mr. Robot"));        
        Files.createDirectories(root.resolve("series/Halt and Catch Fire"));
        Files.createDirectories(root.resolve("series/Silicon Valley"));
        
        return root;
    }
}