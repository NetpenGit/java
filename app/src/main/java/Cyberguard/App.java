/*
 * This Java source file was generated by the Gradle 'init' task.
 */

package Cyberguard;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import static java.sql.DriverManager.println;
import org.apache.commons.io.IOUtils;
import xyz.capybara.clamav.ClamavClient;

public class App {
    
    
    
    public String getGreeting() {
        
        uta = "Hellow Word";
        return uta;
    }

    public static void main(String[] args)
    {      
        
  
        ClamavClient client = new ClamavClient("localhost");
        LogiinFrame login = new LogiinFrame();
        login.setVisible(true);
        
    }
    
    public static void scanStream(InputStream inputStream) throws IOException, NoSuchAlgorithmException {
        Socket socket = null;
        OutputStream outStream = null;
        InputStream inStream = null;
        try {
                socket = new Socket("localhost",3310);
                outStream = new BufferedOutputStream(socket.getOutputStream());
                socket.setSoTimeout(2000);
                outStream.write("zINSTREAM\0".getBytes(StandardCharsets.UTF_8));
                outStream.flush();
                byte[] buffer = new byte[2048];
                try {
                        inStream = socket.getInputStream();
                        int read = inputStream.read(buffer);
                        while (read >= 0) {
                                byte[] chunkSize = ByteBuffer.allocate(4).putInt(read).array();
                                outStream.write(chunkSize);
                                outStream.write(buffer, 0, read);
                                if (inStream.available() > 0) {
  
                                    byte[] reply = IOUtils.toByteArray(inStream);
                                    throw new IOException("Reply from server: " + new String(reply, StandardCharsets.UTF_8));
}
                                    read = inputStream.read(buffer);
 }
                                    outStream.write(new byte[]{0,0,0,0});
                                    outStream.flush();
                                    System.out.println(new String(IOUtils.toByteArray(inStream)));
 }                                  finally { }
 }                                  finally {
                                    try {
                                            if(socket != null)
                                            socket.close();
 }                                          catch (IOException e) {
                                                System.out.println("Exception occurred while closing socket = {} "+ e.getMessage());
 }
                                    try {
                                            if(inStream != null)
                                                inStream.close();
 }                                              catch(IOException e) {
                                                System.out.println("Exception occurred while closing input streams = {} "+ e.getMessage());
 }
                                    try {
                                            if(outStream != null)
                                                outStream.close();
 }                                              catch(IOException e) {
                                                System.out.println("Exception occurred while closing output streams = {} "+ e.getMessage());
 }
 }
 }
    
    private String uta;
   
}
