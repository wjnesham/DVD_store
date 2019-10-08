<%-- 
    Document   : cart
    Created on : Nov 1, 2017, 4:36:24 PM
    Author     : William
--%>

<%@page import="com.nesham.DataBean"%>
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
        <title>Cart Page</title>
        <script type = "text/javascript">
            function goBack() {
                window.history.back();
            }
            function updateCart(){
                //update Quantity and refresh page. If number == 0 remove item.
                alert("Update cart.");
                document.getElementById()
                
                cartBean.setQuantity()
                window.location.reload();
            }
            function removeItem(){
                //remove item (or set quantity to zero) and refresh the page
                alert("Remove item from Cart.");
            }
        </script>
    </head>
    
    <body>
       
        <h1>Your cart</h1>
        
        <!--
        Java Bean
        -->
        <%
            
            OrderBean cartBean;
            cartBean = (OrderBean)session.getAttribute("cartId");
            
        %>   
        
        <form action = "HW4Servlet"  method = "post">
        <table>
            <tr>
                <th> Cover </th>
                <th> Title </th>
                <th> Price </th>
                <th> Amount </th>
                <th> Quantity </th>
                <th>  </th>
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
                   out.println(String.format("<td><input type='number' value='%d' id='%s' min='0' max='999'>", itemBean.getQuantity(), itemBean.getTitle()));//Quantity
                   out.println(String.format("<input type='submit' name='UPDATE%s' value='Update' /> </td>", itemBean.getTitle()));//Update button
                   out.println(String.format("<td><input type='submit' name='REMOVE%s' value='Remove' /> </td>", itemBean.getTitle()));
                   out.println("</tr>");
                }
//               out.println("<tr>");
//               out.println("</tr>");
            %>
            
        </table>
            
        <p><b>To change the quantity</b>, enter the new quantity and click on the Update button.</p>
        
        
        <input type="submit" name="GOBACK" value="Continue Shopping">
        <br/>
        <input type="submit" name="CHECKOUT" value="Checkout">
        
        
        </form>
    </body>
</html>
