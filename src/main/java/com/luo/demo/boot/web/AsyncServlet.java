package com.luo.demo.boot.web;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author xiangnan
 * date 2018/8/2 14:55
 */
@WebServlet(value = "/servlet", asyncSupported = true)
public class AsyncServlet extends HttpServlet {

    ExecutorService executor = Executors.newFixedThreadPool(2);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AsyncContext asyncContext = req.startAsync(req, resp);
        executor.execute(() -> {
            //耗时操作
            PrintWriter pw;
            try {
                pw = asyncContext.getResponse().getWriter();
                pw.print("done!");
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                asyncContext.complete();
            }
        });
    }

}
