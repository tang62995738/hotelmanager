package com.newer.Web.Servlet;

import com.google.gson.JsonObject;
import com.newer.domain.Checkins;
import com.newer.service.CheckinsService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

@WebServlet("/checkins")
public class CheckinsServlet extends HttpServlet {
    private CheckinsService checkinsService=new CheckinsService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        req.setCharacterEncoding("utf-8");
        Checkins checkins=new Checkins();
        try {
            BeanUtils.populate(checkins,req.getParameterMap());
            int rows=checkinsService.addCheckins(checkins);
            JsonObject jsonObject=new JsonObject();
            if(rows>0){
                jsonObject.addProperty("suc",true);
            }
            PrintWriter out=resp.getWriter();
            out.print(jsonObject);
            out.close();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
