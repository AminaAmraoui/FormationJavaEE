<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html     xmlns:p="http://primefaces.org/ui">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
    
<link rel="stylesheet" type="text/css" href="css/main.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />


        <script src="js/jquery-1.12.2.min.js" type="text/javascript" ></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>

        <!-- Font Awesome -->
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>

<title>Ajouter nouvel eleve</title>
</head>
<body>
   

    <form method="POST" action='EleveController' name="frmAddUser">
    
    <table>
    <tr>
    <td><h3><span class="label label-info">Eleve ID</span></h3></td>
    <td> <input type="text" readonly="readonly" name="id"
            value="<c:out value="${eleve.id}" />" /></td>
    </tr>
    <tr>
    <td><h3><span class="label label-info full-width">Nom </span></h3></td>
    <td><input
            type="text" name="nom"
            value="<c:out value="${eleve.nom}" />" /></td>
    </tr>
    <tr>
    <td><h3><span class="label label-info">Prenom  </span></h3></td>
    <td><input
            type="text" name="prenom"
            value="<c:out value="${eleve.prenom}" />" /></td>
    </tr>
    </table>
       
            
            
 <br><br>
            
         <input  type="submit" value="Submit" class="btn btn-sm btn-primary"/> 
         
    </form>
</body>
</html>