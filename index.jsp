<%-- 
    Document   : index hw4
    Created on : Nov 1, 2017, 1:14:14 AM
    Author     : William Nesham
--%>

<%@page import="java.util.Map"%>
<%@page import="com.nesham.ItemBean"%>
<%@page import="com.nesham.DataBean"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.nesham.OrderBean" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>William's Dvd Store</title>
        <meta charset="UTF-8">
        <link href="css/dvdStore.css" rel="stylesheet" type="text/css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <script type = "text/javascript">
            var item;
            function addToCart(){
               alert(item);
                
                return true;
            }
        </script>
    </head>
    <body>
        <% DataBean dataBean = new DataBean(); %>
        <h1>
            DVD list
        </h1>
	
        <form action = "HW4Servlet"  method = "post">
            
            <table>
                <tr>
                    <th> Cover </th>
                    <th> Title </th>
                    <th> Price </th>
                    <th>  </th>
                </tr>
                
                <%
                   Map<String, ItemBean> data = dataBean.getData();
                   for (Map.Entry<String,ItemBean> entry : data.entrySet()) {
                       ItemBean itemBean = entry.getValue();
                       out.println("<tr>");
                       out.println(String.format("<td><img src='%s' alt='%s'></td>", itemBean.getUrl(), itemBean.getTitle()));
                       out.println(String.format("<td>%s</td>", itemBean.getTitle()));
                       out.println(String.format("<td>$%.2f</td>", itemBean.getPriceFloat()));
                       out.println(String.format("<td><input type='submit' name='%s' value='Add To Cart' /> </td>", itemBean.getTitle()));
                       out.println("</tr>");
                    }
                %>
                
            </table>
            
	</form>
        
        
    </body>
</html>
