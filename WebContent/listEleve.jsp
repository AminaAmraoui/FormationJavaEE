<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html     xmlns:p="http://primefaces.org/ui">
<link rel="stylesheet" type="text/css" href="css/main.css" />
        <link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />


        <script src="js/jquery-1.12.2.min.js" type="text/javascript" ></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>

        <!-- Font Awesome -->
        <link rel="stylesheet" type="text/css" href="css/font-awesome.min.css"/>
       <link href="navbar.css" rel="stylesheet">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Liste Eleves</title>
</head>
<body>
<div class="jumbotron">
<div class="container">
        <h2>Liste des eleves</h2>
        <p>Vous pouvez lister, ajouter, modifier et supprimer des eleves.</p>
    </div>    
      </div>
    <table border=1 class="table table-striped">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nom</th>
                <th>Prenom</th>
                
                <th colspan=2>Action</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${eleves}" var="eleve">
                <tr>
                    <td><c:out value="${eleve.id}" /></td>
                    <td><c:out value="${eleve.nom}" /></td>
                    <td><c:out value="${eleve.prenom}" /></td>
                    
                    <td><a href="EleveController?action=edit&id=<c:out value="${eleve.id}"/>">Modifier</a></td>
                    <td><a href="EleveController?action=delete&id=<c:out value="${eleve.id}"/>">Supprimer</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
<!--     <p><a href="EleveController?action=insert" class="btn btn-primary btn-lg active" role="button" aria-pressed="true">Ajouter</a></p> -->
      <p style="text-indent: 5em;"><a href="EleveController?action=insert">Ajouter</a></p>
</body>
</html>