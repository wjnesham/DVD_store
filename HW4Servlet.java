/*
 * @author William Nesham
 * CS4010 HW2
 * date 30/09/2017
 */
package com.nesham;

import java.io.IOException;
import java.io.PrintWriter;
//import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HW4Servlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger( HW4Servlet.class.getName() );
    private static final DataBean dataBean = new DataBean();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
               throws ServletException, IOException {
        
        
        
          String paramName=null;
          ItemBean itemBean=null;
          OrderBean cartBean;
          boolean isRemove=false;
          Enumeration<String> parameterNames = request.getParameterNames();
          while (parameterNames.hasMoreElements()) {
              paramName = parameterNames.nextElement();
              
              if(paramName.startsWith("REMOVE")) {
                  paramName = paramName.substring(6, paramName.length());
                  isRemove = true;
              }
              
              if(paramName.startsWith("UPDATE")) {
                  paramName = paramName.substring(6, paramName.length());
                  isRemove = false;
              }
              //continue shopping
              if(paramName.startsWith("GOBACK")) {
                  request.getRequestDispatcher("index.jsp").forward(request, response);
                  return;
              }
              if(paramName.startsWith("CHECKOUT")) {
                  request.getRequestDispatcher("order.jsp").forward(request, response);
                  return;
              }
              if(paramName.startsWith("RETURN")) {
                   request.getSession().invalidate();
                  request.getRequestDispatcher("index.jsp").forward(request, response);
                  return;
              }
              itemBean = dataBean.getItemByTitle(paramName);
          }
          if(itemBean == null) {
              itemBean = new ItemBean();
              LOGGER.log( Level.SEVERE, "{0}", "ItemBean is null" );
              PrintWriter out = response.getWriter();
              out.write("ItemBean is null, check data connection");
              return;
          }
         cartBean = (OrderBean)request.getSession().getAttribute("cartId");
         if(cartBean == null){
            cartBean = new OrderBean();
            request.getSession().setAttribute("cartId", cartBean); // add to session
         }
         if(isRemove) {
             itemBean = cartBean.getItemByTitle(paramName);
             if(itemBean == null) {
                 PrintWriter out = response.getWriter();
                 out.write("ItemBean is null, check data connection");
                 return;
             }
//             if(itemBean.getQuantity() < 2) {
            cartBean.removeItem(itemBean);
//             } else {
               //  itemBean.setQuantity(itemBean.getQuantity() - 1);
             //}
         } else {
            cartBean.addItemToCart(itemBean);
         } 
         
    
         request.setAttribute("dvdOrder", cartBean);
//         request.setAttribute("cartId", cartBean);//new one
         request.getRequestDispatcher("cart.jsp").forward(request, response);              
            
         

    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

}
