<%-- 
    Created on : Nov 1, 2017
    Author     : William Nesham
    For        : CS 4010 hw4
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.nesham.OrderBean" %>
<%@page import="com.nesham.ItemBean" %>
<%@page import="java.util.HashMap" %>
<%@page import="java.util.Map" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/dvdStore.css" rel="stylesheet" type="text/css">
        <title>Checkout Page</title>
        
        <!--
        Script to make back button.
        -->
        <script type = "text/javascript">
            function goBack() {
                window.history.back();
                //Clear Cart or empty cart. Go back to index. Or create new session?
            }
        </script>
    </head>
    <body>
        <h1>Thanks for your order</h1>
        
        <p>Here is the information that you entered:</p>
        
        <!--
        Java Bean
        -->
        <%
            
            OrderBean cartBean;
            cartBean = (OrderBean)session.getAttribute("cartId");
            
        %>   
            
        
        <table>
            
            <tr>
                <th> Cover </th>
                <th> Title </th>
                <th> Price </th>
                
            </tr>
            
<%
               
               Map<String, ItemBean> data = cartBean.getCart();
               for (Map.Entry<String,ItemBean> entry : data.entrySet()) {
                   ItemBean itemBean = entry.getValue();
                   out.println("<tr>");
                   out.println(String.format("<td><img src='%s' alt='%s'></td>", itemBean.getUrl(), itemBean.getTitle()));
                   out.println(String.format("<td>%s</td>", itemBean.getTitle()));//title
                   out.println(String.format("<td>$%.2f</td>", itemBean.getPriceFloat()));//price
                   out.println(String.format("<td>$%.2f</td>", (itemBean.getPriceFloat())*((float)itemBean.getQuantity()) ));//amount
                   out.println(String.format("<td><input type='number' value='%d' name='%s'>", itemBean.getQuantity(), itemBean.getTitle()));//Quantity
                  
                   out.println("</tr>");
                }
//               out.println("<tr>");
//               out.println("</tr>");
            %>
              
            <tr><td><b>Total</b></td><td>  </td><td>  </td><td> TOTAL </td><td>  </td></tr>  
              
        </table>
            
       
    </body>
</html>
