package com.fns.utility;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

public class FileDownloader {



    public static void writeFileToOutputStream(HttpServletResponse response, 
    		String fileName,
    		String contentType,
    		InputStream inputStream) throws IOException {
    	 OutputStream out = null;
        try {
            response.setHeader("Content-Disposition", "inline;filename=\"" +fileName+ "\"");
            out = response.getOutputStream();
            response.setContentType(contentType);
            IOUtils.copy(inputStream, out);
        } catch (IOException e) {
        	
        }finally{
        	if(out!=null){
	        	 out.flush();
	             out.close();
        	}
        }
    }
    
    public static void writeFileToOutputStream(HttpServletResponse response, String fileName,String contentType,Blob picture) throws IOException {
    	OutputStream out = null;
    	try {
            response.setHeader("Content-Disposition", "inline;filename=\"" +fileName+ "\"");
            out = response.getOutputStream();
            response.setContentType(contentType);
            IOUtils.copy(picture.getBinaryStream(), out);
      

        } catch (IOException e) {
        	
        } catch (SQLException e) {
        	
        }finally{
        	if(out!=null){
	        	 out.flush();
	             out.close();
       	}
       }
    }
    
}
