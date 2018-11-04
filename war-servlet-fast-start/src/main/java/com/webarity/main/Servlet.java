package com.webarity.main;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.webarity.ejbModule.SomeEJBContract;

public class Servlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @EJB SomeEJBContract ejb;

    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        
        try (
            OutputStream os = rs.getOutputStream();
        ) {
            if (rq.getPathInfo() != null && rq.getPathInfo().compareTo("/") != 0) {
                rs.sendError(HttpServletResponse.SC_NOT_FOUND, String.format("NOT FOUND: %s", rq.getPathInfo()));
                return;
            }
            os.write("see README.md\n".getBytes());

            os.write(ejb.pong("test ejb"));

            os.flush();
        } catch (IOException ex) {
            ex.printStackTrace();
            try {
                rs.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            } catch (IOException e) { }
        }
    }

    /**
     * <p>Upload files from web client using:</p>
     * <blockquote><pre>
     * var data = new FormData();
     * data.append("a", 1);
     * data.append("b", 2);
     * 
     * var f = document.getElementById("fileInput") //this being an {@code<input type="file" id="fileInput" multiple />} 
     * Array.from(f.files).forEach(f => data.append(f.name, f);
     * 
     * var x = new XMLHttpRequest();
     * x.open("POST", "http://someAddress.com/");
     * x.send(data)
     * </pre></blockquote>
     */
    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) {

        try (PrintWriter w = rs.getWriter()) {
            w.print(String.format("Upload test parts count: " + rq.getParts().size()));
            w.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}